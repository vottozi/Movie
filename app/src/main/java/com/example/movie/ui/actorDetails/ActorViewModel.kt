package com.example.movie.ui.actorDetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.movie.domain.enums.HomeItemsType
import com.example.movie.domain.usecases.GetActorDetailsUseCase
import com.example.movie.domain.usecases.GetActorMoviesUseCase
import com.example.movie.ui.adapters.MovieInteractionListener
import com.example.movie.ui.base.BaseViewModel
import com.example.movie.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActorViewModel @Inject constructor(
    state: SavedStateHandle,
    private val getActorDetailsUseCase: GetActorDetailsUseCase,
    private val getActorMoviesUseCase: GetActorMoviesUseCase,
    private val actorDetailsUIMapper: ActorDetailsUIMapper,
    private val actorMoviesUIMapper: ActorMoviesUIMapper
) : BaseViewModel(), MovieInteractionListener {

    val args = ActorDetailsFragmentArgs.fromSavedStateHandle(state)

    private val _actorDetailsUIState = MutableStateFlow(ActorDetailsUIState())
    val actorDetailsUIState = _actorDetailsUIState.asStateFlow()

    private val _actorDetailsUIEvent: MutableStateFlow<Event<ActorDetailsUIEvent?>> =
        MutableStateFlow(Event(null))
    val actorDetailsUIEvent = _actorDetailsUIEvent.asStateFlow()

    init {
        getData()
    }

    override fun getData() {
        _actorDetailsUIState.update { it.copy(isLoading = true, error = emptyList()) }
        viewModelScope.launch {
            try {
                val actorDetails = actorDetailsUIMapper.map(getActorDetailsUseCase(args.id))
                val actorMovies = getActorMoviesUseCase(args.id).map { actorMoviesUIMapper.map(it) }
                _actorDetailsUIState.update {
                    it.copy(
                        name = actorDetails.name,
                        gender = actorDetails.gender,
                        imageUrl = actorDetails.imageUrl,
                        placeOfBirth = actorDetails.placeOfBirth,
                        biography = actorDetails.biography,
                        birthday = actorDetails.birthday,
                        knownFor = actorDetails.knownFor,
                        actorMovies = actorMovies,
                        isLoading = false,
                        isSuccess = true
                    )
                }
            } catch (e: Exception) {
                onError(e.message.toString())
            }
        }
    }

    private fun onError(message: String) {
        _actorDetailsUIState.update { actorDetailsUIState ->
            actorDetailsUIState.copy(
                isLoading = false,
                error = listOf(Error(message)),
            )
        }
    }

    fun onClickBack() {
        _actorDetailsUIEvent.update { Event(ActorDetailsUIEvent.BackEvent) }
    }

    override fun onClickMovie(movieId: Int) {
        _actorDetailsUIEvent.update { Event(ActorDetailsUIEvent.ClickMovieEvent(movieId)) }
    }

    override fun onClickSeeAllMovie(homeItemsType: HomeItemsType) {
        _actorDetailsUIEvent.update { Event(ActorDetailsUIEvent.SeeAllMovies) }
    }

}
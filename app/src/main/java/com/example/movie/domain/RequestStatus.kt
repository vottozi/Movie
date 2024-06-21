package com.example.movie.domain

sealed class RequestStatus {
    object Success : RequestStatus()
    data class Failure(val message: String) : RequestStatus()
}
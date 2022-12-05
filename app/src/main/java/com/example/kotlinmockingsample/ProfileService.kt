package com.example.kotlinmockingsample

// Service interface used to mock the object and its behavior
interface ProfileServiceInterface {
    fun isLoggedIn(userID: Int): Boolean
    fun getProfile(userID: Int): Profile
}

// Service class that retrieves data from the network or database
class ProfileService: ProfileServiceInterface {
    override fun isLoggedIn(userID: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getProfile(userID: Int): Profile {
        TODO("Not yet implemented")
    }
}
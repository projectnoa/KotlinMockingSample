package com.example.kotlinmockingsample

class ProfileLogic(private val profileService: ProfileServiceInterface) {

    // Profile retrieval and processing logic
    fun retrieveProfile(): Profile {
        val profileId = 1

        if (profileService.isLoggedIn(profileId)) {
            return profileService.getProfile(profileId)
        } else {
            throw IllegalStateException("Profile is not available")
        }
    }
}
package com.example.kotlinmockingsample

import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

class MockingUnitTest {
    @Test
    fun profileDataIsMocked() {
        // Create a mock of the service interface. Notice that you cannot mock the actual class since all classes are final in Kotlin
        val mockProfileService = Mockito.mock(ProfileServiceInterface::class.java)
        // Define the behavior of the mocked service
        Mockito.`when`(mockProfileService.isLoggedIn(1)).thenReturn(true)
        Mockito.`when`(mockProfileService.getProfile(1)).thenReturn(Profile("Juan", "Mueller", 30, "This is a cool app!"))
        // Trigger the behavior
        ProfileLogic(mockProfileService).retrieveProfile()
        // Verify if the mock behaved as expected
        Mockito.verify(mockProfileService).isLoggedIn(1)
        Mockito.verify(mockProfileService).getProfile(1)
    }

    @Test
    fun profileDataIsRetrieved() {
        // Create a seed profile to test
        val seedProfile = Profile("Juan", "Mueller", 30, "This is a cool app!")
        // Create a mock of the service interface. Notice that you cannot mock the actual class since all classes are final in Kotlin
        val mockProfileService = Mockito.mock(ProfileServiceInterface::class.java)
        // Define the behavior of the mocked service
        Mockito.`when`(mockProfileService.isLoggedIn(1)).thenReturn(true)
        Mockito.`when`(mockProfileService.getProfile(1)).thenReturn(seedProfile)
        // Trigger the behavior
        val profileData = ProfileLogic(mockProfileService).retrieveProfile()
        // Confirm your assumptions
        Assert.assertEquals(profileData, seedProfile)
    }
}
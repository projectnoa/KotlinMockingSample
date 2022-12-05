package com.example.kotlinmockingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // Declare the view elements references
    lateinit var firstNameText: TextView
    lateinit var lastNameText: TextView
    lateinit var ageText: TextView
    lateinit var summaryText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Instantiate view elements references
        firstNameText = findViewById(R.id.firstName)
        lastNameText = findViewById(R.id.lastName)
        ageText = findViewById(R.id.age)
        summaryText = findViewById(R.id.summary)
        // Trigger the load profile
        loadProfile()
    }

    private fun loadProfile() {
        // Instantiate the profile service
        val profileService = ProfileService()
        // Instantiate the profile logic
        val profileLogic = ProfileLogic(profileService)
        // Retrieve the profile data from the service
        val profileData = profileLogic.retrieveProfile()
        // Populate the view elements
        firstNameText.text = profileData.firstName
        lastNameText.text = profileData.lastName
        ageText.text = profileData.age.toString()
        summaryText.text = profileData.summary
    }
}
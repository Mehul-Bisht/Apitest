package com.example.apitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launchWhenStarted {

            withContext(Dispatchers.IO) {

                val apii = Retro().retro.create(api::class.java)
                val res = apii.get(
                    longLat = "40.7,-74",
                    date = "20210715" // date format is: YYYYMMDD
                )

                // get names and locations of all venues
                res.response.venues.forEach {

                    val location = it.location
                    val name = it.name

                    Log.d("name ",name)
                    Log.d("location ","""
                        $location
                    """.trimIndent())
                }
            }
        }
    }
}
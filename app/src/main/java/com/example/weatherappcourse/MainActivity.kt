package com.example.weatherappcourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherappcourse.Fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction().replace(R.id.pllace_holder, MainFragment.newInstance()).commit()
    }
}
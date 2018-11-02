package com.example.maichel.submission2.main

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.maichel.submission2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val viewPager = findViewById<View>(R.id.viewPager_main) as ViewPager
        //viewPager.adapter = ViewPagerAdapter(fm)
        viewPager_main.adapter = ViewPagerAdapter(supportFragmentManager)
        tabs_main.setupWithViewPager(viewPager_main as ViewPager?)
    }
}
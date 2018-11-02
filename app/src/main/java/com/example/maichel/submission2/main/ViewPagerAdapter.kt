package com.example.maichel.submission2.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.maichel.submission2.Fragment.Last15Match
import com.example.maichel.submission2.Fragment.Next15Matxh

class ViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    private val pages = listOf(
        Last15Match(),
        Next15Matxh()
    )
    override fun getItem(position: Int): Fragment {
        return pages[position] as Fragment
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Next 15 Match"
            else -> "Last 15 Match"
        }
    }
}
package com.example.maichel.submission2.main

import com.example.maichel.submission2.model.next15Match

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<next15Match>)
}
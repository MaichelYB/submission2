package com.example.maichel.submission2.main

import android.view.View
import com.example.maichel.submission2.api.ApiRepository
import com.example.maichel.submission2.api.SportDBApi
import com.example.maichel.submission2.model.n15MatchResponse
import com.google.gson.Gson
import org.jetbrains.anko._LinearLayout
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter (private val view: MainView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson){

    fun getn15Match(league: String?){
        view. showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(SportDBApi.getn15Match(league)),
                n15MatchResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.events)
                //data.n15Match?.let { it1 -> view.showTeamList(it1) }
            }
        }
    }

    fun getl15Match(league: String?){
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(SportDBApi.getl15Match(league)),
                n15MatchResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.events)
            }
        }
    }
}
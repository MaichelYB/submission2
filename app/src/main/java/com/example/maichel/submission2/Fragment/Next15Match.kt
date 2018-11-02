package com.example.maichel.submission2.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar

import com.example.maichel.submission2.R
import com.example.maichel.submission2.api.ApiRepository
import com.example.maichel.submission2.main.MainAdapter
import com.example.maichel.submission2.main.MainPresenter
import com.example.maichel.submission2.main.MainView
import com.example.maichel.submission2.model.next15Match
import com.example.maichel.submission2.util.invisible
import com.example.maichel.submission2.util.visible
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Next15Matxh : Fragment(), MainView {
    private var teams: MutableList<next15Match> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    private lateinit var listTeam: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout

    companion object {
        fun newInstance() : Next15Matxh{
            return Next15Matxh()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return UI{
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                orientation = LinearLayout.VERTICAL
                topPadding = dip(16)
                leftPadding = dip(16)
                rightPadding = dip(16)
                swipeRefresh = swipeRefreshLayout {
                    setColorSchemeResources(
                        R.color.colorAccent,
                        android.R.color.holo_green_light,
                        android.R.color.holo_orange_light,
                        android.R.color.holo_red_light)

                    relativeLayout{
                        lparams (width = matchParent, height = wrapContent)
                        listTeam = recyclerView {
                            lparams (width = matchParent, height = wrapContent)
                            layoutManager = LinearLayoutManager(ctx)
                        }

                        progressBar = progressBar {
                        }.lparams{
                            centerHorizontally()
                        }
                    }
                }
            }
        }.view

        adapter = MainAdapter(teams)
        listTeam.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()
        presenter = MainPresenter(this, request, gson)
        val alamat: String = "4328"
        presenter.getn15Match(alamat)
        swipeRefresh.onRefresh {
            presenter.getn15Match(alamat)
        }
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showTeamList(data: List<next15Match>) {
        swipeRefresh.isRefreshing = false
        teams.clear()
        teams.addAll(data)
        adapter.notifyDataSetChanged()
    }
}
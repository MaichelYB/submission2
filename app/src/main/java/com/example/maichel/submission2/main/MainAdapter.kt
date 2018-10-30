package com.example.maichel.submission2.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.maichel.submission2.R.id.team_name
import com.example.maichel.submission2.model.next15Match
import org.jetbrains.anko.*

class MainAdapter(private val n15Match: List<next15Match>)
    :RecyclerView.Adapter<TeamViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(TeamUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = n15Match.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(n15Match[position])
    }

}

class TeamUI: AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                textView{
                    id = team_name
                    textSize = 16f
                }.lparams{
                    margin = dip(15)
                }
            }
        }
    }
}

class TeamViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val teamName: TextView = view.find(team_name)

    fun bindItem(teams: next15Match){
        teamName.text = teams.event
    }
}
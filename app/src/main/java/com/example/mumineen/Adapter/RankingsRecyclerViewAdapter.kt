package com.example.mumineen.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.mumineen.Model.Player
import com.example.mumineen.R
import kotlinx.android.synthetic.main.ranking_item_view.view.*

class RankingsRecyclerViewAdapter(val context: Context, val players : List<Player>) : RecyclerView.Adapter<RankingsRecyclerViewAdapter.RankingsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingsViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.ranking_item_view, parent, false)
        return RankingsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return players.size
    }

    override fun onBindViewHolder(holder: RankingsViewHolder, position: Int) {

        val player = players[position]

        holder.playerName.text = player.playerName
        holder.playerPoints.text = player.totalPoints.toString()
    }

    inner class RankingsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val playerName = itemView.playerNameRankingTxt
        val playerPoints = itemView.playerPointsRankingTxt
    }
}
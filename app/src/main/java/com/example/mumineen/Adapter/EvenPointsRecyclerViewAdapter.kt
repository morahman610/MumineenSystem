package com.example.mumineen.Adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mumineen.Model.Player
import com.example.mumineen.R
import kotlinx.android.synthetic.main.event_attendance_item_view.view.*

class EvenPointsRecyclerViewAdapter(val context: Context, val players: List<Player>) : RecyclerView.Adapter<EvenPointsRecyclerViewAdapter.EventPointsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventPointsViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return players.size
    }

    override fun onBindViewHolder(holder: EventPointsViewHolder, position: Int) {

        holder.eventPlayerName.text = players[position].playerName


    }

    inner class EventPointsViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

        val eventPlayerName = itemView.eventPlayerName
        val addEventPointsButton = itemView.addEventPointsButton
    }
}
package com.example.mumineen.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mumineen.Model.Player
import com.example.mumineen.R
import kotlinx.android.synthetic.main.event_points_item_view.view.*
import java.util.*

class EventPointsRecyclerViewAdapter(val context: Context, val playerArrayList: ArrayList<Player>) : RecyclerView.Adapter<EventPointsRecyclerViewAdapter.ViewHolder>() {

    lateinit var mListener : OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.event_points_item_view, parent, false)
        val viewHolder = ViewHolder(view, mListener)

        return viewHolder
    }

    override fun getItemCount(): Int {
        return playerArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.playerName.text = playerArrayList[position].playerName
    }

    fun setOnItemClickListener(listener : OnItemClickListener) {
        mListener = listener
    }


    interface OnItemClickListener {
        fun OnAddPointClick(test: Int)
    }

    inner class ViewHolder(itemView : View, listener : OnItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val playerName = itemView.eventPointsPlayerNameTxt
        val addPointsBtn = itemView.eventPointsAddPointsBtn

        init {
            addPointsBtn.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    listener.OnAddPointClick(adapterPosition)
                }
            }
        }
    }
}
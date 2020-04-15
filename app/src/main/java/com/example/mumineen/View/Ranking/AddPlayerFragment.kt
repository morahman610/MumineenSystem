package com.example.mumineen.View.Ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.mumineen.Model.Player
import com.example.mumineen.R
import com.example.mumineen.ViewModel.EventsViewModel
import kotlinx.android.synthetic.main.fragment_add_player.*
import kotlinx.android.synthetic.main.fragment_ranking.*
import kotlinx.android.synthetic.main.fragment_ranking.addPlayerBtn

class AddPlayerFragment : Fragment() {


    lateinit var eventsViewModel : EventsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_player, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        eventsViewModel = ViewModelProviders.of(activity!!).get(EventsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addPlayerBtn = addPlayerBtn
        addPlayerBtn.setOnClickListener {

            val newPlayer = Player()
            newPlayer.playerName = newPlayerNameEditTxt.text.toString()
            newPlayer.playerTeam = newPlayerTeamEditTxt.text.toString()
            eventsViewModel.insertPlayer(newPlayer)
        }
    }
}
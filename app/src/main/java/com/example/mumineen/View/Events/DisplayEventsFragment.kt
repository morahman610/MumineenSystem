package com.example.mumineen.View.Events

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mumineen.Adapter.EventsRecyclerViewAdapter
import com.example.mumineen.Model.Event
import com.example.mumineen.R
import com.example.mumineen.ViewModel.EventsViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.Scope
import com.google.api.services.sheets.v4.SheetsScopes
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class DisplayEventsFragment : Fragment() {
    //ViewModel
    var eventsViewModel: EventsViewModel? = null

    //Views

    private var addEventDialogBtn: Button? = null
    private val dbtest: TextView? = null

    //CompositeDisposable
    var compositeDisposable = CompositeDisposable()
    var navController: NavController? = null

    companion object {
        private const val REQUEST_SIGN_IN = 1
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_events, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventsViewModel = ViewModelProviders.of(this).get(EventsViewModel::class.java)
        navController = Navigation.findNavController(view)
        initCreateEventButton()
        allEvents
    }

    private fun initCreateEventButton() {
        val addEventDialogBtn = requireView().findViewById<Button>(R.id.addEventBtn)
        addEventDialogBtn.setOnClickListener(View.OnClickListener { })
    }

    private val allEvents: Unit
        private get() {
            val disposable = eventsViewModel!!.allEvents.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ modelClass: List<Event> ->
                        Log.d(ContentValues.TAG, "++SUBSCRIBED++ getAllEvents")
                        if (modelClass.size > 0) {
                            initRecyclerView(modelClass as ArrayList<Event>)
                        }
                    }) { e: Throwable -> e.message }
            compositeDisposable.add(disposable)
        }

    private fun initRecyclerView(eventArrayList: ArrayList<Event>) {
        val eventsRecyclerView: RecyclerView = requireView().findViewById(R.id.eventsRecyclerView)
        val eventsRecyclerViewAdapter = EventsRecyclerViewAdapter(activity, eventArrayList)
        eventsRecyclerView.layoutManager = LinearLayoutManager(activity)
        eventsRecyclerView.adapter = eventsRecyclerViewAdapter
        eventsRecyclerViewAdapter.setOnItemClickListener { position ->
            //   Bundle bundle = new Bundle();
            //  bundle.putString("eventName", eventArrayList.get(position).eventName);
            // bundle.putInt("eventPoints", eventArrayList.get(position).pointsAvailable);
            val action = DisplayEventsFragmentDirections.toEventPointsFragment()
            action.eventName = eventArrayList[position].eventName
            action.eventPoints = eventArrayList[position].pointsAvailable
            Navigation.findNavController(requireView()).navigate(action)
            // navController.navigate(R.id.toEventPointsFragment);
        }
    }
}
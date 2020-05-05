package com.example.mumineen.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mumineen.Model.Event;
import com.example.mumineen.R;

import java.util.ArrayList;

public class EventsRecyclerViewAdapter extends RecyclerView.Adapter<EventsRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "EventsRecyclerViewAdapter";

    private Context context;
    private ArrayList<Event> eventArrayList;
    private OnItemClickListener mListener;

    public EventsRecyclerViewAdapter(Context context, ArrayList<Event> eventArrayList) {
        this.eventArrayList = eventArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item_view, parent, false);
        ViewHolder holder = new ViewHolder(view, mListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.eventNameTxt.setText(eventArrayList.get(position).eventName);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.OnItemClicked(position);
                        Log.d("EventsRecyclerView", "onClick" );
                    }
                }
                Log.d("onBindViewHolder", "itemClicked");
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView eventNameTxt;

        public ViewHolder(@NonNull View itemView, OnItemClickListener listener ) {
            super(itemView);
            eventNameTxt = itemView.findViewById(R.id.eventNameTxt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public interface OnItemClickListener {
        public void OnItemClicked(int position);
    }
}

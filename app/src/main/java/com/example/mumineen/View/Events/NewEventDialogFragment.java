package com.example.mumineen.View.Events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mumineen.Model.Event;
import com.example.mumineen.R;
import com.example.mumineen.ViewModel.EventsViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class NewEventDialogFragment extends DialogFragment implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "NewEventDialogFragment";

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    //Widgets
    private EditText nameEditTxt;
    private EditText pointsEditTxt;
    private Spinner eventDaySpinner;
    private Button createNewEventBtn;

    //ViewModel
    EventsViewModel eventsViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_event, container, false);

        nameEditTxt = view.findViewById(R.id.nameEditTxt);
        pointsEditTxt = view.findViewById(R.id.pointsEditTxt);
        createNewEventBtn = view.findViewById(R.id.createNewEventBtn);
        eventDaySpinner = view.findViewById(R.id.eventDaySpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.Weekdays, android.R.layout.simple_spinner_item);
        eventDaySpinner.setAdapter(adapter);
        eventDaySpinner.setOnItemSelectedListener(this);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        eventsViewModel = ViewModelProviders.of(this).get(EventsViewModel.class);

        createNewEventBtn.setOnClickListener(v -> {
            String nameInput = nameEditTxt.getText().toString();
            String pointsInput = pointsEditTxt.getText().toString();
            //    String eventDayInput = eventDaySpinner.

            if(!nameInput.equals("") && !pointsInput.equals("")) {
                Event newEvent = new Event();
                newEvent.eventName = nameInput;
                newEvent.pointsAvailable = Integer.parseInt(pointsInput);
                eventsViewModel.insert(newEvent);
            }

            getDialog().dismiss();
        });
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String input = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), input, Toast.LENGTH_LONG);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

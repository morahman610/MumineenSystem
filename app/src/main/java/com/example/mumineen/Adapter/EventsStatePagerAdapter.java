package com.example.mumineen.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class EventsStatePagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> eventsFragmentList = new ArrayList<>();

    public EventsStatePagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public void addFragment(Fragment fragment) {
        eventsFragmentList.add(fragment);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return eventsFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return eventsFragmentList.size();
    }
}

package com.example.newsletter.ui.news;

import androidx.lifecycle.ViewModelProviders;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.newsletter.R;
import com.example.newsletter.data.NewsListAdapter;
import com.example.newsletter.data.model.New;
import com.example.newsletter.data.model.Receiver;

import java.util.ArrayList;

public class NewsFragment extends Fragment {

    private NewsViewModel mViewModel;

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



        ListView mListView = (ListView) container.findViewById(R.id.listView);

        //Create the Person objects
        New john = new New(1, "John","12-20-1998","Male");
        New steve = new New(2,"Steve","08-03-1987","Male");
        New stacy = new New(3,"Stacy","11-15-2000","Female");
        New ashley = new New(4,"Ashley","07-02-1999","Female");
        New matt = new New(5,"Matt","03-29-2001","Male");
        New matt2 = new New(6,"Matt2","03-29-2001","Male");
        New matt3 = new New(7,"Matt3","03-29-2001","Male");
        New matt4 = new New(8,"Matt4","03-29-2001","Male");
        New matt5 = new New(9,"Matt5","03-29-2001","Male");
        New matt6 = new New(10,"Matt6","03-29-2001","Male");
        New matt7 = new New(12,"Matt7","03-29-2001","Male");
        New matt8 = new New(13,"Matt8","03-29-2001","Male");
        New matt9 = new New(14,"Matt9","03-29-2001","Male");
        New matt10 = new New(15,"Matt10","03-29-2001","Male");
        New matt11 = new New(16,"Matt11","03-29-2001","Male");

        //Add the Person objects to an ArrayList
        ArrayList<New> newsList = new ArrayList<>();
        newsList.add(john);
        newsList.add(steve);
        newsList.add(stacy);
        newsList.add(ashley);
        newsList.add(matt);
        newsList.add(matt2);
        newsList.add(matt3);
        newsList.add(matt4);
        newsList.add(matt5);
        newsList.add(matt6);
        newsList.add(matt7);
        newsList.add(matt8);
        newsList.add(matt9);
        newsList.add(matt10);
        newsList.add(matt11);

        NewsListAdapter adapter = new NewsListAdapter(getActivity(), R.layout.adapter_view_layout, newsList);
        mListView.setAdapter(adapter);




        return inflater.inflate(R.layout.news_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        // TODO: Use the ViewModel
    }



}

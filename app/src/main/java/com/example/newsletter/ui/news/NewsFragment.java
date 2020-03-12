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

        //Add the Person objects to an ArrayList
        ArrayList<New> newsList = new ArrayList<>();


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

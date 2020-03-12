package com.example.newsletter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.newsletter.data.NewsListAdapter;
import com.example.newsletter.data.model.New;
import com.example.newsletter.data.model.PushNotificationManager;
import com.example.newsletter.data.model.Receiver;
import com.example.newsletter.ui.login.LoginActivity;
import com.example.newsletter.ui.news.NewsFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);

        final ListView mListView = (ListView) findViewById(R.id.listView);
        final ArrayList<New> postsList = new ArrayList<>();


        final NewsActivity context = this;



        final TextView textView = (TextView) findViewById(R.id.text);


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://devapi.palemiya.com/api/post?expand=status";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            JSONArray posts = jsonObj.getJSONArray("data");

                            for (int i = 0; i < posts.length(); i++) {
                                JSONObject c = posts.getJSONObject(i);
                                postsList.add(GaneratePostByJSON(c));
                            }
                        } catch (final JSONException e){

                            textView.setText("JSON Parse error");
                        }


                        NewsListAdapter adapter = new NewsListAdapter(context, R.layout.adapter_view_layout, postsList);
                        mListView.setAdapter(adapter);




                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });
        queue.add(stringRequest);









        PushNotificationManager notificationManager = new PushNotificationManager(this);
        notificationManager.CreateNotificationChannel("Новый рецепт", "Появлися новый рецепт «Крутые крылышки Волнова»");


        //Intent intent = new Intent(NewsActivity.this, NewsOpenActivity.class);
        //startActivity(intent);

    }





    public New GaneratePostByJSON(JSONObject jsonObject){
        try {
            Integer id = jsonObject.getInt("id");
            String name = jsonObject.getString("name");
            String content = jsonObject.getString("content");
            String link = jsonObject.getString("link");
            String avatar_link = jsonObject.getString("avatar_link");

            New rquestPost = new New(id, name,content,link, avatar_link);
            return rquestPost;
        } catch (final JSONException e){
            return null;
        }

    }












}

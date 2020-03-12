package com.example.newsletter.data;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.newsletter.NewsOpenActivity;
import com.example.newsletter.R;
import com.example.newsletter.data.model.New;
import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter  extends ArrayAdapter<New> {
    private static final String TAG = "NewsListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {
        TextView name;
        ImageView avatar;
    }

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public NewsListAdapter(Context context, int resource, ArrayList<New> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the persons information
        Integer id = getItem(position).getId();
        String name = getItem(position).getName();
        String content = getItem(position).getContent();
        final String link = getItem(position).getLink();

        //Create the person object with the information
        New person = new New(id, name,content,link);

        //create the view result for showing the animation
        final View result;

        //ViewHolder object
        ViewHolder holder;



        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder= new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.textView1);
            holder.avatar = (ImageView) convertView.findViewById(R.id.avatarView);
            //holder.birthday = (TextView) convertView.findViewById(R.id.textView2);
            //holder.sex = (TextView) convertView.findViewById(R.id.textView3);



            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }






        //Animation animation = AnimationUtils.loadAnimation(mContext,
        //        (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        //result.startAnimation(animation);
        //lastPosition = position;


        holder.name.setText(person.getName());
        //holder.birthday.setText(person.getContent());
        //holder.sex.setText(person.getLink());



        Picasso.get().load("https://palemiya.com/assets/portfolio-headers/ibs.2019.png").into(holder.avatar);

        try {
            //URL url = new URL("https://palemiya.com/assets/portfolio-headers/ibs.2019.png");
            //Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            //holder.avatar.setImageBitmap(bmp);
        } catch (Exception e) {
            e.printStackTrace();
        }


        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, NewsOpenActivity.class);
                Bundle b = new Bundle();
                b.putString("link", link); //Your id
                intent.putExtras(b); //Put your id to your next Intent


                mContext.startActivity(intent);

            }
        });




        return convertView;
    }
}

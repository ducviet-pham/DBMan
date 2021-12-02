package com.vietpdb.dbman.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.vietpdb.dbman.Model.Song;
import com.vietpdb.dbman.R;

import java.util.ArrayList;

public class ListviewAdapter extends ArrayAdapter<Song> {

    Context context;
    ArrayList<Song> arrayList;
    int layoutResourceItem;
    public ListviewAdapter( Context context, int resource,  ArrayList<Song> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = objects;
        this.layoutResourceItem = resource;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layoutResourceItem, null);
        TextView songName = (TextView) convertView.findViewById(R.id.name_song);
        TextView songSinger =(TextView) convertView.findViewById(R.id.song_singer);
        TextView songTime =(TextView) convertView.findViewById(R.id.time_song);
        songName.setText(arrayList.get(position).getSongName());
        songSinger.setText(arrayList.get(position).getSongSinger());
        float second =arrayList.get(position).getSongTime()%60;
        songTime.setText(String.valueOf((int) arrayList.get(position).getSongTime()/60+":"+Math.round(second)));
        return convertView;
    }

}

package com.vietpdb.dbman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.vietpdb.dbman.Controller.DatabaseSong;
import com.vietpdb.dbman.Controller.ListviewAdapter;
import com.vietpdb.dbman.Model.Song;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listSongs;
    ArrayList<Song> arrayList;
    ListviewAdapter listviewAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listSongs = (ListView) findViewById(R.id.lisview);
        arrayList = new ArrayList<>();
        arrayList.add(new Song(1,"La Lung", "Vu", 5));
        arrayList.add(new Song(1,"La Lung", "Vu", 5));
        getAllSong();
//        insertSong();

    }
    public  void insertSong(){
        DatabaseSong db = new DatabaseSong(this);
        db.addSong(new Song(1,"Phút cuối", "Bằng kiều", 200));
        db.addSong(new Song(1,"Bông hồng thủy tinh", "Bức tường", 220));
        db.addSong(new Song(1,"Hà Nội mùa thu", "Mỹ linh", 250));
        db.addSong(new Song(1,"Bà tôi", "Bằng Kiều", 250));
        db.addSong(new Song(1,"Gọi hồng", "Quang Dũng", 250));
        db.addSong(new Song(1,"Đêm đông", "Bằng kiều", 250));

    }
    public void getAllSong(){
        DatabaseSong db = new DatabaseSong(this);
        List<Song> listSong = db.getAllSong();
//        for (Song song : listSong){
//            song.setSongTime(200);
//        }
        arrayList = new ArrayList<>(listSong);
        listviewAdapter = new ListviewAdapter(MainActivity.this,R.layout.listviewitem, arrayList);
        listSongs.setAdapter(listviewAdapter);
    }
}
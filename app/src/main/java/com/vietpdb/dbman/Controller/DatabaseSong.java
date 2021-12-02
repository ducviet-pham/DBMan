package com.vietpdb.dbman.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.vietpdb.dbman.Model.Song;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSong extends SQLiteOpenHelper {
    private static final  String DATABASE_NAME = "Music";
    private static final  int DATABASE_VERSION = 1;
    private  static final String TABLE_NAME = "Song";
    private  static final String KEY_ID = "song_id";
    private static  final  String KEY_NAME= "song_name";
    private static final  String KEY_TIME = "song_time";
    private static final String KEY_SINGER = "song_singer";
    public DatabaseSong(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTableStudent = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s TEXT, %s float, %s TEXT)", TABLE_NAME, KEY_ID, KEY_NAME, KEY_TIME, KEY_SINGER );
        db.execSQL(sqlCreateTableStudent);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTableStudent = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(dropTableStudent);
    }
    public void addSong(Song song){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, song.getSongName());
        values.put(KEY_TIME, song.getSongTime());
        values.put(KEY_SINGER, song.getSongSinger());
        db.insert(TABLE_NAME,null, values);
        db.close();
    }

    public Song getSong(int songId){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, KEY_ID + " = ?", new String[]{String.valueOf(songId)} , null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Song song = new Song();
//        [1, "Viet", "HaNoi", "089293312312"];
        song.setSongId(cursor.getInt(0));
        song.setSongName(cursor.getString(1));
        song.setSongTime(cursor.getFloat(2));
        song.setSongSinger(cursor.getString(3));
        return song;
    }

    public List<Song> getAllSong(){
        List<Song> studentList = new ArrayList<>();
        String  sqlQueryString= "SELECT * FROM "+ TABLE_NAME + " ORDER BY "+ KEY_TIME + " DESC";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sqlQueryString, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            Song song = new Song();
//        [1, "Viet", "HaNoi", "089293312312"];
            song.setSongId(cursor.getInt(0));
            song.setSongName(cursor.getString(1));
            song.setSongTime(cursor.getFloat(2));
            song.setSongSinger(cursor.getString(3));
            studentList.add(song);
            cursor.moveToNext();
        }
        db.close();
        return studentList;
    }

    public  void  updateSong(Song song){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, song.getSongName());
        values.put(KEY_TIME, song.getSongTime());
        values.put(KEY_SINGER, song.getSongSinger());
        db.update(TABLE_NAME, values, KEY_ID + "= ?", new String[]{String.valueOf(song.getSongId())});
        db.close();
    }

    public void  deleteSong(int studentId){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " = ?", new String[]{String.valueOf(studentId)});
        db.close();
    }
}

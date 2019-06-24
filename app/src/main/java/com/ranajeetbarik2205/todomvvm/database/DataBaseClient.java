package com.ranajeetbarik2205.todomvvm.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public class DataBaseClient {

    private Context context;
    private static DataBaseClient databaseClient;
    private TodoDatabase todoDatabase;

    public DataBaseClient(Context context){
        this.context = context;
        todoDatabase = Room.databaseBuilder(context,TodoDatabase.class,"todoDatabase").build();
    }

    public static synchronized DataBaseClient getDatabaseClient(Context context){
        if (databaseClient==null){
            databaseClient = new DataBaseClient(context);
        }
        return databaseClient;
    }

    public TodoDatabase getTodoDatabase(){
        return todoDatabase;
    }

}

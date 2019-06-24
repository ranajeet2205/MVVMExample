package com.ranajeetbarik2205.todomvvm.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ranajeetbarik2205.todomvvm.dao.TodoDao;
import com.ranajeetbarik2205.todomvvm.entity.Todo;


@Database(entities = {Todo.class},version = 1)
public abstract class TodoDatabase extends RoomDatabase {

    public abstract TodoDao todoDao();
}

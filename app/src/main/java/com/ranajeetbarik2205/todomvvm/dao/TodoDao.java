package com.ranajeetbarik2205.todomvvm.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ranajeetbarik2205.todomvvm.entity.Todo;

import java.util.List;

@Dao
public interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Void insertAll(Todo todo);

    @Query("SELECT * FROM todo")
    LiveData<List<Todo>> todoList();

    @Delete
    void deleteWord(Todo todo);
}

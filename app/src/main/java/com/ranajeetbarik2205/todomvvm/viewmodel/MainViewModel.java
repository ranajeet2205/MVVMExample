package com.ranajeetbarik2205.todomvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ranajeetbarik2205.todomvvm.database.TododRepository;
import com.ranajeetbarik2205.todomvvm.database.TododRepository;
import com.ranajeetbarik2205.todomvvm.entity.Todo;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private TododRepository tododRepository;
    private LiveData<List<Todo>> todoLiveDataList;

    public MainViewModel(@NonNull Application application) {
        super(application);
        tododRepository = new TododRepository(application);
        todoLiveDataList = tododRepository.getTodoLiveDataList();
    }

    public LiveData<List<Todo>> getTodoLiveDataList() {
        return todoLiveDataList;
    }

    public void insert(Todo todo) {
        tododRepository.insertData(todo);
    }

    public void delete(Todo todo){
        tododRepository.deleteData(todo);
    }
}

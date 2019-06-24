package com.ranajeetbarik2205.todomvvm;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.ranajeetbarik2205.todomvvm.adapter.TodoAdapter;
import com.ranajeetbarik2205.todomvvm.databinding.ActivityMainBinding;
import com.ranajeetbarik2205.todomvvm.entity.Todo;
import com.ranajeetbarik2205.todomvvm.viewmodel.MainViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    TodoAdapter todoAdapter;
    Todo todo;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModel = new MainViewModel(getApplication());
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);

        mainViewModel.getTodoLiveDataList().observe(this, new Observer<List<Todo>>() {
            @Override
            public void onChanged(List<Todo> todos) {
                todoAdapter = new TodoAdapter(todos,getApplicationContext());
                binding.includedContentMain.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                binding.includedContentMain.recyclerView.setAdapter(todoAdapter);
            }
        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            todo = new Todo("Title","Dexcription");
            mainViewModel.insert(todo);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

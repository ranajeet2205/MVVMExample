package com.ranajeetbarik2205.todomvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ranajeetbarik2205.todomvvm.R;
import com.ranajeetbarik2205.todomvvm.databinding.TodoListBinding;
import com.ranajeetbarik2205.todomvvm.entity.Todo;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.MyViewHolder> {
    private final Context context;
    private List<Todo> items;

    public TodoAdapter(List<Todo> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                           int viewType) {
       /* View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_list, parent, false);*/
       TodoListBinding todoListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
               R.layout.todo_list,parent,false);
        return new MyViewHolder(todoListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Todo item = items.get(position);
        holder.set(item);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TodoListBinding todoListBinding;

        public MyViewHolder(TodoListBinding todoListBinding) {
            super(todoListBinding.getRoot());
            this.todoListBinding = todoListBinding;
        }

        public void set(Todo item) {
            //UI setting code
            todoListBinding.titleTv.setText(item.getTitle());
            todoListBinding.descTv.setText(item.getDesc());
        }
    }
}
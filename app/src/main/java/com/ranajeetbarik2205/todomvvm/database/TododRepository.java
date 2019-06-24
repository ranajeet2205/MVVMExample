package com.ranajeetbarik2205.todomvvm.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.ranajeetbarik2205.todomvvm.dao.TodoDao;
import com.ranajeetbarik2205.todomvvm.entity.Todo;

import java.util.List;

public class TododRepository {

    private TodoDao todoDao;
    private LiveData<List<Todo>> todoLiveDataList;

    public TododRepository(Application application){
       todoDao = DataBaseClient.getDatabaseClient(application).getTodoDatabase().todoDao();
       todoLiveDataList = todoDao.todoList();
    }

    public LiveData<List<Todo>> getTodoLiveDataList(){
        return  todoLiveDataList;
    }

    public void insertData(Todo todo){
        new InsertDataTask(todoDao).execute(todo);

    }

    public void deleteData(Todo todo){
        new DeleteDataTask(todoDao).execute(todo);
    }

    public class InsertDataTask extends AsyncTask<Todo,Void,Void>{

        private TodoDao todoDao;

        public InsertDataTask(TodoDao todoDao) {
            this.todoDao = todoDao;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            todoDao.insertAll(todos[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

    public class DeleteDataTask extends AsyncTask<Todo,Void,Void>{
        private TodoDao todoDao;

        public DeleteDataTask(TodoDao todoDao){
            this.todoDao = todoDao;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            todoDao.deleteWord(todos[0]);
            return null;
        }
    }

}

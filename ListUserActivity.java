package com.example.userprogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ListUserActivity extends AppCompatActivity {

    private UserStorage userstorage;
    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        userstorage = UserStorage.getInstance();
        recyclerview = findViewById(R.id.rvUserList);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(new UserListAdapter(getApplicationContext(), userstorage.getUsers()));
    }

}

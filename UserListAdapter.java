package com.example.userprogram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context context;
    private ArrayList<User> users = new ArrayList<>();

    public UserListAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.UserName.setText(" " + users.get(position).getFirstName() + " " + users.get(position).getLastName());
        holder.UserProgram.setText(" " + users.get(position).getDegreeProgram());
        holder.UserEmail.setText(" " + users.get(position).getEmail());

        holder.txt.setText(" Suoritetut tutkinnot:");
        holder.UserDegree.setText((users.get(position).getDegree()));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}

package com.example.userprogram;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView UserName, UserProgram, UserEmail, UserDegree, txt;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        UserName = itemView.findViewById(R.id.txtUserName);
        UserProgram = itemView.findViewById(R.id.txtUserProgram);
        UserEmail = itemView.findViewById(R.id.txtUserEmail);
        txt = itemView.findViewById(R.id.txt);
        UserDegree = itemView.findViewById(R.id.txtUserDegree);
    }
}

package com.example.userprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import java.lang.String;


public class AddUserActivity extends AppCompatActivity {

    public EditText editFirstName;
    public EditText editLastName;
    public EditText editEmail;
    public String degreeProgram;
    CheckBox bachelor, master, doctor, swim;
    public String degree = "";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        context = AddUserActivity.this;
    }


    public void addUser(View view) {

        editFirstName = (EditText)findViewById(R.id.fname);
        String firstName = editFirstName.getText().toString();
        editLastName = (EditText)findViewById(R.id.lname);
        String lastName = editLastName.getText().toString();
        editEmail = (EditText)findViewById(R.id.uemail);
        String email = editEmail.getText().toString();

        RadioGroup rgProgram = findViewById(R.id.rgProgram);
        switch(rgProgram.getCheckedRadioButtonId()) {
            case R.id.rbTITE:
                degreeProgram = "Tietotekniikka";
                break;
            case R.id.rbTUTA:
                degreeProgram = "Tuotantotalous";
                break;
            case R.id.rbLATE:
                degreeProgram = "Laskennallinen tekniikka";
                break;
            case R.id.rbSATE:
                degreeProgram = "Sähkötekniikka";
                break;
        }

        bachelor = (CheckBox) findViewById(R.id.cbBachelor);
        master = (CheckBox) findViewById(R.id.cbMaster);
        doctor = (CheckBox) findViewById(R.id.cbDoctor);
        swim = (CheckBox) findViewById(R.id.cbSwim);
        degree = "";

        if(bachelor.isChecked()) {
            degree += " - " + bachelor.getText().toString() + "\n";
        }
        if(master.isChecked()) {
            degree += " - " + master.getText().toString() + "\n";
        }
        if(doctor.isChecked()) {
            degree += " - " + doctor.getText().toString() + "\n";
        }
        if(swim.isChecked()) {
            degree += " - " + swim.getText().toString() + "\n";
        }

        UserStorage.getInstance().addUser(new User(firstName, lastName, email, degreeProgram, degree));

        UserStorage.getInstance().saveUsers(context);
        UserStorage.getInstance().loadUsers(context);
    }

    public void switchToListUser(View view) {
        Intent intent = new Intent(this, ListUserActivity.class);
        startActivity(intent);
    }
}

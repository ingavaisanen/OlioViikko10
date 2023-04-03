package com.example.userprogram;


import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserStorage {
    private ArrayList<User> users = new ArrayList<>();
    private static UserStorage userstorage = null;


    private UserStorage() {
    }

    public static UserStorage getInstance() {
        if (userstorage == null) {
            userstorage = new UserStorage();
        }
        return userstorage;
    }

    public ArrayList<User> getUsers() {

        return users;
    }

    public void addUser(User user) {

        users.add(user);
        sortUser();
    }

    public void saveUsers(Context context) {
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            userWriter.writeObject(users);
            userWriter.close();
        } catch(IOException e) {
            System.out.println("Käyttäjien tallentaminen epäonnistui.");
        }
    }

    public void loadUsers(Context context) {
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("users.data"));
            users = (ArrayList<User>) userReader.readObject();
            userReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Käyttäjien lukeminen epäonnistui");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Käyttäjien lukeminen epäonnistui");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Käyttäjien lukeminen epäonnistui");
            e.printStackTrace();
        }
    }
    private void sortUser() {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return user.getLastName().compareTo(t1.getLastName());
            }
        });
    }
}

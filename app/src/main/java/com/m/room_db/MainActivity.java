 package com.m.room_db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import java.util.List;

 public class MainActivity extends AppCompatActivity {
     private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        User user = new User("Marcelino", "Matias");
        userViewModel.insert(user);

        userViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                for(User user: users) {
                    System.out.println(user.firstName + " " + user.lastName);
                }
            }
        });


    }
}

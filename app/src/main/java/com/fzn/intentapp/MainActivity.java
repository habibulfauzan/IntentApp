package com.fzn.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    //RS
    public void clickRS(View view) {
        Intent IntentRS = new Intent(this, RS.class);
        startActivity(IntentRS);
    }

    public void clickPolisi(View view) {
        Intent IntentPolisi = new Intent(this, Polisi.class);
        startActivity(IntentPolisi);
    }
}
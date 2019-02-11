package com.example.shame.myfirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculator(View view) {
        Intent intent=new Intent(MainActivity.this,CalcActivity.class);
        startActivity(intent);
    }


    public void Camera(View view) {
        Intent intent=new Intent(this,GalleryActivity.class);
        startActivity(intent);
    }

    public void Note(View view) {
        Intent intent=new Intent(this,NoteActivity.class);
        startActivity(intent);
    }
}

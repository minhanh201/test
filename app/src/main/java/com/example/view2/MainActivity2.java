package com.example.view2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void show(View view) {
        MyCustomDialog myCustomDialog=new MyCustomDialog(MainActivity2.this);
        myCustomDialog.show();
    }
}
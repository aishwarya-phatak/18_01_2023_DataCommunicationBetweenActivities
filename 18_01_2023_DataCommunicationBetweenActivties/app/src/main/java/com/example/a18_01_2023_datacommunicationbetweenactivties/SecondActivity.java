package com.example.a18_01_2023_datacommunicationbetweenactivties;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    EditText edtSurname;
    TextView txtFromFirstActivity;
    Button btnMoveToFirstActivity;
    String username;
    int rollNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        initializeViews();
      //  initializeListeners();

        extractData();

    }

    private void initializeViews(){
        edtSurname = findViewById(R.id.edtSurname);
        txtFromFirstActivity = findViewById(R.id.txtFromFirstActivity);
        btnMoveToFirstActivity = findViewById(R.id.btnMoveToFirstActivity);
    }

    private void extractData(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        rollNumber = bundle.getInt("rollNumber");
        username = bundle.getString("username");
        Log.e("tag",username);
        txtFromFirstActivity.setText(username);
    }

   /* private void initializeListeners(){
        btnMoveToFirstActivity.setOnClickListener(new );
    }

    */
}

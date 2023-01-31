package com.example.a18_01_2023_datacommunicationbetweenactivties;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    EditText edtSurname;
    TextView txtFromFirstActivity;
    Button btnMoveToFirstActivity;
    String userName;
    int rollNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        initializeViews();
        extractData();
        initializeListeners();
    }

    private void initializeViews(){
        edtSurname = findViewById(R.id.edtSurname);
        txtFromFirstActivity = findViewById(R.id.txtFromFirstActivity);
        btnMoveToFirstActivity = findViewById(R.id.btnMoveToFirstActivity);
    }

    @SuppressLint("SetTextI18n")
    private void extractData(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        rollNumber = bundle.getInt("rollNumber");
        userName = bundle.getString("username");
        //Log.e("tag",username);
        txtFromFirstActivity.setText(userName +" "+rollNumber);
    }

    private void initializeListeners(){
        btnMoveToFirstActivity.setOnClickListener(new BtnFinishClickListener());
    }

    class BtnFinishClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result",edtSurname.getText().toString());
            setResult(1,resultIntent);
            finish();
        }
    }
}

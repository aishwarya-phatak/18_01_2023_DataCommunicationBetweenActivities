package com.example.a18_01_2023_datacommunicationbetweenactivties;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FirstActivity extends Activity{

    TextView txtFromSecondActivity;
    EditText edtUsername;
    Button btnNavigateToSecondActivity;
    String result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        initializeViews();
        initializeListeners();
    }

    private void initializeViews() {
        edtUsername = findViewById(R.id.edtUsername);
        txtFromSecondActivity = findViewById(R.id.txtFromSecondActivity);
        btnNavigateToSecondActivity = findViewById(R.id.btnNavigateToSecondActivity);
    }

    private void initializeListeners(){
        btnNavigateToSecondActivity.setOnClickListener(new BtnNavigateToSAListener());
    }

    class BtnNavigateToSAListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
            intent.putExtra("rollNumber",10);
            intent.putExtra("username",edtUsername.getText().toString());
            startActivityForResult(intent,1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        result = bundle.getString("result");
        txtFromSecondActivity.setText(result);
    }
}

package com.example.finalproject3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_login, btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mendaftarkan Button
        btn_login = findViewById(R.id.btn_singin);
        btn_login.setOnClickListener(this);

        btn_register = findViewById(R.id.btn_new_account);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_singin:
                Intent gotologin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(gotologin);
                break;
            case R.id.btn_new_account:
                Intent gotoregister = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(gotoregister);
                break;
        }
    }
}
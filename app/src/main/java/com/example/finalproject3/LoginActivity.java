package com.example.finalproject3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_go_singin;
    TextView tv_new_account;
    EditText et_name, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Mendaftarkan Button
        btn_go_singin = findViewById(R.id.btn_go_singin);
        btn_go_singin.setOnClickListener(this);
        tv_new_account = findViewById(R.id.tv_new_account);
        tv_new_account.setOnClickListener(this);

        et_name = findViewById(R.id.et_name);
        et_password = findViewById(R.id.et_password);

        SharedPreferences prefs = getSharedPreferences("user_datail", MODE_PRIVATE);
        String PreferencesNameKey = prefs.getString("name","");
        String PreferencesPasswordKey = prefs.getString("password","");

        if (!PreferencesNameKey.equals("")){
            et_name.setText(PreferencesNameKey);
        }

        if (!PreferencesPasswordKey.equals("")){
            et_password.setText(PreferencesPasswordKey);
        }
    }

    @Override
    public void onClick(View view) {
        String nameKey = et_name.getText().toString();
        String passwordKey = et_password.getText().toString();
        SharedPreferences.Editor editor = getSharedPreferences("user_datail", MODE_PRIVATE).edit();

        switch (view.getId()){
            case R.id.tv_new_account:
                Intent gotomainact = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(gotomainact);
                break;
            case R.id.btn_go_singin:
                if (nameKey.equals("") || passwordKey.equals("")){
                    Toast.makeText(getApplicationContext(),"Nama atau Password tidak boleh kosong",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Login Sukses",Toast.LENGTH_SHORT).show();
                    editor.putString("name",nameKey);
                    editor.putString("password",passwordKey);
                    editor.apply();

                    Intent go_login = new Intent(LoginActivity.this, HomeActivity.class);
                    go_login.putExtra("name", nameKey);
                    startActivity(go_login);
                }
                break;
        }
    }
}
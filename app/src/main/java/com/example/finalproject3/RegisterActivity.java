package com.example.finalproject3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_register;
    LinearLayout btn_back;
    EditText et_name, et_phone_no , et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Mendaftarkan Button
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);

        et_name = findViewById(R.id.et_name);
        et_phone_no = findViewById(R.id.et_phone_no);
        et_password = findViewById(R.id.et_password);

        SharedPreferences prefs = getSharedPreferences("user_datail", MODE_PRIVATE);
        String PreferencesNameKey = prefs.getString("name","");
        String PreferencesPhoneKey = prefs.getString("phone","");
        String PreferencesPasswordKey = prefs.getString("password","");

        if (!PreferencesNameKey.equals("")){
            et_name.setText(PreferencesNameKey);
        }

        if (!PreferencesPhoneKey.equals("")){
            et_phone_no.setText(PreferencesPhoneKey);
        }

        if (!PreferencesPasswordKey.equals("")){
            et_password.setText(PreferencesPasswordKey);
        }
    }


    @Override
    public void onClick(View view) {
        String nameKey = et_name.getText().toString();
        String phoneKey = et_name.getText().toString();
        String passwordKey = et_password.getText().toString();
        SharedPreferences.Editor editor = getSharedPreferences("user_datail", MODE_PRIVATE).edit();

        switch (view.getId()){
            case R.id.btn_back:
                Intent gotomainact = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(gotomainact);
                break;
            case R.id.btn_register:
                if (nameKey.equals("") || passwordKey.equals("") || phoneKey.equals("")){
                    Toast.makeText(getApplicationContext(),"Nama atau Password atau Nomor Handphone tidak boleh kosong",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Login Sukses",Toast.LENGTH_SHORT).show();
                    editor.putString("name",nameKey);
                    editor.putString("phone",phoneKey);
                    editor.putString("password",passwordKey);
                    editor.apply();

                    Intent go_login = new Intent(RegisterActivity.this, HomeActivity.class);
                    go_login.putExtra("name", nameKey);
                    startActivity(go_login);
                }
                break;
        }
    }
}
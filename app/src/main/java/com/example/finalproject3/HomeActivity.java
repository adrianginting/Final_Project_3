package com.example.finalproject3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout btn_clothing, btn_book, btn_mobile, btn_car, btn_fruit, btn_food;
    TextView nama_lengkap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nama_lengkap = findViewById(R.id.nama_lengkap);
        if(getIntent().getExtras() != null ){
            Bundle bundle = getIntent().getExtras();
            nama_lengkap.setText("Selamat datang "+bundle.getString("name"));
        }

        btn_clothing = findViewById(R.id.btn_clothing);
        btn_clothing.setOnClickListener(this);
        btn_book = findViewById(R.id.btn_book);
        btn_book.setOnClickListener(this);
        btn_mobile = findViewById(R.id.btn_mobile);
        btn_mobile.setOnClickListener(this);
        btn_car = findViewById(R.id.btn_car);
        btn_car.setOnClickListener(this);
        btn_fruit = findViewById(R.id.btn_fruit);
        btn_fruit.setOnClickListener(this);
        btn_food = findViewById(R.id.btn_food);
        btn_food.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_clothing:
                Toast.makeText(getApplicationContext(),"Membuka Clothing",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_book:
                displayToast();
                break;
            case R.id.btn_mobile:
                displayToast();
                break;
            case R.id.btn_car:
                displayToast();
                break;
            case R.id.btn_fruit:
                displayToast();
                break;
            case R.id.btn_food:
                displayToast();
                break;
        }
    }

    public void displayToast(){
        Toast.makeText(getApplicationContext(),"Fitur Belum Tersedia",Toast.LENGTH_SHORT).show();
    }
}
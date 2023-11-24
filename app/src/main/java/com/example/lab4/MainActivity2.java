package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity {

    private EditText set_drink;
    private RadioGroup rg1,rg2;
    private Button btn_send;

    private String sugar = "無糖";
    private String ice_opt = "去冰";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rg1 = findViewById(R.id.radioGroup); //連接RadioGroup畫面元件
        rg1.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.radioButton1) {         //按下radioButton1，紀錄無糖字串
                sugar = "無糖";
            } else if (i == R.id.radioButton2) {  //按下radioButton2，紀錄少糖字串
                sugar = "少糖";
            } else if (i == R.id.radioButton3) {  //按下radioButton3，紀錄半糖字串
                sugar = "半糖";
            } else {                              //按下radioButton4，紀錄全糖字串
                sugar = "全糖";
            }
        });

        rg2 = findViewById(R.id.radioGroup2); //連接RadioGroup畫面元件
        rg2.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == R.id.radioButton5) {         //按下radioButton5，紀錄去冰字串
                ice_opt = "去冰";
            } else if (i == R.id.radioButton6) {  //按下radioButton6，紀錄微冰字串
                ice_opt = "微冰";
            } else if (i == R.id.radioButton7) {  //按下radioButton7，紀錄少冰字串
                ice_opt = "少冰";
            } else {                              //按下radioButton8，紀錄正常冰字串
                ice_opt = "正常冰";
            }
        });

        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(view -> {
            set_drink = findViewById(R.id.ed_drink);
            String drink = set_drink.getText().toString();
            Intent i = new Intent();
            Bundle b = new Bundle();
            b.putString("drink", drink); //將甜度冰塊資訊放入Bundle
            b.putString("sugar", sugar);
            b.putString("ice", ice_opt);
            i.putExtras(b);
            setResult(Activity.RESULT_OK, i); //用RESULT_OK標記執行狀態並記錄
            finish();
        });
    }
}
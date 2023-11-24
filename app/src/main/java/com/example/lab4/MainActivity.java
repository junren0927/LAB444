package com.example.lab4;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_meal;
    private Button btn_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_meal = findViewById(R.id.tv_meal); //連接TextView元件
        btn_select = findViewById(R.id.btn_choice); //連接Button元件
        btn_select.setOnClickListener(view -> {
            mStartForResult.launch(
                    new Intent(this, MainActivity2.class) //透過Intent切換至MainActivity
            );
        });
    }

    private final ActivityResultLauncher<Intent> mStartForResult =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    //確認執行的結果
                    Intent intent = result.getData();
                    //如果 intent 不為 null ，且 intent 的 extras 不為 null
                    if (intent != null && intent.getExtras() != null) {
                        Bundle b = intent.getExtras();
                        String str1 = b.getString("drink"); //取得飲料甜度冰塊資料12
                        String str2 = b.getString("sugar");
                        String str3 = b.getString("ice");
                        tv_meal.setText(String.format("飲料: %s\n\n甜度: %s\n\n冰塊: %s", str1, str2, str3)); //透過TextView.setText()顯示資料
                    }
                }
            });
}
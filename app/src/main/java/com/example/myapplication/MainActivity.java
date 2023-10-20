package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextText;
    private TextView textView, winner, name, cmora, mmora;
    private RadioButton radioButton, radioButton2, radioButton3;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextText = findViewById(R.id.editTextText);
        textView = findViewById(R.id.textView);
        winner = findViewById(R.id.winner);
        name = findViewById(R.id.name);
        mmora = findViewById(R.id.mmora);
        cmora = findViewById(R.id.cmora);
        radioButton = findViewById(R.id.radioButton);//剪刀
        radioButton2 = findViewById(R.id.radioButton2);//石頭
        radioButton3 = findViewById(R.id.radioButton3);//布
        button = findViewById(R.id.button);

        button.setOnClickListener(view -> {
            if(name.length()<1)
            {
                textView.setText("請輸入玩家姓名");
            }
            else
            {
                name.setText(String.format("名字\n%s", editTextText.getText().toString()));

                if(radioButton.isChecked())
                {
                    mmora.setText("我方出拳\n剪刀");
                }
                else if (radioButton2.isChecked())
                {
                    mmora.setText("我方出拳\n石頭");
                }
                else if (radioButton3.isChecked())
                {
                    mmora.setText("我方出拳\n布");
                }
                int random = (int) (Math.random() * 3);

                if (random == 0)
                {
                    cmora.setText("電腦出拳\n剪刀");
                }
                else if (random == 1)
                {
                    cmora.setText("電腦出拳\n石頭");
                }
                else
                {
                    cmora.setText("電腦出拳\n布");
                }
                if ((radioButton.isChecked() && random ==2)||
                        (radioButton2.isChecked() && random ==0)||
                        (radioButton3.isChecked() && random ==1))
                {
                    winner.setText("勝利者\n"+editTextText.getText().toString());
                    textView.setText("恭喜獲勝!!!");
                }
                else if ((radioButton.isChecked() && random ==1)||
                        (radioButton2.isChecked() && random ==2)||
                        (radioButton3.isChecked() && random ==0))
                {
                    winner.setText("勝利者\n電腦");
                    textView.setText("可惜，電腦獲勝!");
                }
                else
                {
                    winner.setText("勝利者\n平手");
                    textView.setText("平手，再來一局吧!!!");
                }
            }
        });
    }
}
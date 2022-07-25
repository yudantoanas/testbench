package com.example.testbench;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMain = findViewById(R.id.buttonMain);
        Button btnDetail = findViewById(R.id.buttonDetail);

        btnMain.setOnClickListener(view -> {
            // start main activity (launcher) in tasklist
            Intent in = getPackageManager().getLaunchIntentForPackage("id.cyberteam.tasklist");

            if (in != null) {
                in.putExtra("token", "test_token");
                in.putExtra("tokenType", "test_token_type");
                startActivity(in);//null pointer check in case package name was not found
            }
        });


        btnDetail.setOnClickListener(view -> {
            // start detail activity in tasklist
            Intent in2 = new Intent("Tasklist.Detail");
            in2.putExtra("ID", 106);
            startActivity(in2);
        });
    }
}
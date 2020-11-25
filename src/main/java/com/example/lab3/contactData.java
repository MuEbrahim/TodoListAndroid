package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class contactData extends AppCompatActivity {
    TextView nameTv,phoneTv;
    CheckBox CB;
    Intent intent;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactview);

        nameTv = findViewById(R.id.nameTV);
        phoneTv = findViewById(R.id.phoneTV);
        CB = findViewById(R.id.CB);
        backBtn = findViewById(R.id.backBtn);
        intent = getIntent();

        nameTv.setText(intent.getStringExtra("name"));
        phoneTv.setText(intent.getStringExtra("phone"));
        CB.setChecked(intent.getBooleanExtra("checked",false));

        CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(intent.getBooleanExtra("checked",false) == true){

                    intent.putExtra("checked",false);

                } else {

                    intent.putExtra("checked",true);

                }
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

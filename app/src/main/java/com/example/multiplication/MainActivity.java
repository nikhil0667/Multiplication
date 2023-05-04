package com.example.multiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.LocusId;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int num = 1;
    private int m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.text);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button btn = findViewById(R.id.btn);
        EditText editText = findViewById(R.id.edt_number);
        ListView listView = findViewById(R.id.list);
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, arrayList);
//        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//editText.clearFocus();


                m = Integer.parseInt(editText.getText().toString());
                textView.setText("Multiplication Table Of :- "+editText.getText().toString());

//                return true;
//            }
//        });
                arrayList.clear();
                for (int i = 1; i <= 10; i++) {
                    int mul = m * i;
                    String i1 = String.valueOf(i);
                    String m1 = String.valueOf(m);
                    String mul1 = String.valueOf(mul);

                    arrayList.add(m1 + " * " + i1 + " = " + mul1);
                }

                listView.setAdapter(adapter);
            }
        });
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                m = Integer.parseInt(editText.getText().toString());
                textView.setText("Divided Table Of :- "+editText.getText().toString());
                arrayList.clear();
                for (int i = 1; i <= 10; i++) {
                    float mul = m / i;
                    String i1 = String.valueOf(i);
                    String m1 = String.valueOf(m);
                    String mul1 = String.valueOf(mul);

                    arrayList.add(m1 + " / " + i1 + " = " + mul1);
                }

                listView.setAdapter(adapter);
                return true;
            }
        });

    }
}
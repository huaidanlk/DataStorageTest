package com.example.datastoragetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.datastoragetest.utils.IOStreamTools;

public class MainActivity extends AppCompatActivity {
    private EditText et_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        et_input = (EditText) findViewById(R.id.et_input);

    }

    @Override
    protected void onResume() {
        super.onResume();
        String data = IOStreamTools.readFile(this);
        et_input.setText(data);
        et_input.setSelection(data.length());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String input = et_input.getText().toString();
        IOStreamTools.writeFile(input,this);
    }
}

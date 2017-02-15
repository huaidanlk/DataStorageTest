package com.example.datastoragetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.datastoragetest.utils.IOStreamTools;
import com.example.datastoragetest.utils.SharePreferencesTools;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //文件存储
    private EditText et_input_file;
    private Button btn_commit_file;
    //sharePreferences 存储
    private EditText et_input_share;
    private Button btn_commit_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        et_input_file = (EditText) findViewById(R.id.et_input_file);
        btn_commit_file= (Button) findViewById(R.id.btn_commit_file);
        btn_commit_file.setOnClickListener(this);

        et_input_share= (EditText) findViewById(R.id.et_input_share);
        btn_commit_share= (Button) findViewById(R.id.btn_commit_share);
        btn_commit_share.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //显示存储的数据
        String data = IOStreamTools.readFile(this);
        et_input_file.setText(data);
        et_input_file.setSelection(data.length());
        //
        String data1=SharePreferencesTools.readData(this);
        et_input_share.setText(data1);
        et_input_share.setSelection(data1.length());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        String input = et_input_file.getText().toString();
//        IOStreamTools.writeFile(input,this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_commit_file:
                String input = et_input_file.getText().toString();
                IOStreamTools.writeFile(input,this);
                break;
            case R.id.btn_commit_share:
                String input1 = et_input_share.getText().toString();
                SharePreferencesTools.writeData(this,input1);
                break;
        }
    }
}

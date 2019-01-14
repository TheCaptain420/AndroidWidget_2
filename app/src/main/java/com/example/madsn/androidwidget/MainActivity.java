package com.example.madsn.androidwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    EditText edtTitle,edtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //init paper
        Paper.init(this);

        btnSave = (Button)findViewById(R.id.btn_save);
        edtTitle = (EditText)findViewById(R.id.edt_title);
        edtContent = (EditText) findViewById(R.id.edt_content);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paper.book().write("title",edtTitle.getText().toString());
                Paper.book().write("content",edtContent.getText().toString());

            }
        });
    }
}

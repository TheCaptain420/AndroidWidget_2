package com.example.madsn.androidwidget;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    EditText edtTitle,edtContent;

    //wifi
    Button btn_wifiOn, btn_wifiOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //init paper
        Paper.init(this);

        btnSave = (Button)findViewById(R.id.btn_save);
        edtTitle = (EditText)findViewById(R.id.edt_title);
        edtContent = (EditText) findViewById(R.id.edt_content);

        btn_wifiOn = (Button)findViewById(R.id.wifi_on);
        btn_wifiOff = (Button)findViewById(R.id.wifi_off);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paper.book().write("title",edtTitle.getText().toString());
                Paper.book().write("content",edtContent.getText().toString());

            }
        });


        btn_wifiOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("tsm button pressed wifi On");
                //<uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />

                WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(true); // true or false to activate/deactivate wifi

            }
        });

        btn_wifiOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("tsm button pressed wifi off");

                WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false); // true or false to activate/deactivate wifi
            }
        });




    }
}

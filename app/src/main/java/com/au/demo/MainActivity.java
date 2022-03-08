package com.au.demo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {
 EditText no,msg;
 Button btn;
 SmsManager send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        no=findViewById(R.id.no);
        msg=findViewById(R.id.msg);
        btn=findViewById(R.id.btn);
        send=SmsManager.getDefault();
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                String num=no.getText().toString();
                String message=msg.getText().toString();
                if (checkCallingOrSelfPermission(Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
                {
                    requestPermissions(new String[]{Manifest.permission.SEND_SMS},0);
                }
                send.sendTextMessage(num,null,message,null,null);
            }
        });
    }
}
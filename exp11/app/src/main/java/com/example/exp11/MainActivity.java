package com.example.exp11;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b;
    String [] mail_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.ed1);
        e2=findViewById(R.id.ed2);
        e3=findViewById(R.id.ed3);
        b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendmail(v);
            }
        });
    }

    private void sendmail(View v) {
        mail_list = e1.getText().toString().split(",");
        Intent i = new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL,mail_list);
        i.putExtra(Intent.EXTRA_SUBJECT,e2.getText().toString());
        i.putExtra(Intent.EXTRA_TEXT,e3.getText().toString());
        i.setType("message/rfc822");
        startActivity(Intent.createChooser(i,"Choose email app"));
    }
}

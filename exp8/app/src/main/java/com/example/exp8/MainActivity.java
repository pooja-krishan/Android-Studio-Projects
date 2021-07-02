package com.example.exp8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                final EditText edit = (EditText) findViewById(R.id.edit);
                Button write = (Button) findViewById(R.id.write);
                Button read= (Button) findViewById(R.id.read);
                Button cls =(Button) findViewById(R.id.cls);

                write.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String msg = edit.getText().toString();
                        try {
                            File f = new File("sdcard/Download/file.txt");
                            f.createNewFile();
                            FileOutputStream out = new FileOutputStream(f);
                            out.write(msg.getBytes());
                            out.close();
                            Toast.makeText(getBaseContext(),"Contents written to the SD Card", LENGTH_LONG).show();

                        }
                        catch (Exception e) {
                            Toast.makeText(getBaseContext(),e.getMessage(), LENGTH_LONG).show();
                        }
                    }
                });

                read.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String msg;
                        String buff="";
                        try {
                            File f = new File("sdcard/Download/file.txt");
                            FileInputStream in = new FileInputStream(f);
                            BufferedReader br = new BufferedReader(new InputStreamReader(in));
                            while((msg=br.readLine())!=null) {
                                buff += msg;
                            }
                            edit.setText(buff);
                            in.close();
                            br.close();
                            Toast.makeText(getBaseContext(),"Read from the SD Card",LENGTH_LONG).show();
                        }
                        catch (Exception e) {
                            Toast.makeText(getBaseContext(),e.getMessage(),LENGTH_LONG).show();
                        }
                    }
                });
                cls.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edit.setText("");
                    }
                });
            }
        }
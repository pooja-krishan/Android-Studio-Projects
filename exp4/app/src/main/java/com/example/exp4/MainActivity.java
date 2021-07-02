package com.example.exp4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Button i,d,u,v,va;
    String spinarray []= {"CSE","MECH","IT","ECE","EEE"};
    EditText name,roll;
    Spinner dept;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=findViewById(R.id.insert);
        d=findViewById(R.id.delete);
        u=findViewById(R.id.update);
        v=findViewById(R.id.view);
        va=findViewById(R.id.view_all);
        name=findViewById(R.id.et1);
        roll=findViewById(R.id.et2);
        dept=(Spinner)findViewById(R.id.spin);
        ArrayAdapter a = new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item,spinarray);
        dept.setAdapter(a);
        db = openOrCreateDatabase("stu_details",MODE_PRIVATE,null);
        db.execSQL("create table if not exists student(name varchar,roll varchar,dept varchar);");
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().trim().length()!=0 &&
                        roll.getText().toString().trim().length()!=0)
                {
                    db.execSQL("insert into student values('"+name.getText().toString()+"','"+roll.getText().toString()+"','"+dept.getSelectedItem().toString()+"');");
                    show("SUCCESS","Data successfully inserted");
                    clear();
                    return;
                }
                else
                {
                    show("ERROR","Please enter all the values");
                }
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roll.getText().toString().trim().length()==0)
                {
                    show("ERROR","Please enter the roll number");
                    return;
                }
                Cursor c = db.rawQuery("select * from student where roll ='"+roll.getText().toString()+"'",null);
                if(c.moveToFirst())
                {
                    db.execSQL("delete from student where roll ="+roll.getText());
                    show("SUCCESS","Record successfully deleted");
                }
                else
                {
                    show("ERROR","Roll number specified does not exist in the database");
                    clear();
                }
            }
        });

        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roll.getText().toString().trim().length()==0)
                {
                    show("ERROR","PLease enter roll number");
                    return;
                }
                else
                {
                    Cursor c = db.rawQuery("select * from student where roll='"+roll.getText().toString()+"';",null);
                    if(c.moveToFirst())
                    {
                        db.execSQL("update student set name='" + name.getText().toString() + "',dept='" + dept.getSelectedItem().toString() + "' where roll='"+roll.getText().toString()+"'");
                        show("SUCCESS","Data successfully updated");
                        clear();
                    }
                    else
                    {
                        show("ERROR","Invalid roll number");
                    }
                }

            }
        });
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roll.getText().toString().trim().length()==0)
                {
                    show("ERROR","Enter a roll number");
                    return;
                }
                else
                {
                    Cursor c = db.rawQuery("select * from student where roll='"+roll.getText().toString()+"';",null);
                    if(c.moveToFirst())
                    {
                        name.setText(c.getString(0));
                        dept.setSelection(getIndex(dept,c.getString(2)));
                    }
                    else
                    {
                        show("ERROR","Invalid roll number");
                        clear();
                    }
                }
            }
        });
        va.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.rawQuery("select * from student",null);
                if(c.getCount()==0)
                {
                    show("ERROR","No records found");
                    return;
                }
                else
                {
                    StringBuffer buffer = new StringBuffer();
                    while(c.moveToNext())
                    {
                        buffer.append("Name: "+c.getString(0)+"\n");
                        buffer.append("Roll number: "+c.getString(1)+"\n");
                        buffer.append("Department: "+c.getString(2)+"\n");
                    }
                    show("STUDENT DETAILS",buffer.toString());
                }
            }
        });
    }
    private int getIndex(Spinner dept, String string) {
        for (int i=0;i<dept.getCount();i++){
            if (dept.getItemAtPosition(i).toString().equalsIgnoreCase(string)){
                return i;
            }
        }
        return 0;
    }

    private void show(String title,String data) {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setCancelable(true); //mandatory since we don't use a positive or negative button
        b.setTitle(title);
        b.setMessage(data);
        b.show();
    }
    private void clear()
    {
        name.setText("");
        roll.setText("");
        dept.setSelection(0);
    }
}
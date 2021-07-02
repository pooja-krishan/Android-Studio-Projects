package com.example.exp2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    String spinarray [] = {"CSE","IT","MECH","ECE","EEE"};
    EditText edt1,edt2;
    Button b;
    String e1,e2,s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.et1);
        edt2 = findViewById(R.id.et2);
        final Spinner s = (Spinner) findViewById(R.id.spin);
        b = findViewById(R.id.button1);

        ArrayAdapter a = new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item,spinarray);
        s.setAdapter(a);
        s.setOnItemSelectedListener(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1=edt1.getText().toString();
                e2=edt2.getText().toString();
                s1=s.getSelectedItem().toString();

                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                i.putExtra("name",e1);
                i.putExtra("roll",e2);
                i.putExtra("dept",s1);
                startActivity(i);
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected = parent.getItemAtPosition(position).toString();
        Toast t = Toast.makeText(parent.getContext(),"Selected department is "+selected,Toast.LENGTH_LONG);
        //Change the orientation of the toast message to where you want it using setGravity.
        // From Bottom y is 700  and from the Right x is 250
        t.setGravity(Gravity.BOTTOM|Gravity.RIGHT,250,700);
        t.show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
}
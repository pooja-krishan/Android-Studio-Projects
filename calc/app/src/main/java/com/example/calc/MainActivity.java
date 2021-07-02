package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,np,ns,nm,nd,ne,cls;
    EditText e;
    int num1=0;
    int num2=0;
    int res=0;
    String ch,r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1= findViewById(R.id.b1);
        n2= findViewById(R.id.b2);
        n3= findViewById(R.id.b3);
        n4= findViewById(R.id.b4);
        n5= findViewById(R.id.b5);
        n6= findViewById(R.id.b6);
        n7= findViewById(R.id.b7);
        n8= findViewById(R.id.b8);
        n9= findViewById(R.id.b9);
        n0= findViewById(R.id.b0);
        np= findViewById(R.id.bp);
        ns= findViewById(R.id.bs);
        nm= findViewById(R.id.bm);
        nd= findViewById(R.id.bd);
        ne= findViewById(R.id.be);
        e= findViewById(R.id.edt);
        cls= findViewById(R.id.clear);

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e.equals(""))
                {
                    e.setText("1");
                }
                else
                {
                    e.append("1");
                }
            }
        });
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e.equals(""))
                {
                    e.setText("2");
                }
                else
                {
                    e.append("2");
                }
            }
        });
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e.equals(""))
                {
                    e.setText("3");
                }
                else
                {
                    e.append("3");
                }
            }
        });
        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e.equals(""))
                {
                    e.setText("4");
                }
                else
                {
                    e.append("4");
                }
            }
        });
        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e.equals(""))
                {
                    e.setText("5");
                }
                else
                {
                    e.append("5");
                }
            }
        });
        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e.equals(""))
                {
                    e.setText("6");
                }
                else
                {
                    e.append("6");
                }
            }
        });
        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e.equals(""))
                {
                    e.setText("7");
                }
                else
                {
                    e.append("7");
                }
            }
        });
        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e.equals(""))
                {
                    e.setText("8");
                }
                else
                {
                    e.append("8");
                }
            }
        });
        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e.equals(""))
                {
                    e.setText("9");
                }
                else
                {
                    e.append("9");
                }
            }
        });
        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e.equals(""))
                {
                    e.setText("0");
                }
                else
                {
                    e.append("0");
                }
            }
        });
        np.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Integer.parseInt(e.getText().toString());
                e.setText("");
                ch="+";
            }
        });
        ns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Integer.parseInt(e.getText().toString());
                e.setText("");
                ch="-";
            }
        });
        nm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Integer.parseInt(e.getText().toString());
                e.setText("");
                ch="*";
            }
        });
        nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Integer.parseInt(e.getText().toString());
                e.setText("");
                ch="/";
            }
        });
        ne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2=Integer.parseInt(e.getText().toString());
                switch(ch)
                {
                    case "+":
                        res=num1+num2;
                        break;
                    case "-":
                        res=num1-num2;
                        break;
                    case "*":
                        res=num1*num2;
                        break;
                    case "/":
                        res=num1/num2;
                        break;
                }
                r=String.valueOf(res);
                e.setText(r);
            }
        });
        cls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e.setText("");
            }
        });
    }
}

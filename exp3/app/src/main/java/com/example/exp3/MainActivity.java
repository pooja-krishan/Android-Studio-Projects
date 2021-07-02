package com.example.exp3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    draw_primitives obj;
    ViewGroup mainview;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainview=findViewById(R.id.mainlayout);
        obj= new draw_primitives(this);
        b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainview.removeView(obj);
                mainview.addView(obj);
            }
        });
    }
    private static class draw_primitives extends View
    {
        Paint p;
        int ch=1;
        public draw_primitives(Context context) {
            super(context);
            p=new Paint();
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            p.setColor(Color.RED);
            p.setStyle(Paint.Style.FILL);
            switch(ch) {
                case 1:
                    canvas.drawRect(300, 700, 800, 1000, p);
                    break;
                case 2:
                    canvas.drawCircle(550, 900, 100, p);
                    break;
                case 3:
                    canvas.drawLine(500,800,500,1500,p);
                    break;
                case 4:
                    canvas.drawArc(300,800,800,1000,0,-180,true,p);
                    //-180 to orient the oval to span from the first quadrant to the second in the anticlockwise direction
                    //and not from the fourth quadrant to the third in the clockwise direction.
                    break;
            }
            ch++;
            if(ch==5)
                ch=1;
        }
    }
}



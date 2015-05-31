package com.example.cravisundaram.listintent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by C RAVI SUNDARAM on 29-05-2015.
 */
public class Serif extends Activity {
    TextView t;
    String msg2,color,size,check1,check2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello);
        t=(TextView)findViewById(R.id.textView);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        msg2=getIntent().getExtras().getString("msg1");
        color=getIntent().getExtras().getString("text1");
        size=getIntent().getExtras().getString("text2");
        check1=getIntent().getExtras().getString("check1");
        check2=getIntent().getExtras().getString("check2");
        t.setText(msg2);
        if(color.equals("Red"))
            t.setTextColor(Color.RED);

        else if(color.equals("Blue"))
            t.setTextColor(Color.BLUE);

        else if(color.equals("Green"))
            t.setTextColor(Color.GREEN);

        else if(color.equals("Yellow"))
            t.setTextColor(Color.YELLOW);
        if(size.equals("Small"))
            t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        if(size.equals("Medium"))
            t.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        if(size.equals("Large"))
            t.setTextSize(TypedValue.COMPLEX_UNIT_SP,22);
        if(check1.equals("True"))
        {
            if(check2.equals("True"))
                t.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);
            else t.setTypeface(Typeface.SERIF,Typeface.BOLD);
        }
        else
        {
            if(check2.equals("True"))
                t.setTypeface(Typeface.SERIF, Typeface.ITALIC);
            else t.setTypeface(Typeface.SERIF,Typeface.NORMAL);
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                homeIntent.addCategory( Intent.CATEGORY_HOME );
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Serif.this,MainActivity.class);
                startActivity(i);
            }
        });


    }

}

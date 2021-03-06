package com.example.cravisundaram.listintent;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * Created by C RAVI SUNDARAM on 28-05-2015.
 */
public class Final extends Activity {

    TextView t;
    String msg2,color,size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello);
        t=(TextView)findViewById(R.id.textView);
        msg2=getIntent().getExtras().getString("msg1");
        color=getIntent().getExtras().getString("text1");
        size=getIntent().getExtras().getString("text2");
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
            t.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        if(size.equals("Medium"))
            t.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        if(size.equals("Large"))
            t.setTextSize(TypedValue.COMPLEX_UNIT_SP,22);
    }
}

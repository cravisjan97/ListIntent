package com.example.cravisundaram.listintent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends Activity {
    String []fonts=new String[]{"Serif","Sans","Monospace"};
    ListView lv;
    ArrayAdapter<String> adapter;
    EditText e;
    String msg,a,a2;
    Spinner s,s2;
    String w=null;
    CheckBox c,c2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listView);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fonts);
        lv.setAdapter(adapter);
        e=(EditText)findViewById(R.id.editText);
        s=(Spinner)findViewById(R.id.spinner);
        s2=(Spinner)findViewById(R.id.spinner2);
        c=(CheckBox)findViewById(R.id.checkBox);
        c2=(CheckBox)findViewById(R.id.checkBox2);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    Class ourClass = Class.forName("com.example.cravisundaram.listintent." + fonts[position]);
                    Intent i = new Intent(MainActivity.this, ourClass);
                    String text_c = s.getSelectedItem().toString();
                    String text_s = s2.getSelectedItem().toString();
                    if(c.isChecked())
                        a="True";
                    else a="False";
                    if(c2.isChecked())
                        a2="True";
                    else a2="False";
                    msg = e.getText().toString();
                    if(msg.equals("")) {

                        Toast.makeText(getApplicationContext(), "Please enter a string.",
                                Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        i.putExtra("msg1", msg);
                        i.putExtra("text1", text_c);
                        i.putExtra("text2", text_s);
                        i.putExtra("check1", a);
                        i.putExtra("check2", a2);
                        startActivity(i);
                    }
                }catch (ClassNotFoundException e2)
                {
                    e2.printStackTrace();
                }


            }});

    }
}




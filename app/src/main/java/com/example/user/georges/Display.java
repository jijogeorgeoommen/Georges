package com.example.user.georges;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Display extends AppCompatActivity {
    EditText namedis,agedis,add1dis,add2dis,add3dis,phonedis;
    String namedisstr,agedisstr,add1disstr,add2disstr,add3disstr,phonedisstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        namedis=findViewById(R.id.nameid);
        agedis=findViewById(R.id.ageid);
        add1dis=findViewById(R.id.add1id);
        add2dis=findViewById(R.id.add2id);
        add3dis=findViewById(R.id.add3id);
        phonedis=findViewById(R.id.phoneid);
        SharedPreferences obj=getApplicationContext().getSharedPreferences("spf",MODE_PRIVATE);
        String namedisstr=obj.getString("key1",null);
        String agedisstr=obj.getString("key2",null);
        String add1disstr=obj.getString("key3",null);
        String add2disstr=obj.getString("key4",null);
        String add3disstr=obj.getString("key5",null);
        String phonedisstr=obj.getString("key6",null);
        namedis.setText(namedisstr);
        agedis.setText(agedisstr);
        add1dis.setText(add1disstr);
        add2dis.setText(add2disstr);
        add3dis.setText(add3disstr);
        phonedis.setText(phonedisstr);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder AB=new AlertDialog.Builder(Display.this);
        AB.setMessage("Do you really want to exit").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();

            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog A=AB.create();
        A.setTitle("EXIT SCREEN");
        A.show();
       // super.onBackPressed();
    }

    public void Logout(View view) {
        SharedPreferences obj=getApplicationContext().getSharedPreferences("spf",MODE_PRIVATE);
        SharedPreferences.Editor edt=obj.edit();
        edt.clear();
        edt.apply();
        finish();
    }
}

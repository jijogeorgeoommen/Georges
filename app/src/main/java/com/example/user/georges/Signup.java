package com.example.user.georges;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Signup extends AppCompatActivity {
    EditText nameup,ageup,add1up,add2up,add3up,phoneup,passup;
    String nameupstr,ageupstr,add1upstr,add2upstr,add3upstr,phoneupstr,passupstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        nameup=findViewById(R.id.namesup);
        ageup=findViewById(R.id.agesup);
        add1up=findViewById(R.id.add1sup);
        add2up=findViewById(R.id.add2sup);
        add3up=findViewById(R.id.add3sup);
        phoneup=findViewById(R.id.phonesup);
        passup=findViewById(R.id.passid);

    }

    public void submit(View view) {
        String nameupstr=nameup.getText().toString();
        String ageupstr=ageup.getText().toString();
        String add1upstr=add1up.getText().toString();
        String add2upstr=add2up.getText().toString();
        String add3upstr=add3up.getText().toString();
        String phoneupstr=phoneup.getText().toString();
        String passupstr=passup.getText().toString();
        SharedPreferences obj=getApplicationContext().getSharedPreferences("spf",MODE_PRIVATE);
        SharedPreferences.Editor edt=obj.edit();
        edt.putString("key1",nameupstr);
        edt.putString("key2",ageupstr);
        edt.putString("key3",add1upstr);
        edt.putString("key4",add2upstr);
        edt.putString("key5",add3upstr);
        edt.putString("key6",phoneupstr);
        edt.putString("key7",passupstr);
        edt.apply();
        Intent i=new Intent(Signup.this,Signin.class);
        if (nameupstr.equals("")){
            nameup.setError("Enter name");
        }
        else if (ageupstr.equals("")){
            ageup.setError("Enter age...");
        }
        else if (add1upstr.equals("")){
            add1up.setError("Enter the address");
        }
        else if (phoneupstr.equals("")){
            phoneup.setError("Enter phone number");
        }
        else{
            startActivity(i);
        }

    }
}

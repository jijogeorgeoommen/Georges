package com.example.user.georges;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signin extends AppCompatActivity {
    EditText usernamein,passwordin,name1,pass1;
    String usernameinstr,passwordinstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        usernamein=findViewById(R.id.userin);
        passwordin=findViewById(R.id.passin);
    }

    @Override
    protected void onResume() {
        SharedPreferences obj=getApplicationContext().getSharedPreferences("spf",MODE_PRIVATE);
        usernameinstr=obj.getString("key1",null);
        usernamein.setText(usernameinstr);
        passwordinstr=obj.getString("key7",null);
        passwordin.setText(passwordinstr);

        super.onResume();
    }

    public void signinoc(View view) {
        String usernameinstr=usernamein.getText().toString();
        String passwordinstr=passwordin.getText().toString();   //
        SharedPreferences obj=getApplicationContext().getSharedPreferences("spf",MODE_PRIVATE);
        String name1str=obj.getString("key1",null);
        String pass1str=obj.getString("key7",null);
//        name1.setText(name1str);
//        pass1.setText(pass1str);




        if (usernameinstr.equals(name1str)&&passwordinstr.equals(pass1str)){
            Intent a=new Intent(Signin.this,Display.class);

            startActivity(a);

        }
        else {
            Toast.makeText(this, "invalid username/password...", Toast.LENGTH_SHORT).show();
        }


    }

    public void signupoc(View view) {
        Intent i=new Intent(Signin.this,Signup.class);
        startActivity(i);
    }
}

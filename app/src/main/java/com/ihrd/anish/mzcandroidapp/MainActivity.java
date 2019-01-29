package com.ihrd.anish.mzcandroidapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText ed1,ed2;
TextView tv1;
Button b,b1,b2,b3,b4;
String getUsername,getPassword,checkUsername,testString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref=getSharedPreferences("login",MODE_PRIVATE);

        checkUsername=pref.getString("username",null);


        if(checkUsername!=null)
        {
            Intent i=new Intent(getApplicationContext(),WelcomeActivity.class);
            startActivity(i);
        }


        tv1=(TextView)findViewById(R.id.test);
        ed1=(EditText)findViewById(R.id.uname);
        ed2=(EditText)findViewById(R.id.password);
        b=(Button)findViewById(R.id.loginbutton);
        b1=(Button)findViewById(R.id.regButton) ;
        b2=(Button)findViewById(R.id.nextApp);
        b3=(Button)findViewById(R.id.viewUsers) ;

        b4=(Button)findViewById(R.id.db) ;

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),DataEntry.class);
                startActivity(i);

            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),UserList.class);
                startActivity(i);

            }
        });

//        for(int i=0;i<3;i++)
//        {
//
//            testString += "Name: " + i + "\n\n";
//
//        }

//        tv1.setText(testString);


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Calculator.class);
                startActivity(i);
            }
        });


     b.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             getUsername=ed1.getText().toString();
             getPassword=ed2.getText().toString();

if(getUsername.equals("mzc")&&getPassword.equals("college"))
{

    SharedPreferences.Editor editor=getSharedPreferences("login",MODE_PRIVATE).edit();
    editor.putString("username",getUsername);
    editor.putString("password",getPassword);
    editor.apply(); // editor.commit();



    Intent i=new Intent(getApplicationContext(),WelcomeActivity.class);

    i.putExtra("username",getUsername);
    i.putExtra("password",getPassword);



    startActivity(i);
}
//             Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_LONG).show();
         }
     });


     b1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent i =new Intent(getApplicationContext(),RegisterActivity.class);
             startActivity(i);

         }
     });





    }
}

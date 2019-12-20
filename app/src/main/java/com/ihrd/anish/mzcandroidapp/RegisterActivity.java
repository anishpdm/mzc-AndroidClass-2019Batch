package com.ihrd.anish.mzcandroidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Button regb1,regb2;
    EditText ed1,ed2,ed3,ed4;
    String getPass,getName,getEmail,getUser;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseHelper=new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();

        regb1=(Button)findViewById(R.id.regButton);
        regb2=(Button)findViewById(R.id.alreadyRegButton);

        ed1=(EditText)findViewById(R.id.pass);
        ed2=(EditText)findViewById(R.id.usr);

        ed3=(EditText)findViewById(R.id.name);

        ed4=(EditText)findViewById(R.id.email);





        regb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });


        regb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getPass=ed1.getText().toString();
                getEmail=ed4.getText().toString();
                getName=ed3.getText().toString();
                getUser=ed2.getText().toString();


                boolean status= databaseHelper.signUp(getName,getEmail,getUser,getPass);
                if(status==true)
                {
                    Toast.makeText(getApplicationContext(),"Succesfully Inserted",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();

                }


            }
        });



    }
}

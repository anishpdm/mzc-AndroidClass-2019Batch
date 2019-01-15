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
    EditText ed1,ed2;
    String getPass,getcnfPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regb1=(Button)findViewById(R.id.regButton);
        regb2=(Button)findViewById(R.id.alreadyRegButton);

        ed1=(EditText)findViewById(R.id.pass);
        ed2=(EditText)findViewById(R.id.cnfpass);



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
                getcnfPass=ed2.getText().toString();


                if(getPass.equals(getcnfPass))
                {


                }
                else
                {
            Toast.makeText(getApplicationContext(),"Password & Confirm Password doesnt Match",Toast.LENGTH_LONG).show();
                }


            }
        });



    }
}

package com.ihrd.anish.mzcandroidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DataEntry extends AppCompatActivity {


    Button b,b1;
    EditText ed1,ed2;
    String s1,s2;
    DatabaseHelper databaseHelper;

    @Override
    public void onBackPressed() {

        Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        b=(Button)findViewById(R.id.but);
        b1=(Button)findViewById(R.id.Searchbut);


        ed1=(EditText)findViewById(R.id.name);
        ed2=(EditText)findViewById(R.id.email);
        databaseHelper=new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();

b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(getApplicationContext(),SearchActivity.class);
        startActivity(i);
    }
});

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=ed1.getText().toString();
                s2=ed2.getText().toString();
                Log.d("name",s1);
                Log.d("email",s2);

           boolean status= databaseHelper.insertData(s1,s2);
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

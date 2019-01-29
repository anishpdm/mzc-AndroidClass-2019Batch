package com.ihrd.anish.mzcandroidapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    String usr,pass,CheckUser;
    String getUser,getPass;
    Button b;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);



//        SharedPreferences pref=getSharedPreferences("login",MODE_PRIVATE);
//        CheckUser=pref.getString("username",null);
//
//        Toast.makeText(getApplicationContext(),CheckUser,Toast.LENGTH_LONG).show();
//
//        if(CheckUser==null)
//        {
//            Intent i=new Intent(getApplicationContext(),MainActivity.class);
//            startActivity(i);
//        }


      lv=(ListView)findViewById(R.id.myListView);
      String[] Students={"Rajesh","Remya","Rahul","Nithin"};

      ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(),R.layout.activity_list_items_view,Students);

      lv.setAdapter(adapter);






        b=(Button)findViewById(R.id.logoutbutton) ;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

          SharedPreferences.Editor editor=getSharedPreferences("login",MODE_PRIVATE).edit();

          editor.clear();
          editor.commit();

          Intent i=new Intent(getApplicationContext(),MainActivity.class);
          startActivity(i);


            }
        });



        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        getUser=sharedPreferences.getString("username",null);
        getPass=sharedPreferences.getString("password",null);
        Toast.makeText(getApplicationContext(),getUser,Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),getPass,Toast.LENGTH_LONG).show();

//
//        Intent i=getIntent();
//        usr=i.getExtras().getString("username");
//
//        pass=i.getStringExtra("password");

//        Toast.makeText(getApplicationContext(),usr,Toast.LENGTH_LONG).show();
//        Toast.makeText(getApplicationContext(),pass,Toast.LENGTH_LONG).show();

    }
}

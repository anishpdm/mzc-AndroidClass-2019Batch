package com.ihrd.anish.mzcandroidapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {


    Button b,u;
    EditText ed,ed1;
    String getName,getEmail,getId;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        databaseHelper=new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();

        u=(Button)findViewById(R.id.UpdateButton);

        b=(Button)findViewById(R.id.searchbutton);
        ed=(EditText)findViewById(R.id.readname);

        ed1=(EditText)findViewById(R.id.res);



        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newVal=ed1.getText().toString();
             boolean status=   databaseHelper.Update(newVal,getId);
                if(status==true)
                {
                    Toast.makeText(getApplicationContext(),"Succesfully Updated",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();

                }
            }
        });


        b.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              getName=ed.getText().toString();

              Log.d("Name",getName);

              Cursor cur=databaseHelper.SearchData(getName);
              if(cur.getCount()==0)
              {
                  Toast.makeText(getApplicationContext(),"No Name Found",Toast.LENGTH_LONG).show();
              }
              else
              {
                  while (cur.moveToNext())
                  {
                      getEmail= cur.getString(2);
                      getId= cur.getString(0);

                      ed1.setText(getEmail);


                  }

              }



          }
      });






    }
}

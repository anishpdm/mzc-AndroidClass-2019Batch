package com.ihrd.anish.mzcandroidapp;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {


    Button b,u,del;
    EditText ed,ed1;
    String getName,getEmail,getId,newEmail;
    DatabaseHelper databaseHelper;

    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        databaseHelper=new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();

        u=(Button)findViewById(R.id.UpdateButton);

        del=(Button)findViewById(R.id.DeleteButton);

        b=(Button)findViewById(R.id.searchbutton);
        ed=(EditText)findViewById(R.id.readname);

        ed1=(EditText)findViewById(R.id.res);


         builder = new AlertDialog.Builder(this);

        builder.setTitle("Confirm");
        builder.setMessage("Are you sure?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog

                dialog.dismiss();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing
                dialog.dismiss();
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog alert = builder.create();
                alert.show();




            }
        });



        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 newEmail=ed1.getText().toString();

                boolean status= databaseHelper.UpdateData(getId,newEmail);

                if(status==true)
                {
                    Toast.makeText(getApplicationContext(),"UPDATED Succesfully ",Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(getApplicationContext(),"Error in UPDATION",Toast.LENGTH_LONG).show();

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

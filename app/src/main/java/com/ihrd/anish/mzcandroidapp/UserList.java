package com.ihrd.anish.mzcandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserList extends AppCompatActivity {

    TextView textView;
    String getName,getUsername,getEmail,getStreet,getsuite,getZipcode,getCity,getPhone,getWebsite,finalData="";
    String url="https://jsonplaceholder.typicode.com/users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        textView=(TextView)findViewById(R.id.tv);




        FetchData();


    }

    private void FetchData() {

        Log.d("test","working");

StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                // Handle Responses

                Log.d("response",response);

                try
                {
                  JSONArray jsonArray=new JSONArray(response);
                  for(int i=0;i<jsonArray.length();i++)
                  {
                      JSONObject jsonObject=jsonArray.getJSONObject(i);

                      getName=jsonObject.getString("name");

                      getUsername=jsonObject.getString("username");

                      getEmail=jsonObject.getString("email");

                      getPhone=jsonObject.getString("phone");

                      getWebsite=jsonObject.getString("website");



                      Log.d("Names",getName);


                      // Address

                      JSONObject ob1=new JSONObject(jsonObject.getString("address"));
                      getStreet=ob1.getString("street");
                      getCity=ob1.getString("city");
                      getZipcode=ob1.getString("zipcode");
                      getsuite=ob1.getString("suite");


                      Log.d("Address",getStreet);

                      finalData += "Name : " + getName + "\n";
                      finalData += "Email Id : " + getEmail + "\n";
                      finalData += "Username : " + getUsername + "\n\n" +
                              "\n";








                  }

                  textView.setText(finalData);


                }
                catch(JSONException ob)
                {

                    Log.d("Exception",ob.toString());


                }



            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Handle Errors

            }
        }
);


        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);






    }
}

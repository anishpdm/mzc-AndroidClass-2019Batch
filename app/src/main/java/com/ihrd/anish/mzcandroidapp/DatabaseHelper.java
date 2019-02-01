package com.ihrd.anish.mzcandroidapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String Dbname="MyDb.db";
    public static final String TableName="student";
    public static final String col1="id";
    public static final String col2="name";
    public static final String col3="email";


    public DatabaseHelper(Context context) {

        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       String query="create table "+TableName+"( " +col1+" integer primary key autoincrement,"+col2+" text,"+col3+" text)";
       db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query="drop table if exists "+TableName;
        db.execSQL(query); // DROP Table
        onCreate(db);
    }



    public boolean insertData(String name,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(col2,name);
        contentValues.put(col3,email);

      long status = db.insert(TableName,null,contentValues);

if(status==-1)
{
    return false;
}
else {
    return true;
}
    }


    // Retrieval of Data

   public Cursor SearchData(String name)
   {
       SQLiteDatabase db=this.getWritableDatabase();

      Cursor cur= db.rawQuery("SELECT * FROM "+TableName+" WHERE "+col2+"='"+name+"'",null);

      return cur;


   }



   // Update

public boolean UpdateData(String id,String email)
{
    SQLiteDatabase db=this.getWritableDatabase();

    ContentValues contentValues=new ContentValues();
    contentValues.put(col3,email);

    long status=db.update(TableName,contentValues,col1 + "=" +id,null);
    if(status==-1)
    {
        return false;
    }
    else {
        return true;
    }

}


// Delete

    public boolean DeleteData(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();



        long status=db.delete(TableName,col1 + "=" +id,null);
        if(status==-1)
        {
            return false;
        }
        else {
            return true;
        }

    }




















}

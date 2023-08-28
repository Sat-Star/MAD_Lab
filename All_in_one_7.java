//DataBaseConn.java

package com.example.medicinereminder;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class DataBaseConn extends SQLiteOpenHelper {
    public DataBaseConn(Context context) {
        super(context, "MedicineDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table MDTable(MedicineName Text,date TEXT,time TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertvalues(String medname,String meddate,String medtime)
    {
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("MedicineName",medname);
        contentValues.put("date",meddate);
        contentValues.put("time",medtime);
        long res=database.insert("MDTable",null,contentValues);
        if(res==-1)
            return false;
        else
            return true;
    }

    public Cursor FetchData(String date,String time)
    {
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor c=database.rawQuery("Select * from MDTable where date='"+date+"' AND time='"+time+"'",null);
        return c;
    }
}

//MainActivity.java

package com.example.medicinereminder;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText medName,medDate;
    Button insert,fetch;
    Spinner day;
    Switch switch1;
    TextView medTxt;
    DataBaseConn dbConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        medName=(EditText)findViewById(R.id.medicinename);
        medDate=(EditText)findViewById(R.id.date);
        insert=(Button)findViewById(R.id.insert);
        fetch=(Button)findViewById(R.id.fetch);
        day=(Spinner)findViewById(R.id.spinner);
        switch1=(Switch)findViewById(R.id.switch1);
        medTxt=(TextView)findViewById(R.id.medtext);
        dbConnection=new DataBaseConn(this);

        fetch.setVisibility(View.INVISIBLE);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!b)
                {
                    fetch.setVisibility(View.INVISIBLE);
                    insert.setVisibility(View.VISIBLE);
                    medName.setVisibility(View.VISIBLE);
                    medTxt.setVisibility(View.VISIBLE);
                }
                else {
                    fetch.setVisibility(View.VISIBLE);
                    insert.setVisibility(View.INVISIBLE);
                    medName.setVisibility(View.INVISIBLE);
                    medTxt.setVisibility(View.INVISIBLE);

                }
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=medName.getText().toString();
                String date=medDate.getText().toString();
                String time=day.getSelectedItem().toString();
                boolean insert=dbConnection.insertvalues(name,date,time);
                if(insert==true)
                {
                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_LONG).show();
                    medName.setText(" ");
                    medDate.setText(" ");
                }
                else {
                    Toast.makeText(getApplicationContext(), "Data Not Inserted", Toast.LENGTH_LONG).show();
                }
            }
        });

        fetch.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                String date=medDate.getText().toString();
                String time=day.getSelectedItem().toString();
                String med="";
                Cursor c=dbConnection.FetchData(date,time);
                if(c.moveToFirst()) {
                    do {
                        med = med + (String.valueOf(c.getString(c.getColumnIndex("MedicineName"))));
                        med += "\n";
                    } while (c.moveToNext());
                    Toast.makeText(getApplicationContext(), med, Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "No Entries in Database", Toast.LENGTH_SHORT).show();
            }
        });

    }
}


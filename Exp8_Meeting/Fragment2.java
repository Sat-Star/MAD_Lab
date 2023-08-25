package com.example.meetinginfo;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText date;
    CalendarView cal;
    Button btn1;
    DataBaseConn dbc;
    TextView t;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_2,container,false);
        date=view.findViewById(R.id.editTextDate);
        cal=view.findViewById(R.id.calendarView);
        btn1=view.findViewById(R.id.btn2);
        dbc=new DataBaseConn(getActivity());
        // t=()
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String d=dayOfMonth+"/"+(month+1)+"/"+year;
                date.setText(d);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                String d1=date.getText().toString();
                StringBuffer res=new StringBuffer();
                Cursor c=dbc.fetch(d1);
                int count=c.getCount();
                c.moveToFirst();
                if(count>0) {
                    do {

                        res.append(c.getString(c.getColumnIndex("agenda"))+"\t"+"at"+"\t"+c.getString(c.getColumnIndex("time")));
                        res.append("\n");
                        //med =(String.valueOf(c.getString(c.getColumnIndex("agenda"))));
                        //med1 =(String.valueOf(c.getString(c.getColumnIndex("time"))));
                    }while (c.moveToNext());
                    Toast.makeText(getActivity(), res,
                            Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getActivity(), "No Meeting on This Day....", Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}

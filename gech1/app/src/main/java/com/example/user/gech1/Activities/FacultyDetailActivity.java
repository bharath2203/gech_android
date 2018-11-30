package com.example.user.gech1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.gech1.Adapters.FacultyAdapter;
import com.example.user.gech1.Data.Faculty;
import com.example.user.gech1.R;

import java.util.ArrayList;

public class FacultyDetailActivity extends AppCompatActivity {

    ListView listView;
    FacultyAdapter adapter;
    FacultyActivity FacObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_detail);


        Intent intent = getIntent();
        //Bundle bundle = intent.getBundleExtra("BUNDLE");

        FacObj = new FacultyActivity();
        ArrayList<Faculty> faculties = FacObj.getDummy_facultys();
                // (ArrayList<Faculty>) bundle.getSerializable("faculties");
        ArrayList<Faculty> F = new ArrayList<>();

        for (int i = 0; i < faculties.size(); i++){
            Faculty fac = faculties.get(i);
            System.out.println(fac.getDepartment());
        }
        String position = new String(intent.getStringExtra("position"));
        //Integer position = 0;
        if(position.equals("0")){
            for(int i = 0; i < faculties.size(); i++){
                Faculty fac = faculties.get(i);
                if(fac.getDepartment().equals("CS")){
                    F.add(fac);
                }
            }
        }
        else if(position.equals("1")){

            for(int i = 0; i < faculties.size(); i++){
                Faculty fac = faculties.get(i);
                if(fac.getDepartment().equals("ENC")){
                    F.add(fac);
                }
            }
        }
        else if(position.equals("2")){

            for(int i = 0; i < faculties.size(); i++){
                Faculty fac = faculties.get(i);
                if(fac.getDepartment().equals("ME")){
                    F.add(fac);
                }
            }
        }
        else if(position.equals("3")){

            for(int i = 0; i < faculties.size(); i++){
                Faculty fac = faculties.get(i);
                if(fac.getDepartment().equals("CV")){
                    F.add(fac);
                }
            }
        }
        else if(position.equals("4")){

            for(int i = 0; i < faculties.size(); i++){
                Faculty fac = faculties.get(i);
                if(fac.getDepartment().equals("CS")){
                    F.add(fac);
                }
            }
        }
        else if(position.equals("5")){

            for(int i = 0; i < faculties.size(); i++){
                Faculty fac = faculties.get(i);
                if(fac.getDepartment().equals("CS")){
                    F.add(fac);
                }
            }
        }
        else if(position.equals("6")){

            for(int i = 0; i < faculties.size(); i++){
                Faculty fac = faculties.get(i);
                if(fac.getDepartment().equals("CS")){
                    F.add(fac);
                }
            }
        }
        else if(position.equals("7")){

            for(int i = 0; i < faculties.size(); i++){
                Faculty fac = faculties.get(i);
                if(fac.getDepartment().equals("CS")){
                    F.add(fac);
                }
            }
        }
        adapter = new FacultyAdapter(this, -1, F);
        listView = (ListView)findViewById(R.id.faculty_lists);
        listView.setAdapter(adapter);


    }
}

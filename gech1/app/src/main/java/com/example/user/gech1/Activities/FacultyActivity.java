package com.example.user.gech1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;

import android.widget.ListView;
import com.example.user.gech1.Adapters.SimpleAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.user.gech1.Data.Faculty;
import com.example.user.gech1.MConfig;
import com.example.user.gech1.MySingleton;
import com.example.user.gech1.R;
import com.example.user.gech1.utils.FacultyUtil;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;

public class FacultyActivity extends AppCompatActivity {
    private String FACULTY_URL = MConfig.BASE_URL + "student/api/faculty";

    SimpleAdapter adapter;
    ArrayList<String> departments;
    ListView list;
    static private ArrayList<Faculty> dummy_facultys;


    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition(new Fade());
        getWindow().setEnterTransition(new Explode());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        departments = new ArrayList<>();
        departments.add("Computer Science");
        departments.add("Electronics");
        departments.add("Mechanical");
        departments.add("Civil");
        departments.add("Basic Science");
        departments.add("English and Humanities");
        departments.add("Physical Education");
        departments.add("Library");

        adapter = new SimpleAdapter(this, -1, departments);
        list = (ListView)findViewById(R.id.department_lists);
        list.setAdapter(adapter);

        makeHttpRequest();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<Faculty> faculties = new ArrayList<>();
                //System.out.println(position)
               /* if(position == 0){
                    for(Faculty fac : dummy_facultys){
                        System.out.println(fac.getDepartment());
                        if(fac.getDepartment() == "CS"){
                            faculties.add(fac);
                            System.out.println(fac.getName());
                        }
                    }
                }
                else if(position == 1){

                    for(Faculty fac : dummy_facultys){
                        if(fac.getDepartment() == "EC"){
                            faculties.add(fac);
                        }
                    }
                }
                else if(position == 2){

                    for(Faculty fac : dummy_facultys){
                        if(fac.getDepartment() == "ME"){
                            faculties.add(fac);
                        }
                    }
                }
                else if(position == 3){

                    for(Faculty fac : dummy_facultys){
                        if(fac.getDepartment() == "CV"){
                            faculties.add(fac);
                        }
                    }
                }
                else if(position == 4){

                    for(Faculty fac : dummy_facultys){
                        if(fac.getDepartment() == "CS"){
                            faculties.add(fac);
                        }
                    }
                }
                else if(position == 5){

                    for(Faculty fac : dummy_facultys){
                        if(fac.getDepartment() == "CS"){
                            faculties.add(fac);
                        }
                    }
                }
                else if(position == 6){

                    for(Faculty fac : dummy_facultys){
                        if(fac.getDepartment() == "CS"){
                            faculties.add(fac);
                        }
                    }
                }
                else if(position == 7){

                    for(Faculty fac : dummy_facultys){
                        if(fac.getDepartment() == "CS"){
                            faculties.add(fac);
                        }
                    }
                }
                */
                Intent intent = new Intent(FacultyActivity.this, FacultyDetailActivity.class);
                //Bundle bundle = new Bundle();
                //bundle.putSerializable("faculties",(Serializable)faculties);
                //intent.putExtra("BUNDLE",bundle);
                intent.putExtra("position", Integer.toString(position));
                startActivity(intent);
                }
        });

    }

    public ArrayList<Faculty> getDummy_facultys() {
        return dummy_facultys;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    public void makeHttpRequest() {
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, FACULTY_URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        dummy_facultys = new ArrayList<>(FacultyUtil.createObjectsArray(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(FacultyActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }
        );
        MySingleton.getInstance().addToRequestQueue(jsonObjectRequest);

    }
}

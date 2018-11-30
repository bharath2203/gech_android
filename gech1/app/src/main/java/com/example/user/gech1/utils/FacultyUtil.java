package com.example.user.gech1.utils;
import android.content.Context;
import android.util.Log;

import com.example.user.gech1.Data.Faculty;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FacultyUtil {

    private static Context context;


    public FacultyUtil(Context context) {
        this.context = context;
    }

    public static ArrayList<Faculty> createObjectsArray(JSONArray facultyArray) {
        ArrayList<Faculty> faculties = new ArrayList<>();

        try {
            for (int i = 0; i < facultyArray.length(); i++) {

                JSONObject currentfaculty = facultyArray.getJSONObject(i);

                String name = currentfaculty.getString("name");
                String degree = currentfaculty.getString("degree");
                String achievements = currentfaculty.getString("achievements");
                String department = currentfaculty.getString("department_id");
                String phone_no = currentfaculty.getString("phone_no");
                String email_id = currentfaculty.getString("email_id");
                String position = currentfaculty.getString("position");
                String image = currentfaculty.getString("image");
                //System.out.println(title);

                Faculty facultyObj = new Faculty(name, degree, achievements, department,
                        phone_no, email_id, position, image);
                faculties.add(facultyObj);
            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the facultys JSON results", e);
        }

        return faculties;
    }

    public Context getApplicationContext() {
        return context;
    }
}

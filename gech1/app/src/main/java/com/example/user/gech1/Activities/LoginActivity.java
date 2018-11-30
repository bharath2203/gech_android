package com.example.user.gech1.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.user.gech1.MConfig;
import com.example.user.gech1.MySingleton;
import com.example.user.gech1.R;
import com.example.user.gech1.utils.FacultyUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    EditText edit_box;
    private StringBuilder STUDENT_URL = new StringBuilder(MConfig.BASE_URL + "student/api/");
    private String FINAL_STUDENT_URL;
    Boolean isFirstTime;
    private Context context;

    public LoginActivity(){
        this.context = this;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {

                SharedPreferences app_preferences = PreferenceManager
                        .getDefaultSharedPreferences(getContext());

                SharedPreferences.Editor editor = app_preferences.edit();


                isFirstTime = app_preferences.getBoolean("isFirstTime", true);

                if (isFirstTime) {
                    setContentView(R.layout.activity_login);
                }else{
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 3000);


    }

    public Context getContext(){
        return context;
    }

    public void Login(View view) {
        edit_box = (EditText)findViewById(R.id.user_usn);
        String user_usn = edit_box.getText().toString();
        System.out.println(user_usn);
        STUDENT_URL.append(user_usn);
        System.out.print(FINAL_STUDENT_URL);
        FINAL_STUDENT_URL = new String(STUDENT_URL);
        makeHttpRequest();

        //editor.putBoolean("isFirstTime", false);
        //editor.commit()
    }

    public void makeHttpRequest() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, FINAL_STUDENT_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            SharedPreferences app_preferences = PreferenceManager
                                    .getDefaultSharedPreferences(getApplicationContext());

                            SharedPreferences.Editor editor = app_preferences.edit();



                            editor.putString("usn", response.getString("usn"));
                            editor.putString("name", response.getString("name"));
                            editor.putString("department", response.getString("department_id"));
                            editor.putString("sem", response.getString("sem"));
                            editor.putString("image", response.getString("image"));
                            editor.putString("student_phone_no", response.getString("student_phone_no"));
                            editor.putString("parents_phone_no", response.getString("parents_phone_no"));
                            editor.putString("father_name", response.getString("father_name"));
                            editor.putString("mother_name", response.getString("mother_name"));
                            editor.putString("date_of_birth", response.getString("date_of_birth"));
                            editor.putString("address", response.getString("address"));
                            editor.putString("email_id", response.getString("email_id"));
                            editor.putBoolean("isFirstTime", false);
                            isFirstTime = false;
                            editor.commit();
                            System.out.println(response.getString("name"));
                            Intent intent = new Intent(getContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        } catch (JSONException e) {
                            Toast.makeText(context, "Error Occured here", Toast.LENGTH_SHORT).show();
                            isFirstTime = true;
                            setContentView(R.layout.login_failed);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        isFirstTime = true;
                        setContentView(R.layout.login_failed);
                        error.printStackTrace();
                    }
                }
        );
        MySingleton.getInstance().addToRequestQueue(jsonObjectRequest);

    }

}

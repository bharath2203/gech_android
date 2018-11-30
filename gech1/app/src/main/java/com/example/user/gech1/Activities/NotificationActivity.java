package com.example.user.gech1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.user.gech1.MConfig;
import com.example.user.gech1.MySingleton;
import com.example.user.gech1.Data.Notification;
import com.example.user.gech1.Adapters.NotificationAdapter;
import com.example.user.gech1.utils.NotificationUtil;
import com.example.user.gech1.R;

import org.json.JSONArray;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {

    private String NOTIFICATION_URL = MConfig.BASE_URL + "student/api/notifications";

    NotificationAdapter notificationAdapter;

    ListView list;

    private static ArrayList<Notification> notifications = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        setList();
        makeHttpRequest();



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Notification notificationToBePasssed;
               notificationToBePasssed = (Notification)parent.getItemAtPosition(position);
               //Toast.makeText(NotificationActivity.this, notificationToBePasssed.getTitle(), Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(NotificationActivity.this, NotificationDetailActivity.class);
               intent.putExtra("title", notificationToBePasssed.getTitle());
               intent.putExtra("content", notificationToBePasssed.getContent());
               intent.putExtra("date", notificationToBePasssed.getDate());
               intent.putExtra("time", notificationToBePasssed.getTime());
               intent.putExtra("department", notificationToBePasssed.getDepartment());
               startActivity(intent);
            }
        });


    }

    public void setList(){
        notificationAdapter = new NotificationAdapter(NotificationActivity.this, -1, notifications);
        list = (ListView)findViewById(R.id.notification_lists);
        list.setAdapter(notificationAdapter);
    }

    public void updateAdapter(ArrayList<Notification> dummy_notifications) {
        notificationAdapter.clear();
        notificationAdapter.addAll(dummy_notifications);
        notificationAdapter.notifyDataSetChanged();
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
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, NOTIFICATION_URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<Notification> dummy_notifications;
                        dummy_notifications = NotificationUtil.createObjectsArray(response);
                        updateAdapter(dummy_notifications);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(NotificationActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }
        );
        MySingleton.getInstance().addToRequestQueue(jsonObjectRequest);

    }
}

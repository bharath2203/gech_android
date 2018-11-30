package com.example.user.gech1.utils;
import android.content.Context;
import android.util.Log;

import com.example.user.gech1.Data.Notification;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NotificationUtil {

    private static Context context;


    public NotificationUtil(Context context) {
        this.context = context;
    }

    public static ArrayList<Notification> createObjectsArray(JSONArray notificationArray) {
        ArrayList<Notification> notifications = new ArrayList<>();

        try {
            for (int i = 0; i < notificationArray.length(); i++) {

                JSONObject currentNotification = notificationArray.getJSONObject(i);

                String title = currentNotification.getString("title");
                String content = currentNotification.getString("content");
                String date = currentNotification.getString("created_date");
                String time = currentNotification.getString("created_time");
                String department = currentNotification.getString("belongs_to");
                System.out.println(title);

                Notification notificationObj = new Notification(title, content, date, time, department);
                notifications.add(notificationObj);
            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the notifications JSON results", e);
        }

        return notifications;
    }

    public Context getApplicationContext() {
        return context;
    }
}

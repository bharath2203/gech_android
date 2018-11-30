package com.example.user.gech1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.gech1.R;

public class NotificationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_detail);


        Intent intent = getIntent();


        TextView title = (TextView)findViewById(R.id.notification_detail_title);
        title.setText(intent.getStringExtra("title"));

        TextView content = (TextView)findViewById(R.id.notification_detail_content);
        content.setText(intent.getStringExtra("content"));

        TextView date = (TextView)findViewById(R.id.notification_date);
        date.setText(intent.getStringExtra("date"));

        TextView time = (TextView)findViewById(R.id.notification_time);
        time.setText(intent.getStringExtra("time"));

    }
}

package com.example.user.gech1.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.gech1.Data.Notification;
import com.example.user.gech1.R;

import java.util.ArrayList;

public class NotificationAdapter extends ArrayAdapter<Notification> {

    public NotificationAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Notification> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){
             listItemView = LayoutInflater.from(getContext()).inflate(R.layout.notification_list_item, parent, false);
        }

        Notification notification = getItem(position);

        TextView notification_title = (TextView)listItemView.findViewById(R.id.notification_title);
        notification_title.setText(notification.getTitle());

        TextView notification_content = (TextView)listItemView.findViewById(R.id.notification_content);
        notification_content.setText(notification.getContent());

        return listItemView;
    }
}

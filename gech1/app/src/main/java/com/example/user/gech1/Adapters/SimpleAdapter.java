package com.example.user.gech1.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.gech1.R;

import java.util.ArrayList;

public class SimpleAdapter extends ArrayAdapter<String> {

    public SimpleAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.design, parent, false);
        }

        String department = getItem(position);

        TextView notification_title = (TextView)listItemView.findViewById(R.id.department_text);
        notification_title.setText(department);


        return listItemView;
    }
}

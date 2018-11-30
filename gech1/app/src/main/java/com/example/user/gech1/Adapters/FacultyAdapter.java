package com.example.user.gech1.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.user.gech1.Data.Faculty;
import com.example.user.gech1.MConfig;
import com.example.user.gech1.MySingleton;
import com.example.user.gech1.R;


import org.w3c.dom.Text;

import java.util.List;

public class FacultyAdapter extends ArrayAdapter<Faculty> {

    private ImageLoader mImageLoader;
    private Context context;

    public FacultyAdapter(@NonNull Context context, int resource, @NonNull List<Faculty> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        mImageLoader = MySingleton.getInstance().getImageLoader();

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_faculty_item, parent, false);
        }

        Faculty currentObj = getItem(position);

        System.out.println(currentObj.getName());

        TextView name = (TextView)listItemView.findViewById(R.id.faculty_name);
        name.setText(currentObj.getName());

        TextView pos = (TextView)listItemView.findViewById(R.id.faculty_position);
        pos.setText(currentObj.getPosition());

        NetworkImageView mNetworkImageView = (NetworkImageView)listItemView.findViewById(R.id.faculty_image);
        mImageLoader.get(MConfig.BASE_URL + currentObj.getImage(), ImageLoader.getImageListener(mNetworkImageView,
                R.mipmap.ic_launcher, R.drawable.teacher_photo));
        mNetworkImageView.setImageUrl(currentObj.getImage(), mImageLoader);

        TextView degree = (TextView)listItemView.findViewById(R.id.faculty_degree);
        degree.setText(currentObj.getDegree());

        TextView achievements = (TextView)listItemView.findViewById(R.id.faculty_acievements);
        achievements.setText(currentObj.getAchivements());

        return listItemView;
    }
}

package com.example.user.gech1.Activities;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.transition.Explode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.user.gech1.MySingleton;
import com.example.user.gech1.R;

public class UserActivity extends AppCompatActivity {

    TextView muserName, muserUsn, muserdepartment, muserSem, muserDOB, muserEmail,
    muserPhoneno, muserParentsPhoneno, muserFathername, mUserMothername, muserAdress;

    ImageLoader mImageLoader;
    NetworkImageView mNetworkImageView;


    TextView userName, userUsn, userdepartment, userSem, userDOB, userEmail,
            userPhoneno, userParentsPhoneno, userFathername, userMothername, userAdress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition(new Explode());
        getWindow().setEnterTransition(new Explode());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        SharedPreferences app_preferences = PreferenceManager
                .getDefaultSharedPreferences(getBaseContext());

        SharedPreferences.Editor editor = app_preferences.edit();

        String url = app_preferences.getString("image", "");

        mNetworkImageView = (NetworkImageView)findViewById(R.id.user_image);

        mImageLoader = MySingleton.getInstance().getImageLoader();
        mImageLoader.get(url, ImageLoader.getImageListener(mNetworkImageView,
                R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));
        mNetworkImageView.setImageUrl(url, mImageLoader);

        muserUsn = (TextView)findViewById(R.id.user_usn);
        muserName = (TextView)findViewById(R.id.user_name);
        muserdepartment = (TextView)findViewById(R.id.user_department);
        muserSem = (TextView)findViewById(R.id.user_sem);
        muserPhoneno = (TextView)findViewById(R.id.user_student_phone_no);
        muserParentsPhoneno = (TextView)findViewById(R.id.user_parent_phone_no);
        muserFathername = (TextView)findViewById(R.id.user_father_name);
        mUserMothername = (TextView)findViewById(R.id.user_mother_name);
        muserAdress = (TextView)findViewById(R.id.user_address);
        muserDOB = (TextView)findViewById(R.id.user_dob);
        muserEmail = (TextView)findViewById(R.id.user_email);


        userUsn = (TextView)findViewById(R.id.usn);
        userName = (TextView)findViewById(R.id.name);
        userdepartment = (TextView)findViewById(R.id.department);
        userSem = (TextView)findViewById(R.id.sem);
        userPhoneno = (TextView)findViewById(R.id.student_phone_no);
        userParentsPhoneno = (TextView)findViewById(R.id.parent_phone_no);
        userFathername = (TextView)findViewById(R.id.father_name);
        userMothername = (TextView)findViewById(R.id.mother_name);
        userAdress = (TextView)findViewById(R.id.address);
        userDOB = (TextView)findViewById(R.id.dob);
        userEmail = (TextView)findViewById(R.id.email);

        userUsn.setText("USN");
        userName.setText("NAME");
        userdepartment.setText("DEPARTMENT");
        userSem.setText("SEM");
        userPhoneno.setText("PHONE-NO");
        userParentsPhoneno.setText("PARENTS-PHONE-NO");
        userFathername.setText("FATHER NAME");
        userMothername.setText("MOTHER NAME");
        userAdress.setText("ADDRESS");
        userDOB.setText("DATE OF BIRTH");
        userEmail.setText("Email");




        muserUsn.setText(app_preferences.getString("usn", ""));
        muserName.setText(app_preferences.getString("name", ""));
        muserdepartment.setText(app_preferences.getString("department", ""));
        muserSem.setText(app_preferences.getString("sem", ""));
        muserPhoneno.setText(app_preferences.getString("student_phone_no", ""));
        muserParentsPhoneno.setText(app_preferences.getString("parents_phone_no", ""));
        muserFathername.setText(app_preferences.getString("father_name", ""));
        mUserMothername.setText(app_preferences.getString("mother_name", ""));
        muserAdress.setText(app_preferences.getString("address", ""));
        muserDOB.setText(app_preferences.getString("date_of_birth", ""));
        muserEmail.setText(app_preferences.getString("email_id", ""));

    }
}

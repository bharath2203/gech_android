package com.example.user.gech1.Data;

import android.graphics.Bitmap;

public class Faculty {
    private String name;
    private String degree;
    private String achivements;
    private String department;
    private String phone_no;
    private String email_id;
    private String position;
    private String image;

    public Faculty(String name, String degree, String achivements,String department,
                   String  phone_no,String email_id,String position,String image){
        this.name = name;
        this.degree = degree;
        this.achivements = achivements;
        this.department = department;
        this.phone_no = phone_no;
        this.email_id = email_id;
        this.position = position;
        this.image = image;
    }

    public String getName(){ return name;}
    public String getDegree(){ return degree;}
    public String getAchivements(){ return achivements;}
    public String getDepartment(){ return department;}
    public String getPhone_no(){ return phone_no;}
    public String getEmail_id(){ return email_id;}
    public String getPosition(){ return position;}
    public String getImage(){ return image;}

}

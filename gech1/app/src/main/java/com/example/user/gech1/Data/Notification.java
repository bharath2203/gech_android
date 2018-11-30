package com.example.user.gech1.Data;

import java.sql.Time;
import java.util.Date;

public class Notification {

    private String title;

    private String content;

    private String date;

    private String time;

    private String department;

    public Notification(String title, String content, String date, String time, String department){
        this.title = title;
        this.content = content;
        this.date = date;
        this.time = time;
        this.department = department;
    }

    public String getTitle(){
        return  title;
    }

    public String getContent(){
        return content;
    }

    public String getDate() { return date; }

    public String getTime() { return time; }

    public String getDepartment() { return department; }
}

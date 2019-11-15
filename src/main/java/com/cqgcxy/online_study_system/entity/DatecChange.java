package com.cqgcxy.online_study_system.entity;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Author:32157
 * @DATE:2019/11/15
 */
public class DatecChange {
    public Date dateChange(String date1)
    {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date cDate;
        Date dd=null;
        try {
            cDate = sdf.parse(date1);
            dd =new Date(cDate.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dd;

    }
}

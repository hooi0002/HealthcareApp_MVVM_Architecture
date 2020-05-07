package com.example.healthcareapp_mvvm_architecture;

import android.provider.SyncStateContract;

import androidx.room.TypeConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateConverter {

    static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    @TypeConverter
    public static Date fromTimestamp(String value) {
        if (value != null) {
            try {
                return df.parse(value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return null;
        }
    }

}

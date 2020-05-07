package com.example.healthcareapp_mvvm_architecture;

import androidx.room.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnumConverter {

    @TypeConverter
    public List<Gender> storedStringToEnum(String value) {
        List<String> dbValues = Arrays.asList(value.split("\\s*,\\s*"));
        List<Gender> enums = new ArrayList<>();

        for (String s: dbValues)
            enums.add(Gender.valueOf(s));

        return enums;
    }

    @TypeConverter
    public String languagesToStoredString(List<Gender> cl) {
        String value = "";

        for (Gender lang : cl)
            value += lang.name() + ",";

        return value;
    }
}

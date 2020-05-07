package com.example.healthcareapp_mvvm_architecture;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String gender;
    private String appointmentDate;
    private String birthDate;

    public Note(String name, String gender, String appointmentDate, String birthDate) {
        this.name = name;
        this.gender = gender;
        this.appointmentDate = appointmentDate;
        this.birthDate = birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

}

package com.kgisl.book.entity;

public class Soldier {
   private int soldier_id;
   private String first_name;
   private String dob;
   private String gender;
   private String join_date;
   private int general_id;
   private int event_id;
    public Soldier(int soldier_id, String first_name, String dob, String gender, String join_date, int general_id,
            int event_id) {
        this.soldier_id = soldier_id;
        this.first_name = first_name;
        this.dob = dob;
        this.gender = gender;
        this.join_date = join_date;
        this.general_id = general_id;
        this.event_id = event_id;
    }
    
    public Soldier(int soldier_id) {
        this.soldier_id = soldier_id;
    }

    public int getSoldier_id() {
        return soldier_id;
    }
    public void setSoldier_id(int soldier_id) {
        this.soldier_id = soldier_id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getJoin_date() {
        return join_date;
    }
    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }
    public int getGeneral_id() {
        return general_id;
    }
    public void setGeneral_id(int general_id) {
        this.general_id = general_id;
    }
    public int getEvent_id() {
        return event_id;
    }
    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }
    
}

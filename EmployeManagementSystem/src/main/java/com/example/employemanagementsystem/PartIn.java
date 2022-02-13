package com.example.employemanagementsystem;

public class PartIn {
    String TITLE,STDATE,ENDATE;
    public PartIn(String TITLE,String STDATE,String ENDATE){
        this.ENDATE=ENDATE;
        this.STDATE=STDATE;
        this.TITLE=TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }
    public void setENDATE(String ENDATE) {
        this.ENDATE = ENDATE;
    }
    public String getSTDATE() {
        return STDATE;
    }

    public String getENDATE() {
        return ENDATE;
    }

    public String getTITLE() {
        return TITLE;
    }

}

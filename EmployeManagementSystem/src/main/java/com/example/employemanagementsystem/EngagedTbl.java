package com.example.employemanagementsystem;

public class EngagedTbl {
    String  title,startdate,enddate;
    public EngagedTbl(String  title, String startdate, String enddate){
       this.title =title;
       this.startdate= startdate;
       this.enddate=enddate;

    }
    public String getTitle(){

        return title;
    }
    public void setTitle(String title){
         this.title=title;
    }
    public String getStartdate(){
        return startdate;
    }
    public void setStartdate(String startdate){
        this.startdate=startdate;
    }
    public String getEnddate(){
        return enddate;
    }
    public void setEnddate(String enddate){
        this.enddate=enddate;
    }
}
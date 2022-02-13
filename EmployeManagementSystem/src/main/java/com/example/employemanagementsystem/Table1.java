package com.example.employemanagementsystem;
public class Table1 {
    String  empID,Name,Sex,dept,Division,GPA;
    public Table1(String  empID,String Name,String Sex,String dept,String Division,String GPA){
       this.empID=empID;
       this.Name=Name;
       this.Sex=Sex;
       this.dept=dept;
       this.Division=Division;
this.GPA=GPA;
    }
    public String getEmpID(){
        return empID;
    }
    public void setEmpIds(String empID){
        this.empID=empID;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public String getSex(){
        return Sex;
    }
    public void setSex(String Sex){
        this.Sex=Sex;
    }
    public String getDept(){
        return dept;
    }
    public void setDept(String DEPT){
        this.dept=dept;
    }  public String getDivision(){
        return Division;
    }
    public void setDivision(String DIVISION){
        this.Division=Division;
    }
    public String getGPA(){
        return GPA;
    }
    public void setGPA(String GPA){
        this.GPA=GPA;
    }
}
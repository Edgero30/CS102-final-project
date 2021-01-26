package project1;
import java.util.*;

public class Student implements Comparable<Student>{
    private int id;
    private Name name;
    private double gpa;
    private String major;
    private int credit_hours;

    public Student(int id, Name name, double gpa, String major, int credit_hours) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.major = major;
        this.credit_hours = credit_hours;
    }

    public int getId() {
        return id;
    }
    public Name getName() {
        return name;
    }
    public double getGpa() {
        return gpa;
    }
    public String getMajor() {
        return major;
    }
    public int getCredit_hours() {
        return credit_hours;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(Name name) {
        this.name = name;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public void setCredit_hours(int credit_hours) {
        this.credit_hours = credit_hours;
    }
    
    public boolean equals(Student other){
        if(other == null)
            throw new NullPointerException("object is missing");
        
        return(this.id == other.getId());
    }
    
    @Override
    public String toString(){
        String out = String.format("Id: %6d \tName: %-30s \tMajor: %-3s \tGpa: %1.4f \tCredit Hours: %-3d", this.id, this.name, this.major, this.gpa, this.credit_hours);
        return(out);
    }
    
    @Override
    public int compareTo(Student other){
        if(other == null)
            throw new NullPointerException("object is missing");
        
        return(this.id - other.getId());
    }
}

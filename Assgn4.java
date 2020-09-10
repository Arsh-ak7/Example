package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;

class user{
    private String name;
    private Date dateOfBirth;
    private int userId;
    public user(){
    }
    public user(String name , Date dateOfBirth, int userId){
        this.name= name;
        this.dateOfBirth=dateOfBirth;
        this.userId=userId;
    }
    public void setDetails(String name , Date dateOfBirth, int userId){
        this.name= name;
        this.dateOfBirth=dateOfBirth;
        this.userId=userId;
    }
    public String showDetails(){
        return "Name: "+ this.name + " Dob: "+this.dateOfBirth + " userId "+ this.userId;
    }
    public int getUserId() {
        return userId;
    }
    public int getDateOfBirth(){
        Calendar c= new GregorianCalendar();
        c.setTime(dateOfBirth);
        return c.get(Calendar.YEAR);
    }
}

class student extends user{
    private int roll;
    private int cpi;
    private int sem;
    public student(){}
    public student(int roll, int sem,int cpi,String name, Date dateOfBirth,int userId){
        super(name,dateOfBirth,userId);
        this.roll=roll;
        this.cpi=cpi;
        this.sem=sem;
    }
    public void setDetails(int roll, int sem,int cpi,String name, Date dateOfBirth,int userId){
        super.setDetails(name,dateOfBirth,userId);
        this.roll=roll;
        this.cpi=cpi;
        this.sem=sem;
    }
    public String showDetails(){
        return super.showDetails()+ " roll: "+ this.roll+" cpi: "+ this.cpi+" sem: "+ this.sem;
    }
}

class staff extends user{
    private int employeeId;
    private String sectionName;
    private String designation;

    public staff(){}
    public staff(int employeeId,String sectionName,String designation,String name, Date dateOfBirth,int userId){
        super(name,dateOfBirth,userId);
        this.employeeId=employeeId;
        this.sectionName=sectionName;
        this.designation=designation;
    }
    public void setDetails(int employeeId,String sectionName,String designation,String name, Date dateOfBirth,int userId){
        super.setDetails(name,dateOfBirth,userId);
        this.employeeId=employeeId;
        this.sectionName=sectionName;
        this.designation=designation;
    }
    public String showDetails(){
        return super.showDetails()+ " empId: "+ this.employeeId+" SecName: "+ this.sectionName+" designation: "+ this.designation;
    }
}

class faculty extends user{
    private int employeeId;
    private String deptName;
    private int noOfPub;
    public faculty(){}
    public faculty(int employeeId, String deptName,int noOfPub,String name, Date dateOfBirth,int userId){
        super(name,dateOfBirth,userId);
        this.employeeId=employeeId;
        this.deptName=deptName;
        this.noOfPub=noOfPub;
    }

    public void setDetails(int employeeId, String deptName,int noOfPub,String name, Date dateOfBirth,int userId){
        super.setDetails(name,dateOfBirth,userId);
        this.employeeId=employeeId;
        this.deptName=deptName;
        this.noOfPub=noOfPub;
    }
    public String showDetails(){
        return super.showDetails()+ " empId: "+ this.employeeId+" DeptName: "+ this.deptName+" noOfPub: "+ this.noOfPub;
    }
}


public class Assgn4 {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int i1=0,i2=0,i3=0;
        student[] s = new student[3];
        for(int i=0;i<3;i++)
            s[i]= new student();
        staff[] st = new staff[3];
        for(int i=0;i<3;i++)
            st[i]= new staff();
        faculty[] f = new faculty[3];
        for(int i=0;i<3;i++)
            f[i]= new faculty();

        while (true){
            System.out.print("Enter option:");
            int t = sc.nextInt();
            switch (t){
                case 1:
                    System.out.println("Enter 1 for student , 2 for faculty or 3 for staff");
                    int z= sc.nextInt();
                    switch (z){
                        case 1:
                             System.out.println("Enter Details:");
                             System.out.println("Name:");
                             sc.nextLine();
                             String name = sc.nextLine();
                             System.out.println("DoB");
                             String date = sc.nextLine();
                             SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
                             Date dat = format.parse(date);
                             System.out.println("Enter userId");
                             int userId= sc.nextInt();
                             System.out.println("Enter roll");
                             int roll = sc.nextInt();
                             System.out.println("Enter Cpi");
                             int cpi= sc.nextInt();
                             System.out.println("Enter Sem");
                             int sem= sc.nextInt();
                             s[i1].setDetails(roll,sem,cpi,name,dat,userId);
                             i1++;
                             break;
                        case 2:
                            System.out.println("Enter Details:");
                            System.out.println("Name:");
                            sc.nextLine();
                            String name1 = sc.nextLine();
                            System.out.println("DoB");
                            String date1 = sc.nextLine();
                            SimpleDateFormat format1 = new SimpleDateFormat("dd-mm-yyyy");
                            Date dat1 = format1.parse(date1);
                            System.out.println("Enter userId");
                            int userId1= sc.nextInt();
                            System.out.println("Enter empID");
                            int empId = sc.nextInt();
                            System.out.println("Enter Numberofpub");
                            int nopub= sc.nextInt();
                            System.out.println("Enter Sem");
                            sc.nextLine();
                            String deptName= sc.nextLine();
                            f[i2].setDetails(empId, deptName , nopub, name1 , dat1, userId1);
                            i2++;
                            break;
                        case 3:
                            System.out.println("Enter Details:");
                            System.out.println("Name:");
                            sc.nextLine();
                            String name2 = sc.nextLine();
                            System.out.println("DoB");
                            String date2 = sc.nextLine();
                            SimpleDateFormat format2 = new SimpleDateFormat("dd-mm-yyyy");
                            Date dat2 = format2.parse(date2);
                            System.out.println("Enter userId");
                            int userId2= sc.nextInt();
                            System.out.println("Enter empID");
                            int empId2 = sc.nextInt();
                            System.out.println("Enter Section");
                            sc.nextLine();
                            String sec= sc.nextLine();
                            System.out.println("Enter Desig");
                            String des= sc.nextLine();
                            st[i3].setDetails(empId2, sec , des, name2 , dat2, userId2);
                            i3++;
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Enter UserId");
                    int us= sc.nextInt();
                    for(int i=0;i<3;i++){
                        if(s[i].getUserId()==us)
                            System.out.println(s[i].showDetails());
                        else if(st[i].getUserId()==us)
                            System.out.println(st[i].showDetails());
                        else if(f[i].getUserId()==us)
                            System.out.println(f[i].showDetails());
                    }
                    break;

                case 3:
                    System.out.println("Enter year");
                    int year = sc.nextInt();
                        for (int i = 0; i < 3; i++) {
                            try {
                                if (s[i].getDateOfBirth() == year);
                                System.out.println(s[i].showDetails());
                            }
                            catch(NullPointerException e){
                            }
                            try {
                                if (st[i].getDateOfBirth() == year)
                                    System.out.println(st[i].showDetails());
                            }
                            catch(NullPointerException e){
                            }
                            try {
                                if (f[i].getDateOfBirth() == year)
                                    System.out.println(f[i].showDetails());
                            }
                            catch (NullPointerException e){
                            }
                        }
                case 4: System.exit(0);
            }

        }

    }
}

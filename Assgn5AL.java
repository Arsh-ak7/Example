package com.company;

import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee{
    public String getName() {
        return name;
    }

    private String name;

    public int getEmpId() {
        return EmpId;
    }

    private int EmpId;
    final String compName;
    public Employee(){
        this.compName="starWorks";
    }
    public Employee(String name, int empId){
        this.name=name;
        this.EmpId=empId;
        this.compName="starWorks";
    }
    abstract void setDetails(String name, int empId, String desig);
    abstract void showDetails();
    public void setDetailsEmp(String name , int empId){
        this.EmpId= empId;
        this.name = name;
    }
    final void showEmpDetails(){
        System.out.print("Company Name: "+this.compName+" Emp name: "+ this.name+" EmpID: "+ this.EmpId);
    }
    final void showEmpDetails(int empId){
        System.out.print("Company Name: "+this.compName+" Emp name: "+ this.name+" EmpID: "+ this.EmpId);
    }

}

class faculty extends Employee{
    private String desig;
    final String Experienced;
    public faculty(){
        this.Experienced="Yes";
    }
    public faculty(String name, int empId, String desig){
        super(name, empId);
        this.desig= desig;
        this.Experienced="Yes";
    }

    @Override
    void setDetails(String name, int empId, String desig) {
        super.setDetailsEmp(name,empId);
        this.desig=desig;
    }
    public final void showDetails(){
        super.showEmpDetails();
        System.out.print(" Desig: "+ this.desig+" Experienced "+this.Experienced+"\n");
    }
    //OverLoading
    public final void showDetails(int empId){
        super.showEmpDetails(empId);
        System.out.print(" Desig: "+ this.desig+" Experienced "+this.Experienced+"\n");
    }
}

class Staff extends Employee{
    private String desig;
    final String stat;
    public Staff(){
        this.stat = "Permanent";
    }

    @Override
    void setDetails(String name, int empId, String desig) {
        super.setDetailsEmp(name,empId);
        this.desig=desig;
    }

    public Staff(String name, int empId, String desig){
        super(name, empId);
        this.desig = desig;
        this.stat = "Permanent";
    }

    public final void showDetails(){
        super.showEmpDetails();
        System.out.print(" Desig: "+ this.desig+" status: "+ this.stat+"\n");
    }
    //OverLoading
    public final void showDetails(int empId){
        super.showEmpDetails(empId);
        System.out.print(" Desig: "+ this.desig+" status: "+this.stat+"\n");
    }
}
class tempStaff extends Employee{
    private String desig;
    final String stat;
    public tempStaff(){
        this.stat = "Temporary";
        }

    @Override
    void setDetails(String name, int empId, String desig) {
            super.setDetailsEmp(name,empId);
            this.desig=desig;
    }

    public tempStaff(String name, int empId, String desig){
        super(name, empId);
        this.desig = desig;
        this.stat = "Temporary";
        }

    public final void showDetails(){
        super.showEmpDetails();
        System.out.print(" Desig: "+ this.desig+" status: "+ this.stat+"\n");
    }
    //OverLoading
    public final void showDetails(int empId){
        super.showEmpDetails(empId);
        System.out.print(" Desig: "+ this.desig+" status: "+this.stat+"\n");
    }
}
public class Assgn5AL {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> emp = new ArrayList<>();
        while(true){
            System.out.println("Enter 0 for admin, 1 otherWise or 3 to exit");
            int op= sc.nextInt();
            switch (op){
                case 0:
                    System.out.println("Enter 0 to create Emp or 1 to delete");
                    int op1 = sc.nextInt();
                    switch (op1){
                        case 0 :
                            System.out.println("Enter 1 for faculty , 2 for staff or 3 for temporary Staff");
                            int z= sc.nextInt();
                            switch (z){
                                case 1:
                                    System.out.println("Enter EmpId of faculty");
                                    int empId = sc.nextInt();
                                    System.out.println("Enter Name of faculty");
                                    sc.nextLine();
                                    String name =  sc.nextLine();
                                    System.out.println("Enter Desig of faculty");
                                    String desig = sc.nextLine();
                                    Employee e = new faculty();
                                    e.setDetails(name,empId,desig);
                                    emp.add(e);
                                    break;
                                case 2:
                                    System.out.println("Enter EmpId of staff");
                                    int empId1 = sc.nextInt();
                                    System.out.println("Enter Name of staff");
                                    sc.nextLine();
                                    String name1 =  sc.nextLine();
                                    System.out.println("Enter Desig of staff");
                                    String desig1 = sc.nextLine();
                                    Employee f = new Staff();
                                    f.setDetails(name1,empId1,desig1);
                                    emp.add(f);
                                    break;
                                case 3:
                                    System.out.println("Enter EmpId of tempstaff");
                                    int empId2 = sc.nextInt();
                                    System.out.println("Enter Name of tempstaff");
                                    sc.nextLine();
                                    String name2 =  sc.nextLine();
                                    System.out.println("Enter Desig of tempstaff");
                                    String desig2 = sc.nextLine();
                                    Employee s = new tempStaff();
                                    s.setDetails(name2,empId2,desig2);
                                    emp.add(s);
                                    break;
                                default:
                                    System.out.println("Enter Correct Option");
                                    break;
                            }
                            break;
                        case 1 :
                            System.out.println("Enter EmpiD to be deleted");
                            int emppId = sc.nextInt();
                            for (Employee i : emp) {
                                try {
                                    if (i.getEmpId() == emppId) {
                                        emp.remove(i);
                                        System.out.println("Removed Obj with id " + emppId);
                                        break;
                                    }
                                }
                                catch (NullPointerException e){}
                            }

                            break;
                        default:
                            System.out.println("Enter Correct option");
                            break;
                    }
                    break;
                case 1:
                    System.out.println("Enter 1 to show details using EmpID or 2 for using EmpName");
                    int op2 = sc.nextInt();
                    switch (op2){
                        case 1:
                            System.out.println("Enter empID");
                            int empID =  sc.nextInt();
                            for(Employee j : emp){
                                try {
                                    if (j.getEmpId() == empID) {
                                        j.showDetails();
                                        break;
                                    }
                                }
                                catch (NullPointerException e){}
                            }
                            break;
                        case 2:
                            System.out.println("Enter name");
                            sc.nextLine();
                            String name =  sc.nextLine();
                            for(Employee k : emp){
                                if(k.getName().equals(name)){
                                    k.showDetails();
                                    break;
                                }
                            }
                            break;
                        default:
                            System.out.println("Enter Correct value");
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter Correct value");
            }
        }
    }
}


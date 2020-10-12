package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

class User{
    String fName;
    String lName;

    public User(){}
    public User(String fName , String lName){
        this.fName=fName;
        this.lName=lName;
    }
    public void showUserDetails(){
        System.out.print("First Name: "+fName+" Last Name: "+lName+" ");
    }
}

class EmpDetails extends User{
    int empId;
    String email;
    String dept;

    public EmpDetails(){}
    public EmpDetails(String fName , String lName,int empId, String email,String dept){
        super(fName, lName);
        this.empId = empId;
        this.email=email;
        this.dept = dept;
    }
    public void showEmpDetails(){
        super.showUserDetails();
        System.out.print("empId: "+empId+" email: "+email+" dept: ");
    }
}

class MyIrregularPanException extends Exception{
      MyIrregularPanException(){
          System.out.println("ERROR!!-> PAN Should be alphanumeric and Should Start with a capital letter");
      }
}

class MyIrregularPinException extends Exception{
    MyIrregularPinException(){
        System.out.println("ERROR!!-> PIN Should be 6 digits long");
    }
}

class MyInvalidEmailException extends Exception{
    MyInvalidEmailException(){
        System.out.println("ERROR!!-> Enter Email in correct format");
    }
}

class socialSecurityDetails extends EmpDetails{
    int pin;
    String pan;
    public socialSecurityDetails(){}
    public socialSecurityDetails(String fName , String lName,int empId, String email,String dept,int pin , String pan){
        super(fName, lName, empId, email, dept);
        this.pin=pin;
        this.pan=pan;
    }
    public void showDetails(){
        super.showEmpDetails();
        System.out.print("PIN: "+pin+" PAN: "+pan+"\n");
    }
}


public class assgn7 {

    public static void main(String[] args) {
       ArrayList<socialSecurityDetails> usr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("0 to Exit   1 to enter details    2 to print Every User's Detail");
            int cmd = sc.nextInt();
            switch (cmd){
                case 0:System.exit(0);
                        break;
                case 1:System.out.println("Enter First Name: ");
                        sc.nextLine();
                        String fname = sc.nextLine();
                        System.out.println("Enter last name: ");
                        String lname= sc.nextLine();
                        System.out.println("Enter email: ");
                        String email = sc.nextLine();
                        System.out.println("Enter empId:  ");
                        int empId = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Dept: ");
                        String dept = sc.nextLine();
                        System.out.println("Enter the pin: ");
                        int pin = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter PAN: ");
                        String pan = sc.nextLine();
                        boolean validation=validate(pin,pan,email);
                        if(validation==false) {
                            socialSecurityDetails e = new socialSecurityDetails(fname, lname, empId, email, dept, pin, pan);
                            usr.add(e);
                            System.out.println("Added: ");
                            e.showDetails();
                        }
                        else {
                            System.out.println("Enter correct details and try again");
                        }
                        break;
                case 2 : for(socialSecurityDetails sd : usr){
                        sd.showDetails();
                        }
                        break;
                default: System.out.println("Enter Correct Option!");
                        break;
            }
        }
    }
    public static boolean validate(int pin, String pan,String email){
        boolean flag = false;
        try{
            if(!(Character.isUpperCase(pan.charAt(0))&&pan.matches("^[a-zA-Z0-9]*$"))){
                flag = true;
                throw new MyIrregularPanException();
            }

        } catch (MyIrregularPanException e){
            System.out.println(e);
        }
        try {
            int length = (int) (Math.log10(pin) + 1);
            if ((length != 6)) {
                flag = true;
                throw new MyIrregularPinException();
            }
        }
        catch (MyIrregularPinException ex){
            System.out.println(ex);
        }

        try{
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

            Pattern pat = Pattern.compile(emailRegex);
            if (!(pat.matcher(email).matches())){
                flag = true;
                throw new MyInvalidEmailException();
            }

        }
        catch(MyInvalidEmailException e){
            System.out.println(e);

        }
    return flag;
    }
}

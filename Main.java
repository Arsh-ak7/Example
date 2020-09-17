package com.company;

class Car{
    static int noOfCars=0;
    int numOfCars= 0;
    private String Color;
    private String Model;
    public int NoOfWheels;
    public int light = 2;
    String NameOfOwner;

    public Car(){  //Constructor
        this.Color = "black";
        this.Model = "x1";
        this.NoOfWheels= 4;
        this.NameOfOwner="ME";
        noOfCars++;
        numOfCars++;
    }
    public Car(String Color, String Model , int NoOfWheels, String NameOfOwner){ //Param ke saath constructor
        this.NameOfOwner=NameOfOwner;
        this.Color=Color;
        this.Model=Model;
        this.NoOfWheels= NoOfWheels;
        noOfCars++;
        numOfCars++;
    }
    //Below every thing is a class method. So its invoked by using classObj.MethodName
    public String show(){
        return this.NoOfWheels+" "+ this.Model+" "+ this.Color+" "+ this.NameOfOwner;
    }

    public String getColor() {
        return Color;
    }

    public String getModel() {
        return Model;
    }
}


public class Main {

    public static void main(String[] args) {
	    Car c1 = new Car();
	    Car c2 = new Car("red", "x2", 4, "nm");
	    System.out.println(c2.numOfCars); // Since numOfCars is not static its created everytime a obj is created an hence everytime resets to 0
	    System.out.println(Car.noOfCars); // Since noOfCars is static it is loaded only once when the class is loaded so we get 2
        System.out.println(c1.show());
        System.out.println(c2.show());
        System.out.print(c1.light);// Public var can easily be accessed directly;
        System.out.println(c2.NameOfOwner); // Default var sp can be accessed;
        //System.out.println(c2.Color); Error cause it is private you need a getter method
        System.out.println(c2.getModel());
    }
}

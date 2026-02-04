package Package1;

interface Shape {
    double area();
}
 

class Rectangle implements Shape {
 
    private double length;
    private double breadth;
 
    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }
 
    @Override
    public double area() {
        return length * breadth;
    }
}
 

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}
 

class Dog extends Animal {
 
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
 

public class OverrideAnnotationDemo {
 
    public static void main(String[] args) {
 
      
        Shape s = new Rectangle(10, 5);
        System.out.println("Area of Rectangle: " + s.area());
 
       
        Animal a = new Dog();
        a.sound();
    }
}

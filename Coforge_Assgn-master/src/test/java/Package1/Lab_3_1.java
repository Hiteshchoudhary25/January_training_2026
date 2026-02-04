package Package1;

public class Lab_3_1 {

 

    public static void main(String[] args) {

 

        try {

            Person3 p = new Person3("Dipanshu", "Chaudhary", Gender1.MALE);

 

            System.out.println("Person Details:");

            System.out.println("------------------------------");

            System.out.println("First Name : " + p.firstName);

            System.out.println("Last Name  : " + p.lastName);

            System.out.println("Gender1    : " + p.gender1);

 

        } catch (NameBlankException e) {

            System.out.println("Error: " + e.getMessage());

        }

 

        try {

            Person3 p2 = new Person3("", "Kumar", Gender1.MALE);

        } catch (NameBlankException e) {

            System.out.println("Error: " + e.getMessage());

        }

    }

}

 

class Person3 {

    String firstName;

    String lastName;

    Gender1 gender1;

 

    Person3(String firstName, String lastName, Gender1 gender1) throws NameBlankException {

 

        if (firstName == null || firstName.trim().isEmpty()) {

            throw new NameBlankException("First name cannot be blank!");

        }

 

        if (lastName == null || lastName.trim().isEmpty()) {

            throw new NameBlankException("Last name cannot be blank!");

        }

 

        this.firstName = firstName;

        this.lastName = lastName;

        this.gender1 = gender1;

    }

}

 

enum Gender1 {

    MALE,

    FEMALE,

    OTHER

}

 

class NameBlankException extends Exception {

    NameBlankException(String message) {

        super(message);

    }

}




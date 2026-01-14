
package pac3;

public class TC006_Static {
    // Make the nested class static so it can have static members
    public static class UseStatic {
        static int intNum1 = 3;
        static int intNum2;

        static {
            System.out.println("Static block Initialized...");
            intNum2 = intNum1 * 4;
        }

        static void myMethod(int intNum3) {
            System.out.println("Num3 = " + intNum3);
            System.out.println("Num1 = " + intNum1);
            System.out.println("Num2 = " + intNum2); // fixed
        }
    }

    public static void main(String[] args) {
        // Qualify the static method with the nested class name
        UseStatic.myMethod(43);
    }
}

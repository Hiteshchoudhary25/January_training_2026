
package Package1;

public class TC001 {

    // Use double so you can handle fractional dimensions if needed
    private static double Width = 20.0;
    private static double Height = 10.0;
    private static double Depth = 10.0;
    private static int boxid;

    public static double volume() {
        // No need for try/catch here
        return Width * Height * Depth;
    }

    public static void main(String[] args) {
        System.out.println("Volume: " + volume());
    }
}

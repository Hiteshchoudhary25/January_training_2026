package Package1;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Scanner;
 
public class Lab14 {
    public static void printDateTimeForZone(String zoneId) {
        try {
            ZoneId zone = ZoneId.of(zoneId);
            ZonedDateTime dateTime = ZonedDateTime.now(zone);
 
            System.out.println("Current Date & Time in " + zoneId + ": " + dateTime);
        } catch (Exception e) {
            System.out.println("Invalid Zone ID! Please try again.");
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.println("Enter Zone ID (e.g., America/New_York, Europe/London, Asia/Tokyo): ");
        String zoneId = sc.nextLine();
 
        printDateTimeForZone(zoneId);
    }
}

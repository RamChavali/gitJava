//Something weird here! Need to revisit.

public class Main {
    public static void main(String[] args) {
        GoKart kart = new GoKart("yellow");
        if (kart.isBatteryEmpty()) {
          System.out.println("The battery is empty");
        }
        try {
          kart.drive(9);
          System.out.println("This will never happen.");
        } catch (IllegalArgumentException iae) {
          System.out.println("Whoaaaaa there!");
          System.out.printf("There was an error: %s\n", iae.getMessage());
        }
    }
}
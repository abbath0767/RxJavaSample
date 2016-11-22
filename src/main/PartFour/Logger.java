package PartFour;

public class Logger {
    public static void log(String... message) {
        System.out.printf(message[0] + "\n", message[1]);
    }
}

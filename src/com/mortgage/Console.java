package com.mortgage;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt) {
        return scanner.nextDouble();
    }
    public static double readNumber(String prompt, double min, double max) {

        while (true) {
            System.out.print(prompt);
            double value = (double) scanner.nextFloat();
            if (value >= min && value <= max) {
                return value;
            }

            System.out.println("Enter a value between " + min + " and " + max);
        }
    }
}

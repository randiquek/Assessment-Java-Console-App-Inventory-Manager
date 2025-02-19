package com.assessment.inventory_management_app.ui;

import java.util.Scanner;

public class ConsoleIO {

    private Scanner console = new Scanner(System.in);

    public MenuOptions displayMainMenu() {
        printHeader("Inventory Manager");

        MenuOptions[] options = MenuOptions.values();
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%s. %s%n", i + 1, options[i].getMessage());
        }
        String msg = String.format("Select [%s-%s]:", 1, options.length);
        int value = getInteger(msg);
        return options[value - 1];
    }

    public void printHeader(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println("=".repeat(message.length()));
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        return console.nextLine();
    }

    private String getValidString(String prompt) {
        String result;
        do {
            result = getString(prompt);
            if (result.trim().length() == 0) {
                System.out.println("Value is required.");
            }
        } while (result.trim().length() == 0);
        return result;
    }

    public int getInteger(String prompt) {
        String input = null;
        int result = 0;
        boolean isValid = false;
        do {
            try {
                input = getString(prompt);
                result = Integer.parseInt(input);
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.printf("%s is not a valid number.%n", input);
            }
        } while (!isValid);

        return result;
    }

    public double getDouble(String prompt) {
        String input = null;
        double result = 0;
        boolean isValid = false;
        do {
            try {
                input = getValidString(prompt);
                result = Double.parseDouble(input);
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.printf("%s is not a valid number.%n", input);
            }
        } while (!isValid);

        return result;
    }
}

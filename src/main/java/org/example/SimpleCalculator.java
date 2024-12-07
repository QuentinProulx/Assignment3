// Quentin Proulx
// Simple Calculator
package org.example;

import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prints the title of the program
        System.out.println("----------------");
        System.out.println("SIMPLE CALCULATOR");
        System.out.println("----------------");

        // Prompts user for the first method's numbers
        System.out.print("Please enter two numbers, separated by space: ");
        double doub1 = sc.nextDouble();
        double doub2 = sc.nextDouble();
        double result1 = calcResult(doub1, doub2);

        // Prompts user for the second method's operator
        System.out.print("Please enter the operator (+, -, *, or /): ");
        char c = sc.next().charAt(0);
        double result2 = calcResult(doub1, doub2, c);

        // Prompts user for the third method's formular
        System.out.print("Please enter a formular, e.g.: \"3.15 * 2\": ");
        sc.nextLine();
        String formular = sc.nextLine();
        double result3 = calcResult(formular);

        // Prints the results
        System.out.println("\n----------------");
        System.out.println("RESULTS:");
        System.out.println("----------------");
        System.out.printf("%-10s: %s + %s = %s\n", "Calling the first method", doub1, doub2, result1);
        System.out.printf("%-10s: %s %s %s = %s\n", "Calling the second method", doub1, c, doub2, result2);
        System.out.printf("%-10s: %s = %s\n", "Calling the third method", formular, result3);

    }

    public static double calcResult(double num1, double num2) {
        // Adds numbers 1 and 2
        return num1 + num2;
    }

    public static double calcResult(double num1, double num2, char c) {
        // Checks to see what the operator being sent is and returns said operation
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }

    public static double calcResult(String str) {
        double result = 0;

        // Defines main variables
        int digits = 0; // Determines the number of digits in each number (which will be used to turn the decimal in string formal to a decimal in double format)
        double number = 0; // Stores the first number in the formular (first being the rightmost number in the string)
        double number2 = 0; // Stores the second number in the formular (second being the leftmost number in the string)
        char op = 'a'; // Checks to see which operator is being used in this formular (set to a by default because a isn't used at all in the program)
        // Loop cycling through the string from left to right with i being the index
        for (int i = str.length() - 1; i >= 0; i--) {
            // Checks to see if the character at index i is a number, and if the operator has been defined yet
            // Then it adds that digit to the double variable "number" to store it
            if (str.charAt(i) > 47 && str.charAt(i) < 58 && op == 'a') {
                number += (str.charAt(i) - 48) * Math.pow(10, digits);
                digits += 1;
            } else if (str.charAt(i) > 48 && str.charAt(i) < 58 && op != 'a') {
                number2 += (str.charAt(i) - 48) * Math.pow(10, digits);
                digits += 1;
            }
            // This checks to see when the index of the string is a period
            // Then it turns the number that's already there into a decimal so that the rest of the number can be added
            if (str.charAt(i) == '.' && op == 'a') {
                number = number / Math.pow(10, digits);
                digits = 0;
            } else if (str.charAt(i) == '.' && op != 'a') {
                number2 = number2 / Math.pow(10, digits);
                digits = 0;
            }
            // Checks to see which operator the formular is using and then defines the operator (op) as said formular
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                op = str.charAt(i);
                digits = 0;
            }
        }
        // Returns the result as a previous method to save time
        result = calcResult(number2, number, op);

        return result;
    }

}
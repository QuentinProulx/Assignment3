// Quentin Proulx
// Modulo Checker
package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Prints the title of the program
        System.out.println("---------");
        System.out.println("MODULO CHECKER");
        System.out.println("---------");

        // Prompts the user to enter a number and a base separated by a space
        System.out.print("Please enter a number and a base, separated by space: ");
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();

        // Checks to see if number1 is divisible by number2 and prints whether it is or not
        if (isDivisible(number1, number2)) {
            System.out.printf("%d %s %d", number1, "is divisible by", number2);
        } else {
            System.out.printf("%d %s %d", number1, "is not divisible by", number2);
        }

        // Prompts the user for an English letter
        System.out.print("\n\nPlease enter an English letter: ");
        char letter = sc.next().charAt(0);

        // Prompts the user to enter a number base and an english letter base separated by a space
        System.out.print("\nPlease enter a number base and an English letter base, separated by space: ");
        int number = sc.nextInt();
        char base = sc.next().charAt(0);

        // Checks to see if the converted letter is divisible by the number base and prints whether it is or not
        if (isDivisible(letter, number)) {
            System.out.printf("\n'%s' %s %d", letter, "is divisible by", number);
        } else {
            System.out.printf("\n'%s' %s %d", letter, "is not divisible by", number);
        }

        // Checks to see if the converted letter is divisible by the converted letter base and prints whether it is or not
        if (isDivisible(letter, base)) {
            System.out.printf("\n'%s' %s '%s'", letter, "is divisible by", base);
        } else {
            System.out.printf("\n'%s' %s '%s'", letter, "is not divisible by", base);
        }

    }

    // Converts a letter to the number that should be associated with it
    public static int letterToNumber(char letter) {
        int result = 0;
        if (letter > 96 && letter < 123) {
            result += letter - 97;
        } else if (letter > 64 && letter < 91) {
            result += letter - 65;
        }
        return result;
    }

    // Checks to see if a number is divisible by 3 and returns the answer as a boolean
    public static boolean isDivisible(int num){
        return num % 3 == 0;
    }

    // Checks to see if a number, num1, is divisible by another number, num2 and returns the answer as a boolean
    public static boolean isDivisible(int num1, int num2){
        return num1 % num2 == 0;
    }

    // Checks to see if a converted letter is divisible by 3 and returns the answer as a boolean
    public static boolean isDivisible(char letter){
        boolean result = false;
        int num = letterToNumber(letter);
        result = isDivisible(num);
        return result;
    }

    // Checks to see if a converted letter is divisible by a number base
    public static boolean isDivisible(char letter, int base){
        boolean result = false;
        result = isDivisible(letterToNumber(letter), base);
        return result;
    }

    // Checks to see if a converted letter is divisible by a converted letter base
    public static boolean isDivisible(char letter, char base){
        boolean result = false;
        result = isDivisible(letter, letterToNumber(base));
        return result;
    }

}
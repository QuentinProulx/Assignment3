// Quentin Proulx
// Case Converter
package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Prints title of the program
        System.out.println("-----------");
        System.out.println("CASE CONVERTER");
        System.out.println("-----------");

        // Prompts user to enter a word
        System.out.print("Please enter a word: ");
        String word = sc.nextLine();
        String result1 = convertCase(word);
        System.out.println(result1);

        // Prompts user to enter a case that they want to convert their word into
        System.out.println("Please choose the case you want to convert:");
        System.out.println("1. \"l\" or \"L\" for lowercase");
        System.out.println("2. \"u\" or \"U\" for uppercase");
        System.out.println("3. \"t\" or \"T\" for titlecase");
        char c = sc.next().charAt(0);
        String result2 = convertCase(word,c);

        // Prints the results
        System.out.println("\n-----------");
        System.out.println("RESULTS:");
        System.out.println("-----------");

        System.out.printf("\n%-40s: %s","Original word",word);
        System.out.printf("\n%-40s: %s","Calling the first convertCase method",result1);
        System.out.printf("\n%-40s: %s","Calling the second convertCase method",result2);

    }

    public static String convertCase(String word){
        String result = "";
        // Cycles through every letter in the word and sets them all to lowercase except the first which is set to uppercase
        for (int i = 0; i < word.length(); i++){
            if (i == 0) {
                result += Character.toUpperCase(word.charAt(i));
            } else {
                result += Character.toLowerCase(word.charAt(i));
            }
        }
        return result;
    }

    public static String convertCase(String word, char c){
        String result = "";
        // Cycles through every letter of the word and sets them all to lowercase
        if (c == 'l' || c == 'L'){
            for (int i = 0; i < word.length(); i++){
                result += Character.toLowerCase(word.charAt(i));
            }
        }
        // Cycles through every letter of the word and sets them all to uppercase
        if (c == 'u' || c == 'U'){
            for (int i = 0; i < word.length(); i++){
                result += Character.toUpperCase(word.charAt(i));
            }
        }
        // Calls the first convertCase method to save space
        if (c == 't' || c == 'T'){
            result = convertCase(word);
        }
        return result;
    }

}
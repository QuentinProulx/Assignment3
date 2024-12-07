// Quentin Proulx
// Coin Toss
package org.example;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Prints the title of the program
        System.out.println("-----------");
        System.out.println("COIN TOSSER");
        System.out.println("-----------");

        // Creates variables that will store how many heads and tails have been flipped
        int heads = 0;
        int tails = 0;

        // Variable to determine whether the loop is looping or not
        boolean looping = true;

        // Loops until looping isn't true
        while (looping) {
            // Prints the options that the user can choose
            System.out.println("--Choose an option--");
            System.out.printf("%s: %d, %s: %d\n","Heads",heads,"Tails",tails);
            System.out.println("1. Toss Coin");
            System.out.println("2. Exit");

            // Detects which choice the user makes
            int choice = sc.nextInt();

            switch (choice) {
                // If the user chooses option 1, it flips the coin and records it in the variables
                case 1:
                    boolean flipped = Coin.flip();
                    if (flipped) {
                        heads++;
                    } else {
                        tails++;
                    }
                    break;
                // If the second case is selected it tells the loop to stop looping
                case 2:
                    looping = false;
                    break;
            }

        }
    }
}

// Creates the Coin object
class Coin{
    // Defines the flip method
    public static boolean flip(){
        // When this method is called, it will check for an integer between 0 and 2 (excluding 0, but including 2 to make it so there are only 2 options)
        Random rand = new Random();
        int numb = rand.nextInt(0,2);
        return numb == 1;
    }
}
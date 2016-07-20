package szabados.alpar.exercises;

import java.util.Scanner;

/* Write a program which takes input as string and check if it is palindrome or not. */

public class PalindromeString {
    public static void main(String[] args) throws Exception {

        System.out.println("Enter the string:");
        Scanner input = new Scanner(System.in);
        String text = input.next();

        System.out.println("Result string is:");
        String reverseText = new StringBuilder(text).reverse().toString();

        if (text.equals(reverseText))
            System.out.print("palindrome");
        else
            System.out.print("not a palindrome");
    }
}
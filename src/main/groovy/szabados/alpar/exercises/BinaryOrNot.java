package szabados.alpar.exercises;

import java.util.Scanner;

/* Write a program which accepts a number and prints whether it is binary or not. */

public class BinaryOrNot {
    public static void main(String[] args) {
        String num;
        System.out.println("Enter a number:");
        Scanner sc = new Scanner(System.in);
        num = sc.next();

        System.out.println("The number is:");

        try {
            Integer.parseInt(num, 2);

            System.out.println("Binary");
        }
        catch (Exception e) {
            System.out.println("Not Binary");
        }
    }
}
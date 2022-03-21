package com.mycompany.palendrom;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String line;

        line = scannerText();
        Palendrom p = new Palendrom(line);
        printRezult(p.isPalindrome(line));

    }

    public static String scannerText() {

        String st;

        Scanner palindromsc = new Scanner(System.in);
        System.out.println("Введіть значення:");
        st = palindromsc.nextLine();
        return st;
    }
 
    public static void printRezult(boolean isPalendrom) {
        
        if (isPalendrom) {
            System.out.println("Введене значення є паліндромом");
        } else {
            System.out.println("Введене значення не є паліндромом");
        }
    }

}

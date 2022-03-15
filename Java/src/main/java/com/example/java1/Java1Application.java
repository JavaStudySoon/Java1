package com.example.java1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Java1Application {

    public static void main(String[] args) {
        SpringApplication.run(Java1Application.class, args);

        int x = 10;

        while (x != 0) {

            System.out.println("1 - Перевірка слова / числа на паліндром");
            System.out.println("2 - Задача FizzBuzz");
            System.out.println("3 - Декодер шифрування Цезаря");
            System.out.println("0 - Вихід");

            Scanner sc = new Scanner(System.in);
            x = sc.nextInt();

            switch (x) {
                case 1:

                    String st;
                    Scanner palindromsc = new Scanner(System.in);
                    System.out.println("Введіть значення:");
                    st = palindromsc.nextLine();
                    PalindromeCheck(st);
                    break;

                case 2:

                    FizzBuzz();
                    break;

                case 3:

                    String c; int k;
                    Scanner decoder = new Scanner(System.in);
                    Scanner koef = new Scanner(System.in);
                    System.out.println("Введіть закодоване значення:");
                    st = decoder.nextLine();
                    System.out.println("Введіть коефіцієнт:");
                    k = koef.nextInt();
                    CezarDecoder(st, -k);
                    break;
            }
        }
    }

    public static void PalindromeCheck(String str) {

        String rev = new StringBuffer(str).reverse().toString();

        str = str.replaceAll(" ","");
        rev = rev.replaceAll(" ","");

        if (str.equals(rev)) {
            System.out.println("Введене значення є паліндромом");
        }
        else {
            System.out.println("Введене значення не є паліндромом");
        }
    }

    public static void FizzBuzz() {

        for(int i = 1; i<=100; i++)
        {
            if (i%15 == 0) {
                System.out.print("FizzBuzz ");
            }
            else if (i%5 == 0) {
                System.out.print("Buzz ");
            }
            else if (i%3 == 0) {
                System.out.print("Fizz ");
            }
            else {
                System.out.print(i + " ");
            }
        }

    }

    public static void CezarDecoder(String str, int k) {

        String alfabet = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСЕУФХЦЧШЩЬЮЯ";

        String fullAlfabet = alfabet + alfabet.toLowerCase();
        int letterQty = fullAlfabet.length();
        String retVal = "";
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            int index = fullAlfabet.indexOf(c);
            if (index < 0)
            {
                retVal += c;
            }
            else
            {
                int codeIndex = (letterQty + index + k) % letterQty;
                retVal += fullAlfabet.charAt(codeIndex);
            }
        }
        System.out.println(retVal);
    }
}

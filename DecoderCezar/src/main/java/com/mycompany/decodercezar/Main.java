package com.mycompany.decodercezar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String st;
        int k;

        st = fillLine();
        k = fillKoef();
        Cezar code = new Cezar(st, k);
        System.out.println("Rezult: " + code.CezarDecoder());
    }

    public static String fillLine() {

        String s;
        Scanner decoder = new Scanner(System.in);

        System.out.println("Введіть значення:");
        s = decoder.nextLine();
        return s;
    }

    public static Integer fillKoef() {

        int k;
        Scanner koef = new Scanner(System.in);

        System.out.println("Введіть коефіцієнт:");
        k = koef.nextInt();
        return k;
    }

}

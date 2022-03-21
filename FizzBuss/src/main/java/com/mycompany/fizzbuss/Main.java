package com.mycompany.fizzbuss;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> n = new ArrayList<>();
        fillArray(n);

        FizzBuss f = new FizzBuss(n);
        f.printCheckFizzBuss();
    }

    public static void fillArray(ArrayList<Integer> number) {

        for (int i = 1; i <= 100; i++) {
            number.add(i);
        }
    }

}

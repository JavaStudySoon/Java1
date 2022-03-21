package com.mycompany.fizzbuss;

import java.util.ArrayList;

public class FizzBuss {

    private ArrayList<Integer> number;

    public FizzBuss() {
    }

    public FizzBuss(ArrayList<Integer> number) {
        this.number = number;
    }

    public ArrayList<Integer> getLine() {
        return number;
    }

    public void setLine(ArrayList<Integer> number) {
        this.number = number;
    }

    public void printCheckFizzBuss() {

        for (int i : number) {
            if (i % 15 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}

package com.example.java1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

@SpringBootApplication
public class Java1Application {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(Java1Application.class, args);

        int j = 0;

        ArrayList<String> candidate = new ArrayList<>();

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        Scanner input = new Scanner(new BufferedReader(new FileReader("src/2.txt")));

        while(input.hasNextLine())
        {
            Scanner colReader = new Scanner(input.nextLine());
            ArrayList col = new ArrayList();

            while(colReader.hasNextInt())
            {
                col.add(colReader.nextInt());
            }

            while(colReader.hasNext())
            {
                candidate.add(colReader.next());
            }

            if (!col.isEmpty()) {
                a.add(col);
            }
        }

        System.out.print("Кандидат" + "\t");

        for (String c :candidate)
        {
            System.out.print(c+"\t");
        }

        System.out.println();
        System.out.println("Дільниця");

        for (ArrayList<Integer> k:a) {
            System.out.print("\t" + (++j) + "\t\t");

            for (int x:k) {
                System.out.print(x + "\t");
            }

            System.out.println();
        }

        CalculateRezult(candidate, a);
    }

    public static void CalculateRezult(ArrayList<String> candidate, ArrayList<ArrayList<Integer>> golos)
    {
        double sumTotal = 0;
        double parcent = 0;
        boolean secondChance = true;

        HashMap<String,Integer> key = new HashMap<>();

        int sumCandidate[] = new int[candidate.size()];
        for (ArrayList<Integer> k:golos) {

            for(int i = 0; i<candidate.size(); i++) {
                sumCandidate[i] += k.get(i);
            }

        }

        sumTotal += Arrays.stream(sumCandidate).sum();

        for(int i = 0; i<candidate.size(); i++) {

            parcent = sumCandidate[i]/sumTotal*100;
            System.out.println("Кандидат: " + candidate.get(i) + " кількість голосів: " +sumCandidate[i] + " набраний відсоток: " + String.format("%.2f",parcent) + "%");
            key.put(candidate.get(i),sumCandidate[i]);

        }

        for(int i = 0; i<candidate.size(); i++) {

            parcent = sumCandidate[i]/sumTotal*100;

            if (parcent>50)
            {
                secondChance = false;
                System.out.println("Кандидат: " + candidate.get(i) + " -- переміг");
            }

        }

        if (secondChance) {
            SecontTyr(key, sumCandidate);
        }
    }

    public static int[] TwoLargest(int values[]){
        int largestA = Integer.MIN_VALUE, largestB = Integer.MIN_VALUE;

        for(int value : values) {
            if(value > largestA) {
                largestB = largestA;
                largestA = value;
            } else if (value > largestB) {
                largestB = value;
            }
        }
        return new int[] { largestB, largestA };
    }

    public static void SecontTyr(HashMap<String,Integer> key, int sumCandidate[])
    {
        System.out.println("Другий тур виборів!");

        for (int n : TwoLargest(sumCandidate)) {

            for (String getKey : key.keySet()) {

                if (key.get(getKey).equals(n)) {

                    System.out.println("Кандидат: " + getKey);
                }
            }
        }
    }
}

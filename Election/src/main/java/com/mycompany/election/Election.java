package com.mycompany.election;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Election {

    private ArrayList<String> candidate;
    private ArrayList<ArrayList<Integer>> goloses;

    public Election() {
    }

    public Election(ArrayList<String> candidate, ArrayList<ArrayList<Integer>> goloses) {
        this.candidate = candidate;
        this.goloses = goloses;
    }

    public ArrayList<String> getCandidate() {
        return candidate;
    }

    public void setCandidate(ArrayList<String> candidate) {
        this.candidate = candidate;
    }

    public ArrayList<ArrayList<Integer>> getGoloses() {
        return goloses;
    }

    public void setGoloses(ArrayList<ArrayList<Integer>> goloses) {
        this.goloses = goloses;
    }

    public void printInfo() {

        int j = 0;

        System.out.print("Кандидат" + "\t");

        for (String c : candidate) {
            System.out.print(c + "\t");
        }

        System.out.println();
        System.out.println("Дільниця");

        for (ArrayList<Integer> k : goloses) {
            System.out.print("\t" + (++j) + "\t");

            for (int x : k) {
                System.out.print(x + "\t");
            }

            System.out.println();
        }
    }

    public void calculateRezult() {

        double sumTotal = 0;
        double parcent = 0;
        boolean secondChance = true;
        HashMap<String, Integer> key = new HashMap<>();
        int sumCandidate[] = new int[candidate.size()];

        for (ArrayList<Integer> k : goloses) {
            for (int i = 0; i < candidate.size(); i++) {
                sumCandidate[i] += k.get(i);
            }

        }

        sumTotal += Arrays.stream(sumCandidate).sum();

        for (int i = 0; i < candidate.size(); i++) {

            parcent = sumCandidate[i] / sumTotal * 100;
            System.out.println("Кандидат: " + candidate.get(i) + " кількість голосів: " + sumCandidate[i] + " набраний відсоток: " + String.format("%.2f", parcent) + "%");
            key.put(candidate.get(i), sumCandidate[i]);

        }

        for (int i = 0; i < candidate.size(); i++) {

            parcent = sumCandidate[i] / sumTotal * 100;

            if (parcent > 50) {
                secondChance = false;
                System.out.println("Кандидат: " + candidate.get(i) + " -- переміг");
            }

        }

        if (secondChance) {
            secontTyr(key, sumCandidate);
        }
    }

    public static int[] twoLargest(int values[]) {
        int largestA = Integer.MIN_VALUE, largestB = Integer.MIN_VALUE;

        for (int value : values) {
            if (value > largestA) {
                largestB = largestA;
                largestA = value;
            } else if (value > largestB) {
                largestB = value;
            }
        }
        return new int[]{largestB, largestA};
    }

    public void secontTyr(HashMap<String, Integer> key, int sumCandidate[]) {
        System.out.println("Другий тур виборів!");

        for (int n : twoLargest(sumCandidate)) {

            for (String getKey : key.keySet()) {

                if (key.get(getKey).equals(n)) {

                    System.out.println("Кандидат: " + getKey);
                }
            }
        }
    }
}

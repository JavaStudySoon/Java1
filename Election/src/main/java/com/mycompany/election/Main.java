
package com.mycompany.election;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
      
        String fileName = "src/2.txt";
        
        ArrayList<String> candidate = new ArrayList<>();
        ArrayList<ArrayList<Integer>> goloses = new ArrayList<>();
        
        readInfoFromFile(candidate, goloses, fileName);
        
        Election election = new Election(candidate, goloses);
        election.printInfo();
        election.calculateRezult();
       
    }
  
    public static void readInfoFromFile(ArrayList<String> candidate, ArrayList<ArrayList<Integer>> goloses, String fileName) throws FileNotFoundException {

        Scanner input = new Scanner(new BufferedReader(new FileReader(fileName)));

        while (input.hasNextLine()) {
            Scanner colReader = new Scanner(input.nextLine());
            ArrayList col = new ArrayList();

            while (colReader.hasNextInt()) {
                col.add(colReader.nextInt());
            }

            while (colReader.hasNext()) {
                candidate.add(colReader.next());
            }

            if (!col.isEmpty()) {
                goloses.add(col);
            }
        }
    }

}

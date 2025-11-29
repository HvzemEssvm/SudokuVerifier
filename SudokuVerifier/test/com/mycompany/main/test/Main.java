/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Hazem
 */
public class Main {
     private static ArrayList<ArrayList<Integer>> propagate(String fileName) throws FileNotFoundException
    {
        ArrayList<ArrayList<Integer>> sudoku = new ArrayList<>();
        ArrayList<String> rowString;
        ArrayList<Integer> rowInteger;
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext())
        {
            rowInteger  = new ArrayList<>();
            rowString = new ArrayList<>(Arrays.asList(scanner.nextLine().trim().split(",")));
            for(String string : rowString)
            {
                rowInteger.add(Integer.valueOf(string));
            }
            sudoku.add(rowInteger);
        }
        return sudoku;
    }
    
    public static void main(String[] args) throws FileNotFoundException
    {
        ArrayList<ArrayList<Integer>> test  = propagate("valid.csv");
        for(ArrayList<Integer> row : test)
        {
            for(Integer val : row)
            {
                System.out.print(val);
            }
            System.out.println("");
        }
    }
}

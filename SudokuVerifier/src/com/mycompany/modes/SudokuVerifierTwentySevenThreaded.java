/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modes;

import com.mycompany.core.SudokuData;
import com.mycompany.core.SudokuVerifier;
import java.util.ArrayList;

public class SudokuVerifierTwentySevenThreaded extends SudokuVerifier {

    public SudokuVerifierTwentySevenThreaded(SudokuData data) {
        super(data);
        verify(); //ignore warning
    }

    @Override
    /**
     * @see https://www.geeksforgeeks.org/java/lambda-expressions-java-8/
     */
    protected void verify() {
        ArrayList<Thread> threads = new ArrayList<>();
        
        
        
        for (int i = 0; i < 9; i++) {
            final int rowIndex = i;
            Thread rowThread = new Thread(() -> verifyRow(data.getRows().get(rowIndex), rowIndex));
            threads.add(rowThread);
//            rowThread.start(); //commented for debugging
        }

        for (int i = 0; i < 9; i++) {
            final int colIndex = i;
            Thread colThread = new Thread(() -> verifyColumn(data.getColumns().get(colIndex), colIndex));
            threads.add(colThread);
//            colThread.start(); //commented for debugging
        }

        for (int i = 0; i < 9; i++) {
            final int boxIndex = i;
            Thread boxThread = new Thread(() -> verifyBox(data.getBoxes().get(boxIndex), boxIndex));
            threads.add(boxThread);
//            boxThread.start(); //commented for debugging
        }

        //@For Debugging ~Start 
        long processingStartTime = System.nanoTime();
        threads.get(0).start();
        threads.get(1).start();
        threads.get(2).start();
        threads.get(3).start();
        threads.get(4).start();
        threads.get(5).start();
        threads.get(6).start();
        threads.get(7).start();
        threads.get(8).start();
        threads.get(9).start();
        threads.get(10).start();
        threads.get(11).start();
        threads.get(12).start();
        threads.get(13).start();
        threads.get(14).start();
        threads.get(15).start();
        threads.get(16).start();
        threads.get(17).start();
        threads.get(19).start();
        threads.get(20).start();
        threads.get(21).start();
        threads.get(22).start();
        threads.get(23).start();
        threads.get(24).start();
        threads.get(25).start();
        threads.get(26).start();
        //@For Debugging ~End
        
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrupted during verification", e);
            }
        }
        //@For Debugging ~Start
        long processingEndTime = System.nanoTime();
        System.out.println("\nProcessing Time : " +((processingEndTime-processingStartTime)/1000)+" us\n");
        //@For Debugging ~End
    }
}
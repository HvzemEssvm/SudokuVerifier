/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modes;

import com.mycompany.core.SudokuVerifier;
import java.util.ArrayList;
import java.util.HashMap;

public class SudokuVerifierThreeThreaded extends SudokuVerifier {

    public SudokuVerifierThreeThreaded(ArrayList<ArrayList<Integer>> rows,
            ArrayList<ArrayList<Integer>> columns,
            ArrayList<ArrayList<Integer>> boxes) {
        super(rows, columns, boxes);
        this.rowDuplicates = new ArrayList<>();
        this.columnDuplicates = new ArrayList<>();
        this.boxDuplicates = new ArrayList<>();

        propagate();
    }

    @Override
    protected void propagate() {
        // Create three threads: one for rows, one for columns, one for boxes
        Thread rowThread = new Thread(() -> verifyRows());
        Thread columnThread = new Thread(() -> verifyColumns());
        Thread boxThread = new Thread(() -> verifyBoxes());

        // Start all threads

        rowThread.start();
        columnThread.start();
        boxThread.start();

        // Wait for all threads to complete
        try {
            rowThread.join();
            columnThread.join();
            boxThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted during verification", e);
        }
    }

    @Override
    protected void verify() {
    }

    @Override
    protected synchronized void verifyRows() {
        for (int i = 0; i < rows.size(); i++) {
            verifyRow(rows.get(i), i);
        }
    }

    @Override
    protected synchronized void verifyColumns() {
        for (int i = 0; i < columns.size(); i++) {
            verifyColumn(columns.get(i), i);
        }
    }

    @Override
    protected synchronized void verifyBoxes() {
        for (int i = 0; i < boxes.size(); i++) {
            verifyBox(boxes.get(i), i);
        }
    }

    @Override
    protected void verifyRow(ArrayList<Integer> row, int rowIndex) {
        HashMap<Integer, ArrayList<Integer>> valuePositions = new HashMap<>();

        for (int i = 0; i < row.size(); i++) {
            int value = row.get(i);
            valuePositions.putIfAbsent(value, new ArrayList<>());
            valuePositions.get(value).add(i + 1);
        }

        synchronized (rowDuplicates) {
            for (int value : valuePositions.keySet()) {
                ArrayList<Integer> positions = valuePositions.get(value);
                if (positions.size() > 1) {
                    Duplicate dup = new Duplicate(
                            Duplicate.Type.ROW,
                            rowIndex + 1,
                            value,
                            positions);
                    rowDuplicates.add(dup);
                }
            }
        }
    }

    @Override
    protected void verifyColumn(ArrayList<Integer> column, int colIndex) {
        HashMap<Integer, ArrayList<Integer>> valuePositions = new HashMap<>();

        for (int i = 0; i < column.size(); i++) {
            int value = column.get(i);
            valuePositions.putIfAbsent(value, new ArrayList<>());
            valuePositions.get(value).add(i + 1);
        }

        synchronized (columnDuplicates) {
            for (int value : valuePositions.keySet()) {
                ArrayList<Integer> positions = valuePositions.get(value);
                if (positions.size() > 1) {
                    Duplicate dup = new Duplicate(
                            Duplicate.Type.COL,
                            colIndex + 1,
                            value,
                            positions);
                    columnDuplicates.add(dup);
                }
            }
        }
    }

    @Override
    protected void verifyBox(ArrayList<Integer> box, int boxIndex) {
        HashMap<Integer, ArrayList<Integer>> valuePositions = new HashMap<>();

        for (int i = 0; i < box.size(); i++) {
            int value = box.get(i);
            valuePositions.putIfAbsent(value, new ArrayList<>());
            valuePositions.get(value).add(i + 1);
        }

        synchronized (boxDuplicates) {
            for (int value : valuePositions.keySet()) {
                ArrayList<Integer> positions = valuePositions.get(value);
                if (positions.size() > 1) {
                    Duplicate dup = new Duplicate(
                            Duplicate.Type.BOX,
                            boxIndex + 1,
                            value,
                            positions);
                    boxDuplicates.add(dup);
                }
            }
        }
    }
}
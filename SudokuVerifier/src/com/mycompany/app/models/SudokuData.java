/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app.models;

/**
 *
 * @author Hazem
 */
public class SudokuData {
        private int[][] rows;      // 9x9 array
        private int[][] columns;   // 9x9 array
        private int[][] boxes;     // 9x9 array

        public SudokuData() {
            rows = new int[9][9];
            columns = new int[9][9];
            boxes = new int[9][9];
        }

    /**
     * @return the rows
     */
    public int[][] getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int[][] rows) {
        this.rows = rows;
    }

    /**
     * @return the columns
     */
    public int[][] getColumns() {
        return columns;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(int[][] columns) {
        this.columns = columns;
    }

    /**
     * @return the boxes
     */
    public int[][] getBoxes() {
        return boxes;
    }

    /**
     * @param boxes the boxes to set
     */
    public void setBoxes(int[][] boxes) {
        this.boxes = boxes;
    }
}

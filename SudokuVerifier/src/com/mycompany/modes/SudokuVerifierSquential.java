/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modes;

import java.util.ArrayList;

import com.mycompany.core.SudokuVerifier;

/**
 *
 * @author Hazem
 */
public class SudokuVerifierSquential extends SudokuVerifier {

    public SudokuVerifierSquential(ArrayList<ArrayList<Integer>> rows, ArrayList<ArrayList<Integer>> columns,
            ArrayList<ArrayList<Integer>> boxes) {
        super(rows, columns, boxes);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected void propagate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'propagate'");
    }

    @Override
    protected void verify() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verify'");
    }

    @Override
    protected void verifyRows() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyRows'");
    }

    @Override
    protected void verifyColumns() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyColumns'");
    }

    @Override
    protected void verifyBoxes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyBoxes'");
    }

    @Override
    protected void verifyRow(ArrayList<Integer> row, int rowIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyRow'");
    }

    @Override
    protected void verifyColumn(ArrayList<Integer> column, int columnIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyColumn'");
    }

    @Override
    protected void verifyBox(ArrayList<Integer> box, int boxIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyBox'");
    }
    
}

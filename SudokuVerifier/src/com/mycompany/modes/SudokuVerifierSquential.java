/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modes;

import com.mycompany.core.SudokuData;

import com.mycompany.core.SudokuVerifier;

/**
 *
 * @author Hazem
 */
public class SudokuVerifierSquential extends SudokuVerifier {

    public SudokuVerifierSquential(SudokuData data) {
        super(data);
        verify(); //ignore warning
    }

    @Override
    protected void verify() {
        //@For Debugging ~Start
        long processingStartTime = System.nanoTime();
        //@For Debugging ~End

        verifyRows();
        verifyColumns();
        verifyBoxes();
        
        //@For Debugging ~Start
        long processingEndTime = System.nanoTime();
        System.out.println("\nProcessing Time : " +((processingEndTime-processingStartTime)/1000)+" us\n");
        //@For Debugging ~End
    }
}

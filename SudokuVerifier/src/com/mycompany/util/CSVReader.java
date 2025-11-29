package com.mycompany.util;

import com.mycompany.core.SudokuData;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    private static boolean isValidValue(int value,int rowIdx, int colIdx)
    {
        return (value<=9)&&(value>=1);
    }
    
    public static SudokuData readCSV(String filePath) throws IOException,NumberFormatException {
        SudokuData data = new SudokuData();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rowIndex = 0;

            while ((line = br.readLine()) != null && rowIndex < 9) {
                String[] values = line.split(",");

                for (int colIndex = 0; colIndex < 9 && colIndex < values.length; colIndex++) {
                    int value = Integer.parseInt(values[colIndex].trim());
                    
                    //validate value here
                    if(!isValidValue(value,rowIndex,colIndex))
                    {
                        throw new IOException("Invalid value at ["+String.valueOf(rowIndex+1)
                                             +"]["+String.valueOf(colIndex+1)
                                             +"] = {"
                                             +String.valueOf(value)
                                             +"}\n");
                    }
                    
                    // Add to rows
                    data.getRows().get(rowIndex).add(value);

                    // Add to columns
                    data.getColumns().get(colIndex).add(value);

                    // Add to boxes
                    int boxIndex = (rowIndex / 3) * 3 + (colIndex / 3);
                    data.getBoxes().get(boxIndex).add(value);
                }

                rowIndex++;
            }
        }

        return data;
    }
}
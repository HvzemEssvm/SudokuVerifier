package com.mycompany.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public static class SudokuData {
        public ArrayList<ArrayList<Integer>> rows;
        public ArrayList<ArrayList<Integer>> columns;
        public ArrayList<ArrayList<Integer>> boxes;

        public SudokuData() {
            rows = new ArrayList<>();
            columns = new ArrayList<>();
            boxes = new ArrayList<>();

            // Initialize 9 rows, 9 columns, 9 boxes
            for (int i = 0; i < 9; i++) {
                rows.add(new ArrayList<>());
                columns.add(new ArrayList<>());
                boxes.add(new ArrayList<>());
            }
        }
    }

    public static SudokuData readCSV(String filePath) throws IOException {
        SudokuData data = new SudokuData();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rowIndex = 0;

            while ((line = br.readLine()) != null && rowIndex < 9) {
                String[] values = line.split(",");

                for (int colIndex = 0; colIndex < 9 && colIndex < values.length; colIndex++) {
                    int value = Integer.parseInt(values[colIndex].trim());

                    // Add to rows
                    data.rows.get(rowIndex).add(value);

                    // Add to columns
                    data.columns.get(colIndex).add(value);

                    // Add to boxes
                    int boxIndex = (rowIndex / 3) * 3 + (colIndex / 3);
                    data.boxes.get(boxIndex).add(value);
                }

                rowIndex++;
            }
        }

        return data;
    }
}
package com.glovindan;

import java.util.Arrays;

public class JordanTable {
    private double[][] tValues;
    private String[] tRow;
    private String[] tColumn;

    JordanTable(double[][] inputValues) {
        this.tValues = new double[inputValues.length][];
        for (int row = 0; row < inputValues.length; row++) {
            tValues[row] = inputValues[row].clone();
        }

        this.tRow = new String[inputValues[0].length];
        this.tRow[0] = "1";
        for (int column = 1; column < this.tRow.length; column++) {
            this.tRow[column] = "x" + (column);
        }

        this.tColumn = new String[inputValues.length];
        Arrays.fill(this.tColumn, "0");
    }

    public double[][] getValues() {
        return tValues;
    }

    public String[][] getTableAsStringMatrix() {
        String[][] tableToString = new String[this.tColumn.length + 1][this.tRow.length + 1];

        //0 0
        tableToString[0][0] = " ";

        //Значения нулевой строки
        for (int column = 1; column <= this.tRow.length; column++) {
            tableToString[0][column] = "-" + this.tRow[column - 1];
        }
        //Значения нулевого столбца
        for (int row = 1; row <= this.tColumn.length; row++) {
            tableToString[row][0] = this.tColumn[row - 1];
        }
        //Значения таблицы
        for (int row = 1; row <= this.tColumn.length ; row++) {
            for (int column = 1; column <= this.tRow.length; column++) {
                tableToString[row][column] = Double.toString(this.tValues[row - 1][column - 1]);
            }
        }

        return tableToString;
    }

    public static void printDoubleMatrix(double[][] matrix) {
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                System.out.printf("%10.1f", aDouble);
            }
            System.out.println();
        }
    }

    public boolean jordanExclude(int x, int y) {
        double permittedElement = tValues[x][y];
        double[][] newTable = new double[this.tColumn.length][this.tRow.length];

        if(permittedElement == 0) return false;

        tValues[x][y] = 1 / permittedElement;

        String buffer = tColumn[x];
        tColumn[x] = tRow[y];
        tRow[y] = buffer;

        for (int row = 0; row < tColumn.length; row++) {
            for (int column = 0; column < tRow.length; column++) {
                if(row != x && column != y) {
                    newTable[row][column] = (tValues[row][column] * permittedElement - tValues[row][y] * tValues[x][column])/permittedElement;
                }
            }
        }

        for (int column = 0; column < tRow.length; column++) {
            if(column != y) {
                newTable[x][column] =  tValues[x][column]/permittedElement;
            }
        }

        for (int row = 0; row < tColumn.length; row++) {
            if(row != x) {
                newTable[row][y] = - tValues[row][y]/permittedElement;
            }
        }

        this.tValues = newTable;
        return true;
    }
}

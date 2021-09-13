package com.glovindan;

public class JordanTable {
    private double[][] tValues;
    private String[] tRow;
    private String[] tColumn;

    JordanTable(double[][] inputValues) {
        this.tValues = new double[inputValues.length][];
        for (int row = 0; row < inputValues.length; row++) {
            tValues[row] = inputValues[row].clone();
        }

        this.tRow = new String[inputValues.length];
        for (int column = 0; column < this.tRow.length; column++) {
            this.tRow[column] = "x" + (column + 1);
        }

        this.tColumn = new String[inputValues[0].length];
        for (int row = 0; row < this.tColumn.length; row++) {
            this.tColumn[row] = "y" + (row + 1);
        }
    }

    public double[][] getValues() {
        return tValues;
    }

    public boolean jordanExclude(int x, int y) {
        double permittedElement = tValues[x][y];

        if(permittedElement == 0) return false;

        tValues[x][y] = 1 / permittedElement;

        String buffer = tColumn[x];
        tColumn[x] = tRow[y];
        tRow[y] = buffer;

        for (int row = 0; row < tRow.length; row++) {
            for (int column = 0; column < tColumn.length; column++) {
                if(row != x && column != y) {
                    tValues[row][column] = tValues[row][column] - (tValues[row][y] * tValues[x][column])/(permittedElement);
                }
            }
        }

        for (int column = 0; column < tRow.length; column++) {
            if(column != x) {
                tValues[0][column] = - tValues[0][column]/permittedElement;
            }
        }

        for (int row = 0; row < tRow.length; row++) {
            if(row != x) {
                tValues[row][0] = tValues[row][0]/permittedElement;
            }
        }

        return true;
    }
}

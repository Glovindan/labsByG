package com.glovindan;

import java.util.Arrays;

public class ArtificialBasis extends JordanTable{
//    public int gIndex;
//    public int fIndex;

    ArtificialBasis(double[][] inputValues) {
        super(inputValues);

//        this.fIndex = this.tColumn.length - 2;
//        this.gIndex = this.tColumn.length - 1;
    }

    public void fillStrokes(double[][] inputValues) {
        this.tRow = new String[inputValues[0].length];
        this.tRow[0] = "1";
        for (int column = 1; column < this.tRow.length; column++) {
            this.tRow[column] = "x" + (column);
        }

        this.tColumn = new String[inputValues.length];
        for (int row = 0; row < this.tColumn.length - 2; row++) {
            this.tColumn[row] = "R" + (row + 1);
        }
        this.tColumn[this.tColumn.length - 2] = "F";
        this.tColumn[this.tColumn.length - 1] = "G";
        zeroColumnIndex = tRow.length;
    }

    public static void printStringMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String aStrings : strings) {
                System.out.printf("%10.8s", aStrings);
            }
            System.out.println();
        }
    }

    public void artificialBasisMethod() {
        //repeat while G has negatives
        while (hasNegativeInt(tValues[this.tColumn.length - 1])) {
            //Find minimal in F (column)
            int column = findMinimalIndex(tValues[this.tColumn.length - 1]);

            //Find minimal simplex relation (row)
            int row = findMinimalSimplexRelationIndex(column);

            //jordan Exclude this shit (column,row)
            this.jordanExclude(row, column);

            printPermittedElement(row, column);
            printStringMatrix(this.getTableAsStringMatrix());
        }

        System.out.println("\nOptimization: ");
        //Check negatives above zeros in G
        int column = findNegativeIntAboveZero(tValues[this.tColumn.length - 1],tValues[this.tColumn.length - 2]);
        while(column != -1){
            int row = findMinimalSimplexRelationIndex(column);

            this.jordanExclude(row, column);

            printPermittedElement(row, column);
            printStringMatrix(this.getTableAsStringMatrix());

            column = findNegativeIntAboveZero(tValues[this.tColumn.length - 1],tValues[this.tColumn.length - 2]);
        };
    }
    public void printPermittedElement(int row, int column) {
        System.out.println("Permitted element [" + row + "," + column + "] = " + tValues[row][column]);
    }

    public int findNegativeIntAboveZero(double[] arr,double[] arrAbove) {
        for (int index = 1; index < arr.length; index++) {
            if (arr[index] == 0 && arrAbove[index] < 0) {
                return index;
            };
        }
        return -1;
    }

    public boolean hasNegativeInt(double[] array) {
        for (int column = 1; column < array.length; column++) {
            if(array[column] < 0) return true;
        }
        return false;
    }

    public int findMinimalIndex(double[] array) {
        int minIndex = 1;
        for (int index = 1; index < array.length; index++) {

            if(array[index] < array[minIndex]) {
                minIndex = index;
            }
        }
        return minIndex;
    }

    public int findMinimalSimplexRelationIndex(int minColumn) {
        double minSimplexRelation = Double.MAX_VALUE;
        int minRow = 0;
        for (int row = 0; row < this.tColumn.length - 2; row++) {
            if(tValues[row][0] <= 0 || tValues[row][minColumn] <= 0) {
                continue;
            }

            double simplexRelation = tValues[row][0]/tValues[row][minColumn];
            if(simplexRelation < minSimplexRelation) {
                minSimplexRelation = simplexRelation;
                minRow = row;
            }
        }

        return minRow;
    }
}

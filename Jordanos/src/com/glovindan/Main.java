package com.glovindan;

import java.util.Arrays;

public class Main {

    public static void printMatrix(double[][] matrix) {
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                System.out.printf("%10.1f", aDouble);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        //Ввод матрицы
        double[][] initMatrix = {
            {0.0, -3.0, 1.0},
            {3.0, 2.0, 2.0},
            {5.0, -1.0, 3.0}
        };

        JordanTable A = new JordanTable(initMatrix);
        boolean status = A.jordanExclude(0,0);
        double[][] newMatrix = A.getValues();

        System.out.println("Old Matrix");
        printMatrix(initMatrix);
        if (status) {
            System.out.println("New Matrix");
            printMatrix(newMatrix);
        } else {
            System.out.println("ты проебался");
        }
    }
}

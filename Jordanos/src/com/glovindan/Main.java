package com.glovindan;

import java.util.Arrays;

public class Main {
    final static int N = 3;

    public static class PermElId {
        int i;
        int j;

        PermElId(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void printMatrix(double[][] matrix) {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.printf("%5.1f",matrix[i][j]);
//            }
//            System.out.println();
//        }
        Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);
    }

    public static void main(String[] args) {
//	    double[][] initMatrix = new double[N][N];

        //Ввод матрицы
        double[][] initMatrix = {
            {2.0, -3.0, 1.0},
            {3.0, 2.0, 2.0},
            {5.0, -1.0, 3.0}
        };

        //Разрешающий элемент
        PermElId permElId = new PermElId(0,0);

        if (initMatrix[permElId.i][permElId.j] == 0) {
            System.out.println("Это не разрешающий элемент");
            //Выйти
        } else {
            double[][] newMatrix = new double[N][N];
            double permittedElement = initMatrix[permElId.i][permElId.j];
            newMatrix[permElId.i][permElId.j] = 1/permittedElement;

            for (int j = 0; j < N; j++) {
                if(j != permElId.j) {
                    newMatrix[0][j] = - initMatrix[0][j]/permittedElement;
                }
            }

            for (int i = 0; i < N; i++) {
                if(i != permElId.i) {
                    newMatrix[i][0] = initMatrix[i][0]/permittedElement;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i != permElId.i && j != permElId.j) {
                        newMatrix[i][j] = initMatrix[i][j] - (initMatrix[i][permElId.j] * initMatrix[permElId.i][j])/(initMatrix[permElId.i][permElId.j]);
                    }
                }
            }

            System.out.println("Old Matrix");
            printMatrix(initMatrix);

            System.out.println("New Matrix");
            printMatrix(newMatrix);
        }
    }
}

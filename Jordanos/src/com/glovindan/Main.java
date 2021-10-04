package com.glovindan;

public class Main {

    public static void printDoubleMatrix(double[][] matrix) {
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                System.out.printf("%10.1f", aDouble);
            }
            System.out.println();
        }
    }

    public static void printStringMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String aStrings : strings) {
                System.out.printf("%10.8s", aStrings);
            }
            System.out.println();
        }
    }

    public static void makeJordanosShit(JordanTable A, int x, int y) {
        System.out.println("Old Matrix");
        printStringMatrix(A.getTableAsStringMatrix());

        boolean status = A.jordanExclude(x,y);
        if (status) {
            System.out.println("New Matrix");
            printStringMatrix(A.getTableAsStringMatrix());
        } else {
            System.out.println("Ошибка");
        }
    }

    public static void main(String[] args) {

        //Ввод матрицы
//        double[][] initMatrix = {
//            {3.0, 1.0, 2.0, 1.0, 0.0},
//            {6.0, 1.0, 1.0, 0.0, 1.0},
//            {10.0, 1.0, -1.0, -2.0, -3.0}
//        };
//        double[][] initMatrix = {
//                {2, -3, 1},
//                {3, 2, 2},
//                {5, -1, 3}
//        };
        double[][] initMatrix = {
                {4.0, 1.0, 2.0, 1.0, 0.0},
                {6.0, 1.0, 1.0, 0.0, 1.0},
                {10.0, 1.0, -1.0, -2.0, 3.0}
        };
        JordanTable A = new JordanTable(initMatrix);
        makeJordanosShit(A, 1, 4);

        double[][] secondMatrix = {
                {1.0, 1.0, 2.0, 3.0},
                {1.0, 1.0, 1.0, 1.0},
                {2.0, 1.0, 0.0, -1.0}
        };
        JordanTable B = new JordanTable(secondMatrix);
        makeJordanosShit(B, 2, 1);
        makeJordanosShit(B, 1, 2);
    }
}

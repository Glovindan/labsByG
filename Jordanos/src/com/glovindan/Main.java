package com.glovindan;

import java.util.Objects;
import java.util.Scanner;

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

    public static void makeJordanosShit(String message, JordanTable A, int x, int y) {
        boolean status = A.jordanExclude(x,y);
        if (status) {
            System.out.println(message);
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
//        double[][] initMatrix = {
//                {2.0, -2.0, 1.0, 1.0, 0.0, 0.0},
//                {8.0, -1.0, 2.0, 0.0, -1.0, 0.0},
//                {5.0, 1.0, 1.0, 0.0, 0.0, 1.0}
//        };
//        double[][] initMatrix = {
//                {3, 1, -4, 2, -5, 9},
//                {6, 0, 1, -3, 4, -5},
//                {1, 0, 1, -1, 1, -1},
//                {-6, 0, 14, -9, 11, -14},
//                {-7, 0, -2, 4, -5, 6},
//        };
//        double[][] initMatrix = {
//                {3, 1, -4, 2, -5, 9},
//                {6, 0, 1, -3, 4, -5},
//                {1, 0, 1, -1, 1, -1},
//                {0, 2, 6, -5, 1, -4},
//                {-10, -1, 2, 2, 0, -3},
//        };
//        JordanTable A = new JordanTable(initMatrix);
//
//        printStringMatrix(A.getTableAsStringMatrix());
//
//        Scanner in = new Scanner(System.in);
//        int stepCounter = 1;
//        int x, y;
//        String endCheck = "";
//        System.out.println(endCheck);
//
//        boolean proceed = true;
//        while(proceed) {
//            System.out.println("Enter Row number: ");
//            x = in.nextInt();
//            System.out.println("Enter Column number: ");
//            y = in.nextInt();
//
//            makeJordanosShit("Step "+stepCounter+":", A, x, y);
//            stepCounter++;
//
//            System.out.println("Continue? Y/N: ");
//            in.nextLine();
//            endCheck = in.nextLine();
//
//             if(Objects.equals(endCheck, "N")) {
//                proceed = false;
//             }
//        }

        double[][] initMatrix = {
                {3, 1, -4, 2, -5, 9},
                {6, 0, 1, -3, 4, -5},
                {1, 0, 1, -1, 1, -1},
                {-6, 0, 14, -9, 11, -14},
                {-7, 0, -2, 4, -5, 6},
        };

//        double[][] initMatrix = {
//                {3, 2, 3, 1},
//                {2, 1, 0, 3},
//                {0, 1, -2, 1},
//                {-5, -3, -3, -4},
//        };
        ArtificialBasis B = new ArtificialBasis(initMatrix);
        System.out.println("Old Matrix");
        printStringMatrix(B.getTableAsStringMatrix());
        B.artificialBasisMethod();
    }
}

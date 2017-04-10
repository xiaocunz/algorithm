package com.company;

import java.util.Scanner;

/**
 * Created by zxiaocun on 2017/4/5.
 */
public class Gasket {
    private static char[][] square;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        square = new char[n + 2][n + 2];
        init(n + 2);
        gasket(1, 1, n);

        display(n + 2);
    }

    private static void gasket(int row, int column, int len) {
        if (len == 2) {
            square[row][column] = 'x';
            square[row][column + 1] = 'x';
            square[row + 1][column] = 'x';
            square[row + 1][column + 1] = ' ';
            return;
        } else {
            len = len / 2;
            gasket(row , column, len);
            gasket(row + len, column, len);
            gasket(row, column + len, len );
        }
    }

    private static void display(int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (square[i][j] != 'x' && square[i][j] != '.') {
                    square[i][j] = ' ';
                }
                System.out.print(square[i][j]);
            }
            System.out.print("\n");
        }
    }

    private static void init(int len) {
        for (int i = 0; i < len; i++) {
            square[0][i] = '.';
            square[len - 1][i] = '.';
            square[i][0] = '.';
            square[i][len - 1] = '.';
        }
    }
}

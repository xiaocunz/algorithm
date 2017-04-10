package com.company;

import java.util.Scanner;

/**
 * Created by zxiaocun on 2017/4/2.
 */
public class Hi1094 {
    private static char[][] map;
    private static char[][] blocks;
    private static char[][] blocks1;
    private static char[][] blocks2;
    private static char[][] blocks3;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        map = new char[n][m];
        blocks = new char[3][3];

        // 初始化地图
        for (int i = 0; i < n; i++) {
            String line = in.next();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j);
            }
        }
        // 初始化包围快
        for (int i = 0; i < 3; i++) {
            String line = in.next();
            for (int j = 0; j < line.length(); j++) {
                blocks[i][j] = line.charAt(j);
            }
        }
        blocks1 = xuanzhuan(blocks);
        blocks2 = xuanzhuan(blocks1);
        blocks3 = xuanzhuan(blocks2);


        // 自南至北，自西至东循环判断
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (isMatch(i, j, blocks)) {
                    // 符合则输出，行 列
                    String result = (i + 1) + " " + (j + 1);
                    System.out.println(result);
                } else if (isMatch(i, j, blocks1)) {
                    // 符合则输出，行 列
                    String result = (i + 1) + " " + (j + 1);
                    System.out.println(result);
                } else if (isMatch(i, j, blocks2)) {
                    // 符合则输出，行 列
                    String result = (i + 1) + " " + (j + 1);
                    System.out.println(result);
                } else if (isMatch(i, j, blocks3)) {
                    // 符合则输出，行 列
                    String result = (i + 1) + " " + (j + 1);
                    System.out.println(result);
                }
            }
        }

    }

    private static boolean isMatch(int row, int column, char[][] blocks) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[row-1+i][column-1+j] != blocks[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static char[][] xuanzhuan(char[][] blocks) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[2-j][i] = blocks[i][j];
            }
        }
        return temp;
    }
}

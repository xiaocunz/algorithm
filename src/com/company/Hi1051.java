package com.company;

import java.util.Scanner;

/**
 * Created by zxiaocun on 2017/4/1.
 */
public class Hi1051 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nums = in.nextInt();
        for (int i = 0; i < nums; i++) {
            int days = in.nextInt();
            int cards = in.nextInt();
            int[] missingDays = new int[days + 2];
            missingDays[0] = 0;
            for (int j = 1; j <= days; j++) {
                missingDays[j] = in.nextInt();
            }
            missingDays[days + 1] = 101;
            if (days <= cards) {
                System.out.println(100);
                continue;
            }

            int max = 0;
            for (int j = 0; j < missingDays.length - cards - 1; j++) {
                if (missingDays[j + cards + 1] - missingDays[j] > max) {
                    max = missingDays[j + cards + 1] - missingDays[j] - 1;
                }
            }
            System.out.println(max);
        }
    }
}

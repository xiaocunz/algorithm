package com.company;

import java.util.Scanner;

/**
 * Created by zxiaocun on 2017/4/5.
 */
public class HanoiTower {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        hanoiTower(2, 'a','b','c');
    }

    private static void hanoiTower(int n, char source, char destination, char spare) {
        if (n == 1) {
            System.out.println(n + ":" + source + "-" + destination);
            return;
        }
        hanoiTower(n-1, source, spare, destination);

        System.out.println(n + ":" + source + "-" + destination);

        hanoiTower(n-1, spare, destination, source);
    }
}

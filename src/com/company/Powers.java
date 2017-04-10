package com.company;

import java.util.Scanner;

/**
 * Created by zxiaocun on 2017/4/5.
 */
public class Powers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int x = in.nextInt();
            int e = in.nextInt();

            System.out.print(power(x, e));
        }
    }

    private static int power(int x, int e) {
        if (e == 0) {
            return 1;
        }
        if (e < 0) {
            int y = power(x, -e);
            System.out.println("1 / " + y);
            return 1 / y;
        }
        if (isEven(e)) {
            int y = power(x, e / 2);
            return y * y;
        } else {
            return x * power(x, e - 1);
        }
    }

    private static boolean isOdd(int x) {
        return !isEven(x);
    }

    private static boolean isEven(int x) {
        return x % 2 == 0;
    }
}

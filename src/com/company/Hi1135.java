package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zxiaocun on 2017/4/2.
 */
public class Hi1135 {

    private static int x;
    private static int y;
    private static int z;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int cr = 0, cy = 0, cb = 0;
            x = in.nextInt();
            y = in.nextInt();
            z = in.nextInt();
            char[] chars = in.next().toCharArray();
            List<Character> results = new LinkedList<>();
            int max = 0;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                results.add(c);
                if (results.size() > max) {
                    max = results.size();
                }

                switch (c) {
                    case 'R':
                        cr++;
                        break;
                    case 'Y':
                        cy++;
                        break;
                    case 'B':
                        cb++;
                        break;
                }

                if (isMatch(cr, cy, cb)) {
                    cr = cy = cb = 0;
                    results.clear();
                }
            }
            System.out.println(max);
        }
    }

    private static boolean isMatch(int cr, int cy, int cb) {
        int x1 = Math.abs(cr - cy);
        int y1 = Math.abs(cy -cb);
        int z1 = Math.abs(cb - cr);

        if ((x1 == x && y1 == y && z1 == z) || (x1 == x && y1 == z && z1 == y ) ||
                (x1 == y && y1 == x && z1 == z) || (x1 == y && y1 == z && z1 == x) ||
                (x1 == z && y1 == x && z1 == y) || (x1 == z && y1 == y && z1 == x)) {
            return true;
        }
        return false;
    }
}

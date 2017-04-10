package com.company;

import java.util.Scanner;

/**
 * Created by zxiaocun on 2017/4/1.
 */
public class Hi1082 {

    private static final String STR = "fjxmlhx";
    private static final String REPLACEMENT = "marshtomp";
    private static final String REPLACEMENT_UPPER = "MARSHTOMP";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {
            String str = in.nextLine();
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (; i <= str.length() - 9;) {
                int j = 0;
                for (; j < REPLACEMENT.length(); j++) {
                    if (str.charAt(i + j) != REPLACEMENT.charAt(j) && str.charAt(i + j) != REPLACEMENT_UPPER.charAt(j)) {
                        break;
                    }
                }

                if (j == REPLACEMENT.length()) {
                    sb.append(STR);
                    i += REPLACEMENT.length();
                } else {
                    sb.append(str.charAt(i));
                    i++;
                }
            }
            sb.append(str.substring(i, str.length()));

            System.out.println(sb.toString());
        }
    }
}

package com.company;

import java.util.Scanner;

/**
 * Created by zxiaocun on 2017/4/5.
 */
public class Palindrome {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String str = in.next();
            System.out.println(isPalindrome(str));
        }
    }

    private static boolean isPalindrome(String str) {
        if (null == str || str.isEmpty() || str.length() == 1) {
            return true;
        }

        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() -1));
        }else {
            return false;
        }
    }
}

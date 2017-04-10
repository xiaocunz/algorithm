package com.company;

/**
 * Created by zxiaocun on 2017/3/29.
 */
public class Test {
    public static void main(String[] args) {
        int result = test();
        System.out.println(result);
    }

    public static int test() {
        char[] chars = "abcdedf".toCharArray();
        int i = 0;
        for (; i < chars.length; i++) {
            if ('c' == chars[i]) {
                break;
            }
        }
        return i;
    }
}

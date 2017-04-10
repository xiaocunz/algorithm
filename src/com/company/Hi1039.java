package com.company;

import java.util.Scanner;

/**
 * Created by zxiaocun on 2017/4/1.
 */
public class Hi1039 {
    private static final int MAX_LENGTH = 101;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nums = in.nextInt();
        char[] inserts = {'A', 'B', 'C'};
        int max = 0;

        for (int i = 0; i < nums; i++) {
            char[] inputs = in.next().toCharArray();
            // 存放插入后字符串
            max = 0;
            for (char c : inserts) {
                for (int j = 0;j <= inputs.length; j++) {
                    // 插入指定字符
                    char[] items = pluginInChar(inputs, j, c);
                    char[] results = removeDuplicate(items);
                    if (items.length - results.length > max) {
                        max = items.length - results.length;
                    }
                }
            }

            System.out.println(max);
        }
    }

    private static char[] pluginInChar(char[] inputs, int pos, char c) {
        char[] items = new char[inputs.length + 1];
        for (int k = 0; k < pos; k++) {
            items[k] = inputs[k];
        }
        items[pos] = c;
        for (int k = pos; k < inputs.length; k++) {
            items[k + 1] = inputs[k];
        }

        return items;
    }

    private static char[] removeDuplicate(char[] items) {
        while (true) {
            for (int i = 0; i < items.length; ) {
                char c = items[i];
                int j = i + 1;
                while (j < items.length && items[j] == c) j++;
                if (i + 2 <= j) {
                    for (int k = i; k < j; k++) {
                        items[k] = '#';
                    }
                }
                i = j;
            }
            int len = 0;
            for (int i = 0; i < items.length; i++) {
                if (items[i] != '#') {
                    len++;
                }
            }

            if (len == items.length) {
                break;
            }

            char[] temp = new char[len];
            for (int i = 0, j = 0; i < items.length; i++) {
                if (items[i] != '#') {
                    temp[j++] = items[i];
                }
            }

            items = temp;
        }
        return items;
    }
}

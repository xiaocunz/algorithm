package com.company;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by zxiaocun on 2017/3/29.
 */
public class Trie {
    public static void main(String[] args) {
        Node root = new Node();
        Node pos = null;
        Scanner in = new Scanner(System.in);
        // 记录字典单词数量
        int nums = in.nextInt();

        // 构造Trie数，并在构造时统计
        for (int i = 0; i < nums; i++) {
            pos = root;
            char[] chars = in.next().toCharArray();
            int matPos = -1;
            for (int j = 0; j < chars.length; j++) {
                matPos = hasMatched(pos, chars[j]);
                if (matPos == -1) {
                    matPos = addNode(pos, chars[j]);
                }
                pos = pos.points[matPos];
                pos.num++;
            }
            pos.flag++;
        }
        int words = in.nextInt();
        for (int i = 0; i < words; i++) {
            pos = root;
            char[] chars = in.next().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int matchPos = hasMatched(pos, chars[j]);
                if (matchPos == -1) {
                    System.out.println(0);
                    break;
                }
                if (j == chars.length - 1) {
                    System.out.println(pos.points[matchPos].num);
                    break;
                }
                pos = pos.points[matchPos];
            }
        }
    }

    /**
     * 是否有匹配的字符
     * @param node
     * @param c
     * @return 匹配的字符的下标
     */
    private static int hasMatched(Node node, char c) {
        if (node.size == 0) {
            return -1;
        }
        for (int i = 0; i < node.size; i++) {
            if (node.points[i].c == c) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 添加指定的字符节点
     * @param node
     * @param c
     */
    private static int addNode(Node node, char c) {
        Node node1 = new Node();
        node1.c = c;
        node.points[node.size++] = node1;
        return node.size - 1;
    }
}

class Node {
    private static final int SIZE = 26;

    /**
     * flag == 0 : 表示不是单词， >= 1表示单词数量
     */
    public int flag;
    /**
     * 标记个数
     */
    public int num;

    public char c;

    public Node[] points = new Node[SIZE];

    public int size = 0;
    // public Vector<Node> points;
}

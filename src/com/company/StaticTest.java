package com.company;

/**
 * Created by zxiaocun on 2017/4/11.
 */
public class StaticTest {
    static {
        System.out.println("in static...");
    }

    public static void main(String[] args) {
        System.out.println("in main");
        SingletonDemo2.getInstance();
        System.out.println("end");
    }
}

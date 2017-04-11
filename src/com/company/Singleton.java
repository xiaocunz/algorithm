package com.company;

import java.lang.reflect.Constructor;

/**
 * Created by zxiaocun on 2017/4/11.
 */
public class Singleton {
    private volatile static Singleton singleton;
        private Singleton (){}
        public static Singleton getSingleton() {
            if (singleton == null) {
                synchronized (Singleton.class) {
                    if (singleton== null) {
                        singleton = new Singleton();
                    }
                }
            }
        return singleton;
    }
}

class SingletonDemo2 {
    // SingletonHolder用于延迟初始化Instance，在获取时初始化
    private static class SingletonHolder {
        private static final SingletonDemo2 INSTANCE = new SingletonDemo2();

        private static final int TEST_NUM = test();

        private static int test(){
            System.out.println("in test");
            return 1;
        }
    }

    private SingletonDemo2() {
        System.out.println("in SingletonDemo2...");
    }

    public static final SingletonDemo2 getInstance() {
        System.out.println("in getInstance");
        int a = SingletonHolder.TEST_NUM;
        SingletonDemo2 singletonDemo2 = SingletonHolder.INSTANCE;
        System.out.println("end getInstance");
        return singletonDemo2;
    }

    public static void main(String[] args) throws Exception{
        Class<?> c = Class.forName(SingletonDemo2.class.getName());
//        Object o = c.getDeclaredMethod("getInstance").invoke(null);
        Constructor constructor = c.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonDemo2 o = (SingletonDemo2)constructor.newInstance();
        SingletonDemo2  singletonDemo2 = SingletonDemo2.getInstance();
        System.out.println("end");
    }
}

enum Singleton2 {
    INSTANCE;

    public void whateverMethos() {

    }
}

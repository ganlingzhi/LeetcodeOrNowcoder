package com.thread;

public class A {
    private static int i = 0;

    private synchronized static void setI(int i) {
        A.i = i;
    }

    private synchronized static int getI() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                setI(1);
            }
        });
        thread1.start();
        thread1.join();

        System.out.println(i);
    }
}

package com.kakaowo.com.thread.leetcode_1114;

import java.util.concurrent.CountDownLatch;

class Foo {
    private CountDownLatch countDownLatchFirst = new CountDownLatch(1);
    private CountDownLatch countDownLatchSecond = new CountDownLatch(1);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatchFirst.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        countDownLatchFirst.await();
        printSecond.run();
        countDownLatchSecond.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        countDownLatchSecond.await();
        printThird.run();
    }
}
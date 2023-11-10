package com.kakaowo.com.thread.leetcode_1114;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo {
    private final Lock lock = new ReentrantLock();
    private final Condition Condition1 = lock.newCondition();
    private final Condition Condition2 = lock.newCondition();
    private final Condition Condition3 = lock.newCondition();

    private AtomicInteger atomicIntegerFirst = new AtomicInteger(0);
    private AtomicInteger atomicIntegerSecond = new AtomicInteger(0);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        atomicIntegerFirst.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        while(atomicIntegerFirst.get() != 1) {}
        printSecond.run();
        atomicIntegerSecond.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        while(atomicIntegerSecond.get() != 1) {}
        printThird.run();
    }
}
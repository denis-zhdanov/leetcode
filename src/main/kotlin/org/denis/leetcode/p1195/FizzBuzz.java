package org.denis.leetcode.p1195;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class FizzBuzz {

    private final Semaphore fizzSemaphore = new Semaphore(0);
    private final Semaphore buzzSemaphore = new Semaphore(0);
    private final Semaphore fizzBuzzSemaphore = new Semaphore(0);
    private final Semaphore numberSemaphore = new Semaphore(1);

    private final AtomicInteger n = new AtomicInteger();
    private final int max;

    public FizzBuzz(int n) {
        max = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (n.get() <= max) {
            fizzSemaphore.acquire();
            if (n.get() > max) {
                break;
            }
            printFizz.run();
            numberSemaphore.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (n.get() <= max) {
            buzzSemaphore.acquire();
            if (n.get() > max) {
                break;
            }
            printBuzz.run();
            numberSemaphore.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (n.get() <= max) {
            fizzBuzzSemaphore.acquire();
            if (n.get() > max) {
                break;
            }
            printFizzBuzz.run();
            numberSemaphore.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (n.get() <= max) {
            numberSemaphore.acquire();
            int i = n.incrementAndGet();
            if (i > max) {
                break;
            }
            if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzzSemaphore.release();
            } else if (i % 3 == 0) {
                fizzSemaphore.release();
            } else if (i % 5 == 0) {
                buzzSemaphore.release();
            } else {
                printNumber.accept(i);
                numberSemaphore.release();
            }
        }
        fizzSemaphore.release();
        buzzSemaphore.release();
        fizzBuzzSemaphore.release();
    }
}
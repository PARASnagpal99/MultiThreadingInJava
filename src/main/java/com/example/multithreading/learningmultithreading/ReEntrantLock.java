package com.example.multithreading.learningmultithreading;

public class ReEntrantLock {
    public static void main(String[] args) {
           SharedResource2 sharedResource2 = new SharedResource2();

           Thread thread1 = new Thread(sharedResource2::producer);
           Thread thread2 = new Thread(sharedResource2::producer);

           thread1.start();
           thread2.start();
    }
}

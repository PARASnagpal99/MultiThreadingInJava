package com.example.multithreading.learningmultithreading;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockMain {
       public static void main(String[] args){
              ReadWriteLock lock = new ReentrantReadWriteLock();
              SharedResourceReadWriteLock sharedResourceReadWriteLock = new SharedResourceReadWriteLock();
              Thread thread1 = new Thread(()-> sharedResourceReadWriteLock.producer(lock));
              Thread thread2 = new Thread(()-> sharedResourceReadWriteLock.producer(lock));
              Thread thread3 = new Thread(()-> sharedResourceReadWriteLock.consumer(lock));
              thread1.start();
              thread2.start();
              thread3.start();
       }
}

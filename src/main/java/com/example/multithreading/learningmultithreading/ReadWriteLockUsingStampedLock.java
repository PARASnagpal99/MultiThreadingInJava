package com.example.multithreading.learningmultithreading;

public class ReadWriteLockUsingStampedLock {
       public static void main(String[] args){
              SharedResourceStampedLock1 sharedResourceStampedLock1 = new SharedResourceStampedLock1();
              Thread thread1 = new Thread(sharedResourceStampedLock1::producer);
              Thread thread2 = new Thread(sharedResourceStampedLock1::producer);
              Thread thread3 = new Thread(sharedResourceStampedLock1::consumer);

              thread1.start();
              thread2.start();
              thread3.start();
       }
}

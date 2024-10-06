package com.example.multithreading.learningmultithreading;

public class SemaphoreLockMain {
       public static void main(String[] args){
              SharedResourceSemaphoreLock sharedResourceSemaphoreLock = new SharedResourceSemaphoreLock();
              Thread thread1 = new Thread(sharedResourceSemaphoreLock::producer);
              Thread thread2 = new Thread(sharedResourceSemaphoreLock::producer);
              Thread thread3 = new Thread(sharedResourceSemaphoreLock::producer);

              thread1.start();
              thread2.start();
              thread3.start();
       }
}

package com.example.multithreading.learningmultithreading;

public class OptimisticLock {

       public static void main(String[] args){
           SharedResourceOptimisticLocking sharedResourceOptimisticLocking = new SharedResourceOptimisticLocking();
           Thread thread1 = new Thread(sharedResourceOptimisticLocking::producer);
           Thread thread2 = new Thread(sharedResourceOptimisticLocking::consumer);

           thread1.start();
           thread2.start();
       }



}

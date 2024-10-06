package com.example.multithreading.learningmultithreading;

import java.util.concurrent.locks.StampedLock;

public class SharedResourceOptimisticLocking {
    int a = 10 ;
    StampedLock lock = new StampedLock();

    public void producer(){
        long stamp = lock.tryOptimisticRead();
        try{
           System.out.println("Taken optimistic lock");
           a = 11 ;
           Thread.sleep(6000);
           if(lock.validate(stamp)){
               System.out.println("Updated the value successfully");
           }else{
               System.out.println("Rollback of work");
               a = 10 ; // rollback
           }
        }catch(Exception exception){
            //logging exception
        }
    }

    public void consumer(){
        long stamp = lock.writeLock();
        System.out.println("Write lock acquired by consumer" + Thread.currentThread().getName());
        try{
          System.out.println("performing work");
          a = 9 ;
        }finally {
           lock.unlockWrite(stamp);
           System.out.println("Write lock released by : " + Thread.currentThread().getName());
        }
    }



}

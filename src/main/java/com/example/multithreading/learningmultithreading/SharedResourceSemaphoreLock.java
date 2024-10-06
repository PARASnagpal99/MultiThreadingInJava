package com.example.multithreading.learningmultithreading;

import java.util.concurrent.Semaphore;

public class SharedResourceSemaphoreLock {
       boolean isAvailable = false ;
       Semaphore lock = new Semaphore(2);

       public void producer(){
           try{
               lock.acquire();
               System.out.println("Lock Acquired By : " + Thread.currentThread().getName());
               isAvailable = true ;
               Thread.sleep(6000);
           }catch(Exception exception){
               // logging exception
           }finally {
               lock.release();
               System.out.println("Lock release By : " + Thread.currentThread().getName());
           }
       }
}

package com.example.multithreading.learningmultithreading;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource2 {
       boolean isAvailable = false ;
       ReentrantLock lock = new ReentrantLock();

       public void producer(){
           try{
               lock.lock();
               System.out.println("Lock acquired by thread : " + Thread.currentThread().getName());
               isAvailable = true ;
               Thread.sleep(4000);
           }catch(Exception ex){
               // logging exception
           }
           finally {
               lock.unlock();
               System.out.println("Lock Release by thread : " + Thread.currentThread().getName());
           }
       }

}

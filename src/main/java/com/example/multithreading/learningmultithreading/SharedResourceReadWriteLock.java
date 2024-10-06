package com.example.multithreading.learningmultithreading;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResourceReadWriteLock {
       boolean isAvailable = true ;
       public void producer(ReadWriteLock lock){
              try{
                     lock.readLock().lock();
                     System.out.println("Read lock acquired by : " + Thread.currentThread().getName());
                     Thread.sleep(8000);
              }catch(Exception ex){
                     // logging exception
              }finally {
                     lock.readLock().unlock();
                     System.out.println("Read lock released by : " + Thread.currentThread().getName());
              }
       }

       public void consumer(ReadWriteLock lock){
              try{
                     lock.writeLock().lock();
                     isAvailable = false ;
                     System.out.println("Write lock acquired by : " + Thread.currentThread().getName());
                     Thread.sleep(8000);
              }catch (Exception ex){
                     // logging exception
              }finally {
                     lock.writeLock().unlock();
                     System.out.println("Write lock released by : " + Thread.currentThread().getName());
              }
       }
}

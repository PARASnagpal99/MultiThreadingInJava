package com.example.multithreading.learningmultithreading;

public class SharedResource {

    boolean isItemPresent = false;

    public synchronized void addItem() {
        isItemPresent = true;
        System.out.println("Producer Thread calling the notify method");
        notifyAll();
    }

    public synchronized void consumeItem() throws InterruptedException {
        System.out.println("Consumer Thread inside consume item");
        while (!isItemPresent) {
            try {
                System.out.println("Consumer Thread is waiting");
                wait();
            } catch (Exception ex) {
                System.out.println("Exception occured while waiting in consume item");
            }
        }
        System.out.println("Consumer Thread consumed the item");
        isItemPresent = false;
    }


}

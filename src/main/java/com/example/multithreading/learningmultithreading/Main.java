package com.example.multithreading.learningmultithreading;

public class Main {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedResource.addItem();
        });

        Thread consumerThread = new Thread(() -> {
            try {
                sharedResource.consumeItem();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producerThread.start();
        consumerThread.start();

    }

}

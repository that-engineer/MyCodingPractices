package com.myPractice.Multithreading;

public class TaskEvenOdd implements Runnable{
	private int max;
    private Print print;
    private boolean isEvenNumber;
 
    public TaskEvenOdd(Print print, int max, boolean isEvenNumber) {
		super();
		this.max = max;
		this.print = print;
		this.isEvenNumber = isEvenNumber;
	}

	@Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number += 2;
        }
    }
    
    public static void main(String[] args) {
        Print print = new Print();
        Thread t1 = new Thread(new TaskEvenOdd(print, 10, false),"Odd");
        Thread t2 = new Thread(new TaskEvenOdd(print, 10, true),"Even");
        
        t2.start();t1.start();
    }
}

class Print {
    private volatile boolean isOdd;
 
    synchronized void printEven(int number) {
        while (!isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
       // System.out.println(Thread.currentThread().getName() + ":" + number);
        System.out.println(number);
        isOdd = false;
        notify();
    }
 
    synchronized void printOdd(int number) {
        while (isOdd) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOdd = true;
        notify();
    }
}
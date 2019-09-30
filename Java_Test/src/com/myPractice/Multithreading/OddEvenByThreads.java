package com.myPractice.Multithreading;

public class OddEvenByThreads implements Runnable {
	private int max;
	private Printer printer;
	private boolean isEven;

	public OddEvenByThreads(int max, Printer printer, boolean isEven) {
		super();
		this.max = max;
		this.printer = printer;
		this.isEven = isEven;
	}


	@Override
	public void run() {
		int num= isEven ? 2 : 1;
		while(num<=max) {
			if(isEven) {
				printer.printEven(num);
			}else {
				printer.printOdd(num);
			}
			num+=2;
		}
		
	}
	
	public static void main(String[] aser) {
		Printer printer = new Printer();
		Thread t1 = new Thread(new OddEvenByThreads(10, printer, false), "Odd");
		Thread t2 = new Thread(new OddEvenByThreads(10, printer, true), "Even");
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}


class Printer{
	private volatile boolean isOdd=false;
	
	synchronized void printEven(int i) {
		while(!isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				 Thread.currentThread().interrupt();
			}
		}
		System.out.println(i);
		isOdd=false;
		notify();
	}
	
	synchronized void printOdd(int i) {
		while(isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				 Thread.currentThread().interrupt();
			}
		}
		System.out.println(i);
		isOdd=true;
		notify();
		
	}
	
}
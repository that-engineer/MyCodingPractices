package com.myPractice.Multithreading;

public class PrintHelloWorld {
	boolean flag;
	int count = 1;
	int max = 10;

	public void printHello() {
		synchronized (this) {
			while (count < max) {
				while (!flag) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Hello ");
				count++;
				flag = false;
				notify();
			}
		}
	}

	public void printWorld() {
		synchronized (this) {
			while (count < max) {
				while (flag) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("World ");
				count++;
				flag = true;
				notify();
			}
		}
	}

	public static void main(String[] args) {
		PrintHelloWorld printMain = new PrintHelloWorld();
		printMain.flag = true;
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				printMain.printWorld();
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				printMain.printHello();
			}

		});
		t1.start();
		t2.start();
	}
}

package com.myPractice.Multithreading;

import java.util.concurrent.LinkedBlockingQueue;

class ProducerThread implements Runnable{

	private LinkedBlockingQueue sharedObj;
	
	public ProducerThread(LinkedBlockingQueue sharedObj) {
		this.sharedObj=sharedObj;
	}
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Producing "+i);
			try {
				sharedObj.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class ConsumerThread implements Runnable{

	private LinkedBlockingQueue sharedObj;
	
	public ConsumerThread(LinkedBlockingQueue sharedObj) {
		this.sharedObj=sharedObj;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("Consuming "+sharedObj.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class ProducerConsumer2 {

	public static void main(String[] args) {
	
		LinkedBlockingQueue sharedObj = new LinkedBlockingQueue(4);
		Thread t1 = new Thread(new ProducerThread(sharedObj));
		Thread t2 = new Thread(new ConsumerThread(sharedObj));
		
		t1.start();
		t2.start();
	}

}

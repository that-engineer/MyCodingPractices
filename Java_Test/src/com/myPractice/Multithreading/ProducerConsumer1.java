package com.myPractice.Multithreading;

import java.util.Vector;

class Producer implements Runnable{
	private Vector sharedObj;
	private int capacity;
	
	Producer(Vector sharedObj,int capacity){
		this.sharedObj=sharedObj;
		this.capacity=capacity;
	}
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				produce(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void produce(int i) throws InterruptedException{
		synchronized(sharedObj) {
			while(sharedObj.size()==capacity) {
				System.out.println("Resource is full");
				sharedObj.wait();
			}
			
			sharedObj.add(i);
			sharedObj.notifyAll();
			System.out.println("Producing "+i);
		}
	}
}

class Consumer implements Runnable{
	private Vector sharedObj;
	private int capacity;
	
	Consumer(Vector sharedObj,int capacity){
		this.sharedObj=sharedObj;
		this.capacity=capacity;
	}
	public void run() {
		while(true) {
			Integer i;
			try {
				i = consume();
				System.out.println("Consumed "+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private int consume() throws InterruptedException {
		synchronized(sharedObj) {
			while(sharedObj.isEmpty()) {
				sharedObj.wait();
			}
			Integer i = (Integer) sharedObj.remove(0);
			sharedObj.notifyAll();
			return i;
		}
	}
}
public class ProducerConsumer1 {

	public static void main(String[] args) {
		Vector sharedObj = new Vector();
		Thread t1 = new Thread(new Producer(sharedObj, 4));
		Thread t2 = new Thread(new Consumer(sharedObj, 4));
		t1.start();
		t2.start();
		/*
		 * char c ='4'; int a = c;System.out.println(Character.getNumericValue(a));
		 */
	}

}

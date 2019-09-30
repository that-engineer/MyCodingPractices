package com.myPractice.Multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	public static void main(String[] arse) {
		CyclicBarrier c = new CyclicBarrier(4);
		Thread t = new Thread(() -> {
			try {
				c.await();
				c.await();
			} catch (InterruptedException | BrokenBarrierException e) {

			}
		});
		
		t.start();
		System.out.println(c.getNumberWaiting());
		System.out.println(c.isBroken());
	}
}

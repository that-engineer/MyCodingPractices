package com.myPractice.Multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String[] sd) {
		CountDownLatch countDownLatch = new CountDownLatch(2);
		Thread t = new Thread(() -> {
		countDownLatch.countDown();
		countDownLatch.countDown();
		});
		t.start();
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(countDownLatch.getCount());
	}
}

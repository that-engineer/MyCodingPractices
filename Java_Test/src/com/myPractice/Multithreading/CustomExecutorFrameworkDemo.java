package com.myPractice.Multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomExecutorFrameworkDemo implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		MyThreadPool threadPool = new MyThreadPool(3);
		for (int i = 0; i < 6; i++) {
			Thread t = new Thread(new CustomExecutorFrameworkDemo());
			threadPool.execute(t);
		}
	}
}

class MyThreadPool implements java.util.concurrent.Executor {
	private final BlockingQueue<Runnable> queue;

	public MyThreadPool(int numThreads) {
		queue = new LinkedBlockingQueue<Runnable>(numThreads);
		for (int i = 0; i < numThreads; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						try {
							queue.take().run();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}

			}).start();
		}
	}

	@Override
	public void execute(Runnable command) {
		try {
			queue.put(command);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
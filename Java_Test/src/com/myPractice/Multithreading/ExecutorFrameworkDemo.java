package com.myPractice.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecutorFrameworkDemo {
	public static void main(String[] sd) {
		ExecutorService executors = Executors.newFixedThreadPool(2);
		 for(int i=1;i<6;i++) {
			 RunnableTask task = new RunnableTask(i);
			 executors.submit(task);
		 }
	}
}

class RunnableTask implements Runnable{
	private int taskNo;
	
	public RunnableTask(int taskNo) {
		this.taskNo = taskNo;
	}

	@Override
	public void run() {
		System.out.println("Current task "+taskNo+" is getting executed by thread "+Thread.currentThread().getName());
		
	}
	
}

package com.myPractice.Multithreading;

public class PrintNumbersByThreads {
	int count;
	
	public static void main(String[] rgs) {
		PrintNumbersByThreads sharedResource = new PrintNumbersByThreads();
		sharedResource.count=1;
		for(int i=0;i<10;i++) {
			new Thread(new PrinterThreads(i, sharedResource)).start();
		}
	}

}

class PrinterThreads implements Runnable{
	private int turn;
	private PrintNumbersByThreads sharedResource;

	public PrinterThreads(int turn, PrintNumbersByThreads sharedResource) {
		this.turn = turn;
		this.sharedResource = sharedResource;
	}

	@Override
	public void run() {
		synchronized (sharedResource) {
			try {
				while(true) {
					while(sharedResource.count%10 != turn) {
						sharedResource.wait();
					}
					if(sharedResource.count == 101) {
						break;
					}
					System.out.println(Thread.currentThread().getName()+" printing "+sharedResource.count);
					sharedResource.count = sharedResource.count+1;
					sharedResource.notifyAll();
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

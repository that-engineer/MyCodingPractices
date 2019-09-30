package com.myPractice.Multithreading;

public class TenThreads {

    public int currentTaskValue = 1;

    public static void main(String[] args) {
        TenThreads sharedResource = new TenThreads();
        for (int i = 0; i < 10; i++) {
            ModThread modThread = new ModThread(i, sharedResource);
            modThread.start();
        }
    }

}

class ModThread extends Thread {
    private int modValue;
    private TenThreads sharedResource;

    public ModThread(int modValue, TenThreads sharedResource) {
        this.modValue = modValue;
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        synchronized (sharedResource) {
            try {
                while (true) {
                    while (sharedResource.currentTaskValue % 10 != modValue) {
                    	sharedResource.wait();
                    }

                    if (sharedResource.currentTaskValue == 101) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + " : "
                            + sharedResource.currentTaskValue + " ,");
                    sharedResource.currentTaskValue = sharedResource.currentTaskValue + 1;
                    sharedResource.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

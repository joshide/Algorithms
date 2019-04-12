package ThreadsAndCollections;

public class ThreadExample1 {

	// Thread class implements Runnable that is why Thread class has run method
	// There are two ways to construct thread
	// 1. extending Thread class and overriding run() method
	// 2. Implementing Runnable interface i.e creating a task and putting it in Thread constructor
	// Thread class have two major constructor 1. Default() constructor 2. A constructor which takes runnable interface
	public static void main(String[] args) {
		
		Thread thread1 = new Thread("Thread1");
		thread1.start();
		
		Thread myThread = new MyThread();
		myThread.start();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Running Runnable");
				
			}
		});
		
		t1.start();
		

	}

}

class MyThread extends Thread {
	public void run() {
		System.out.println("Running MyThread");
	}
}

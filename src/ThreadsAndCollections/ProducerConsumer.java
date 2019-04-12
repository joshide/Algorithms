package ThreadsAndCollections;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {

	private static List<Integer> list = new LinkedList<>();
	private static int size = 5;
	public static void main(String[] args) throws InterruptedException {
		
		ProducerTask pt = new ProducerTask(list,size);
		ConsumerTask ct = new ConsumerTask(list);
		
		Thread producer = new Thread(pt,"Producer");
		Thread consumer = new Thread(ct,"Consumer");
		
		list.add(100);list.add(200);list.add(300);list.add(400);list.add(500);
		consumer.start();
		Thread.sleep(2000);
		producer.start();
		
		
		

	}

}


class ProducerTask implements Runnable {
	private List<Integer> list = new LinkedList<>();
	private int size;
	
	public ProducerTask(List<Integer> list, int size) {
		this.list = list;
		this.size = size;
	}

	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			synchronized (list) {
				while(list.size() == size) {
					try {
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				list.add(i);
				System.out.println(Thread.currentThread().getName() + "added " + i) ;
				list.notify();
			}
			
		}
		
	}
}

class ConsumerTask implements Runnable {
	private List<Integer> list = new LinkedList<>();
	
	public ConsumerTask(List<Integer> list) {
		this.list = list;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 15; i++) {
			synchronized (list) {
				if(list.size() == 0) {
					try {
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " Removed : " + list.remove(0) );
				list.notify();
			}
			
		}
		
	}
}
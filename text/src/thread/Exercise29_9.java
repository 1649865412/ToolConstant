package thread;

import java.util.*;

public class Exercise29_9 {
	private static Set<Integer> array = Collections.synchronizedSet(new HashSet<Integer>());
	
	public static void main(String[] args){
		Thread thread1 = new Thread(new Task1());
		Thread thread2 = new Thread(new Task2());
		thread1.start();
		thread2.start();
	}
	private static class Task1 implements Runnable {
		public void run() {
			try {
				for(int i=0;i<1000;i++){
					Thread.sleep(1000);
					System.out.println("Threat 1:");
					array.add(i);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private static class Task2 implements Runnable {
		public void run() {
			try {
				for(int i=0;i<1000;i++){
					Thread.sleep(1000);
					System.out.println("Threat 2:");
					Iterator e = array.iterator();
					while(e.hasNext()){
						System.out.println("the number:"+e.next().toString());
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

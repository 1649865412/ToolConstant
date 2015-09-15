package thread;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Exercise29_10 {
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
					System.out.println("Threat 1:");
					array.add(i);
					Thread.sleep(1000);
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
					synchronized(array){
						Iterator e = array.iterator();
						while(e.hasNext()){
							System.out.println("the number:"+e.next().toString());
						}
					}
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
package thread;

import java.util.concurrent.*;


public class Exercise29_4{
	private static Integer sum = new Integer(0);
	public static void main(String[] args){
		ExecutorService excutor = Executors.newFixedThreadPool(1000);
		for(int i=0;i<1000;i++){
			excutor.execute(new SumTotal());
		}
		excutor.shutdown();
		while(!excutor.isTerminated()){
		}
		System.out.println("the sum is ?"+sum);
	}
	
	private static class SumTotal implements Runnable{
		public void run() {
				int value = sum.intValue() + 1;
		     	sum = new Integer(value);
		}
	}
}

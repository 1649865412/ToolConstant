package thread;

import java.util.concurrent.*;

public class Exercise {
	private static Account account = new Account();
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		/*ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i=0;i < 100;i++){
			executor.execute(new AddPennyTask());
		}
		executor.shutdown();
		
		while(!executor.isTerminated()){
		}
		System.out.println("what is balance?"+account.getBalance());*/
		ExecutorService executor =  Executors.newSingleThreadExecutor();
		FutureTask<String> future = new FutureTask<String>(
		        new Callable<String>() {// 使用Callable接口作为构造参数
		            public String call(){
		                // 真正的任务在这里执行，这里的返回值类型为String，可以为任意类型
		                try {
		                    Thread.sleep(10000);
		                    System.out.print("good");
		                } catch (InterruptedException e) {
		                    // TODO Auto-generated catch block
		                    e.printStackTrace();
		                }
		                return "ok";
		            }
		        });
		executor.execute(future);
		System.out.println("执行额外任务");
		
		System.out.println("等待线程结果"+future.get());
		System.out.println("线程结束");
	}
	
	
	private static class AddPennyTask implements Runnable{
		public void run(){
			account.deposit(100);
		}
	}
	
	private static class Account{
		private int balance = 0;
		public int getBalance(){
			return balance;
		}
		
		public void deposit(int amount){
			int newBalance = balance + amount;
			
			try{
				Thread.sleep(5);
			}
			catch(InterruptedException ex){
			}
			
			balance = newBalance;
		}
	}
}

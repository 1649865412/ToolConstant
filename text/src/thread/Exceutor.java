package thread;

import java.util.concurrent.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;



/**
 * ExecutorService在
 * 
 * 
 * http://blog.csdn.net/aboy123/article/details/38307539 有返回值的线程
 */
@SuppressWarnings("unchecked")
public class Exceutor
{
	public static void main(String[] args) throws ExecutionException, InterruptedException
	{
		System.out.println("----总程序开始运行----");
		Date date1 = new Date();
		
		int taskSize = 5;
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(10);
		// 创建多个有返回值的任务
		List<Future> list = new ArrayList<Future>();
		for (int i = 0; i < 10; i++)
		{
			Callable c = new MyCallable(i + " ");
			// 执行任务并获取Future对象，获取返回结果
			Future f = pool.submit(c);
			list.add(f);
		}
		// 关闭线程池
		pool.shutdown();
		
		// 获取所有并发任务的运行结果
		for (Future f : list)
		{
			// 从Future对象上获取任务的返回值，并输出到控制台
			System.out.println("在其它线程还在跑的时候，打印已经完成的结果集" + f.get().toString());
		}
		
		Date date2 = new Date();
		System.out.println("----总程序结束运行----，程序运行时间【" + (date2.getTime() - date1.getTime()) + "毫秒】");
	}
}

class MyCallable implements Callable<Object>
{
	private String taskNum;
	MyCallable(String taskNum)
	{
		this.taskNum = taskNum;
	}
	public Object call() throws Exception
	{
		System.out.println("进入call方法begin:" + taskNum + "任务启动");
		Date dateTmp1 = new Date();
		Thread.sleep(2000);
		Date dateTmp2 = new Date();
		long time = dateTmp2.getTime() - dateTmp1.getTime();
		System.out.println("进入call方法end" + taskNum + "任务终止");
		return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
	}
}
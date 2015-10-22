/**
 * 单例模式，多线程安全 <code>Singleton.java</code>
 * <p>
 * <p>
 * Copyright 2015 All right reserved.
 * 
 * @author admin 时间 2015-9-29 下午03:13:02
 * @version 1.0 </br>最后修改人 无
 */
public class Singleton
{
	private volatile static Singleton instance;
	
	private Singleton()
	{
	};
	
	public static Singleton getInstance()
	{
		if (instance == null)
		{
			synchronized (Singleton.class)
			{
				if (instance == null)
				{
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

/**
 * nio读取、写入文档数据 <code>Program.java</code>
 * <p>
 * <p>
 * Copyright 2015 All right reserved.
 * 
 * @author admin 时间 2015-6-12 下午02:59:16
 * @version 1.0 </br>最后修改人 无
 */
public class Program
{
	
	/**
	 * 功能:nio读取数据
	 * <p>作者 杨荣忠 2015-6-12 下午03:02:14
	 * @param args
	 * @throws Exception
	 */
	static public void main(String args[]) throws Exception
	{
		FileInputStream fin = new FileInputStream("C:\\123.txt");
		
		// 获取通道
		FileChannel fc = fin.getChannel();
		
		// 创建缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		// 读取数据到缓冲区
		fc.read(buffer);
		
		buffer.flip();
		
		while (buffer.remaining() > 0)
		{
			byte b = buffer.get();
			System.out.print(((char) b));
		}
		
		fin.close();
	}
	
	static private final byte message[] =
	{ 83, 111, 109, 101, 32, 98, 121, 116, 101, 115, 46 };
	
	
	/**
	 * 功能:nio写入数据
	 * <p>作者 杨荣忠 2015-6-12 下午03:02:04
	 * @param args
	 * @throws Exception
	 */
	static public void main2(String args[]) throws Exception
	{
		FileOutputStream fout = new FileOutputStream("c:\\test.txt");
		
		FileChannel fc = fout.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		for (int i = 0; i < message.length; ++i)
		{
			buffer.put(message[i]);
		}
		
		buffer.flip();
		
		fc.write(buffer);
		
		fout.close();
	}
	
}
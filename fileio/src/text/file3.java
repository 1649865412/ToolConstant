package text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 *  <code>file3.java字符流转缓存流</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author 杨荣忠 时间 2015-3-12 下午01:51:45	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class file3 {
	
	public static void main(String[] args) throws IOException  {
		
	FileReader reader=new FileReader("a.txt");
	BufferedReader buffreader=new BufferedReader(reader,1024);

	FileWriter writer=new FileWriter("b.txt");
	BufferedWriter buffwriter=new BufferedWriter(writer,1024);
	
	String b=buffreader.readLine();
	while(b!=null)
	{
		   buffwriter.write(b);
		   buffwriter.newLine();
		   b=buffreader.readLine();
	   buffwriter.close();
	   buffreader.close();
	}
	}
	
}

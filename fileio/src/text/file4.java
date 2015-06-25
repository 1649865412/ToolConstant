package text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * 
 *  <code>file4.java字符流转缓存流</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author 杨荣忠 时间 2015-3-12 下午01:52:11	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class file4 {
	public static void main(String[] args) throws IOException  {
		
	FileReader reader=new FileReader("c:/a.txt");
	BufferedReader buffreader=new BufferedReader(reader);

	FileWriter writer=new FileWriter("c:/b.txt");
	PrintWriter buffwriter=new PrintWriter(writer);
	String b =buffreader.readLine();
	while(null!=b)
	{    
				 //   buffwriter.write(b);
				 //  buffwriter.newLine();
				   buffwriter.println(b);
				   b=buffreader.readLine();
	}
	//int b=reader.read();
	   buffwriter.close();
	   buffreader.close();
			
	}
	
}

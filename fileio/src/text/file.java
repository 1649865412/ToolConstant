package text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 *  <code>file.java：字节流</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author 杨荣忠 时间 2015-3-12 下午01:49:59	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class file {
	
	public static void main(String[] args) throws FileNotFoundException  {
		
	FileInputStream a=new FileInputStream("HTML.txt");
	FileOutputStream b=new FileOutputStream("B.txt");
	
	try {
		byte[] b1=new byte[1024];
		int read=a.read(b1);
		if(read!=-1)
		{
			b.write(read);
			read=a.read();
		}
		a.close();
		b.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
	}
}

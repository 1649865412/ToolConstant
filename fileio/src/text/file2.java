package text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 *  <code>file2.java字符流</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author 杨荣忠 时间 2015-3-12 下午01:50:16	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class file2 {
	public static void main(String[] args) throws IOException  {
		
	FileReader reader=new FileReader("a.txt");
	//BufferedReader buffreader=new BufferedReader(reader);

	FileWriter writer=new FileWriter("b.txt");
	//BufferedWriter buffwriter=new BufferedWriter(writer);
	
	
	int b=reader.read();
	if(b!=-1){
		try {
			writer.write(b);
			b=reader.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.close();
		reader.close();
		}
	}
	
}

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *  流读取文件返回编码
 *  <code>UTFtext.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-6-12 下午05:48:19	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class UTFtext
{
	/**功能:流读取文件返回编码
	 * <p>作者 杨荣忠 2015-6-12 下午05:45:50
	 * @param args
	 * @throws Exception 
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException, Exception
	{
		// TODO Auto-generated method stub
		FileInputStream fInputStream = new FileInputStream("c://text.txt");  
		//code为上面方法里返回的编码方式  
		InputStreamReader inputStreamReader = new InputStreamReader(fInputStream, codeString(""));  
		BufferedReader in = new BufferedReader(inputStreamReader);  
		StringBuffer  sBuffer =new  StringBuffer("");  
		String strTmp = "";  
		//按行读取  
		while (( strTmp = in.readLine()) != null) {  
		    sBuffer.append(strTmp + "/n");  
		}  
	    System.out.println(sBuffer.toString()); 
		
	}
	
	
    /** 
     * 判断文件的编码格式 
     * @param fileName :file 
     * @return 文件编码格式 
     * @throws Exception 
     */  
    public static String codeString(String fileName) throws Exception{  
        BufferedInputStream bin = new BufferedInputStream(  
        new FileInputStream(fileName));  
        int p = (bin.read() << 8) + bin.read();  
        String code = null;  
          
        switch (p) {  
            case 0xefbb:  
                code = "UTF-8";  
                break;  
            case 0xfffe:  
                code = "Unicode";  
                break;  
            case 0xfeff:  
                code = "UTF-16BE";  
                break;  
            default:  
                code = "GBK";  
        }  
        return code;  
    }  
    
}

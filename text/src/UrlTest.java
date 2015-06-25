import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


/**
 *  获取urL内容
 *  <code>UrlTest.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-6-10 上午10:48:24	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class UrlTest
{
	public static final String  url ="http://finance.baidu.com/";
	public static void main(String[] args)
	{
		 doHttpJsonByBufferedReader(url);
	}

	
	/**
	 * 功能:获取urL内容
	 * <p>作者 杨荣忠 2015-6-10 上午10:29:06
	 * @param getUrl
	 * @return
	 */
	public static String doHttpJsonByBufferedReader(String getUrl)
    {
        String msg = "";
        try
        {
            URL url = new URL(getUrl);
            BufferedReader r = null;
            URLConnection con = url.openConnection();
            r = new BufferedReader(new InputStreamReader(con.getInputStream(),
                    "UTF-8"));
            String sCurrentLine = "";
            while ((sCurrentLine = r.readLine()) != null)
            {
                msg += sCurrentLine;
            }
            r.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        System.out.println("doHttpJsonByBufferedReader："+msg);
        return msg;
    }
	
	
}

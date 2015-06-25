package text;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * 获取系统名字
 *  <code>InteAddress.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-6-11 下午02:58:22	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class InteAddress {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress ia=InetAddress.getLocalHost();
			System.out.println(ia.getHostAddress());
			System.out.println(ia.getHostName());
			System.out.println(ia.getLocalHost());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

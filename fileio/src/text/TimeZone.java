package text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *  <code>TimeZone.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author 杨荣忠 时间 2015-3-6 下午02:55:27	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class TimeZone
{

	/**功能:
	 * <p>作者 杨荣忠 2015-3-6 下午02:55:27
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		System.out.println("Java运行时环境版本:" + System.getProperty("java.version"));  
        System.out.println("Java 运行时环境供应商:" + System.getProperty("java.vendor"));  
        System.out.println("Java 供应商的URL:" + System.getProperty("java.vendor.url"));  
        System.out.println("Java安装目录:" + System.getProperty("java.home"));  
        System.out.println("Java 虚拟机规范版本:" + System.getProperty("java.vm.specification.version"));  
        System.out.println("Java 类格式版本号:" + System.getProperty("java.class.version"));  
        System.out.println("Java类路径：" + System.getProperty("java.class.path"));  
        System.out.println("加载库时搜索的路径列表:" + System.getProperty("java.library.path"));  
        System.out.println("默认的临时文件路径:" + System.getProperty("java.io.tmpdir"));  
        System.out.println("要使用的 JIT 编译器的名称:" + System.getProperty("java.compiler"));  
        System.out.println("一个或多个扩展目录的路径:" + System.getProperty("java.ext.dirs"));  
        System.out.println("操作系统的名称:" + System.getProperty("os.name"));  
        System.out.println("操作系统的架构:" + System.getProperty("os.arch"));  
        System.out.println("操作系统的版本:" + System.getProperty("os.version"));  
        System.out.println("文件分隔符（在 UNIX 系统中是“/”）:" + System.getProperty("file.separator"));  
        System.out.println("路径分隔符（在 UNIX 系统中是“:”）:" + System.getProperty("path.separator"));  
        System.out.println("行分隔符（在 UNIX 系统中是“”）:" + System.getProperty("line.separator"));  
        System.out.println("用户的账户名称:" + System.getProperty("user.name"));  
        System.out.println("用户的主目录:" + System.getProperty("user.home"));  
        System.out.println("用户的当前工作目录:" + System.getProperty("user.dir"));  
		String getUrl = "http://baijia.baidu.com/";
	//	System.out.println(doHttpJsonByBufferedReader( getUrl));
	//	 String[] cmd = new String[] { "cmd.exe", "/C", "wmic process get name" };
		//Process process =Runtime.getRuntime().exec(cmd);
	//	HashSet h =new HashSet(new ArrayList());
		//ToStringBuilder.reflectionToString(this);
		System.out.println("\ts\ns");
		 methodCallPath();
		 //printCalendar(2014);
		//printCalendar(2015);
		
	}
	
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
        return msg;
    }
	
	
	     
	    public static void methodCallPath(){
	        Throwable ex = new Throwable();
	        StackTraceElement[] stackElements = ex.getStackTrace();
	        if (stackElements != null) {
	            //此处将i >= 0 修改为 i > 0 可以打印除了本方法的所有其他的调用结构
	            for (int i = stackElements.length - 1; i >= 0; i--) {
	                System.out.print(stackElements[i].getClassName() + "\t");
	                System.out.print(stackElements[i].getMethodName() + "\t");
	                System.out.print(stackElements[i].getFileName() + "\t");
	                System.out.println(stackElements[i].getLineNumber());
	            }
	        }
	    }
	
	
	
	
	/**
	  * 根据给定的年份，打印出当年的日历
	  * @param year 给定年份
	  */
	 public static void printCalendar(int year){
	  // 数组第二参数的条件表示式是用于计算闰年和平年：闰年为29，平年为28
	  int[] months = { 31, ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	  // 泰勒公式计算元旦是星期几
	  int w = (year * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400) % 7;
	  
	  // 开始打印日历
	  for (int month = 1; month <= 12; month++) {
	   // 输出月份
	   System.out.print("\t\n" + month + "月:");
	 
	   // 输出星期
	   System.out.print("\t星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六\n\n");
	 
	   for (int day = 1; day <= months[month - 1]; day++) {
	    if (day == 1 && w != 0) {
	     for (int i = 0; i < w; i++) {
	      // 打印空格
	      System.out.print("\t");
	     }
	    }
	    
	    System.out.print("\t" + day);
	    
	    // 每行打印7个
	    w = (w + 1) % 7;
	    if (w == 0) {
	     System.out.print(" \n\n");
	    }
	   }
	    
	   // 每一月份，相隔3行高度。
	   System.out.print("\n\n\n");
	  }
	 }
	 
	
}

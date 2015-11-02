import java.io.File;


public class FileUrl
{
	   public static void main(String[] args) throws Exception {      

		   System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));     

		   System.out.println(FileUrl.class.getClassLoader().getResource(""));        
           StringBuilder builder =new StringBuilder();
           System.out.println(builder.reverse());
           StringBuilder value = builder.reverse();
           System.out.println(value.toString());
           System.out.println(builder.reverse().toString().replaceFirst("哈", "中"));
           System.out.println(value.toString());
           
		   System.out.println(ClassLoader.getSystemResource(""));        
		   System.out.println(FileUrl.class.getResource(""));        
		   System.out.println(FileUrl.class.getResource("/")); //Class文件所在路径  
		   System.out.println(new File("/").getAbsolutePath());        
		   System.out.println(System.getProperty("user.dir"));    //获取项目路径！
		 //String encoderContent = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString()+"product/"+product.getProductId()+".html";
		  }
	
}

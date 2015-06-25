import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
 

/**
 *  cmp命令执行工具类
 *  <code>CMD.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-6-12 上午11:22:24	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class CMD {
     
    public static Process CMD(String cmd){
        Process p = null;
        try {
            cmd = "cmd.exe /c "+cmd;
            System.out.println(cmd);
            p = Runtime.getRuntime().exec(cmd);
            new Thread(new cmdResult(p.getInputStream())).start();
            new Thread(new cmdResult(p.getErrorStream())).start();
            p.getOutputStream().close();
        } catch (Exception e) {
            System.out.println("命令行出错！");
            e.printStackTrace();
        }
        return p;
    }
     
    public static Process CMD(String cmd,String ...args){
        return CMD(String.format(cmd, args));
    }
     
    public static Process runCMD(String cmd){
        Process p = null;
        try {
            cmd = "cmd.exe /c start "+cmd;
            System.out.println(cmd);
            p = Runtime.getRuntime().exec(cmd);
            new Thread(new cmdResult(p.getInputStream())).start();
            new Thread(new cmdResult(p.getErrorStream())).start();
            p.getOutputStream().close();
        } catch (Exception e) {
            System.out.println("命令行出错！");
            e.printStackTrace();
        }
        return p;
    }
     
    public static Process runCMD(String cmd,String ...args){
        return runCMD(String.format(cmd, args));
    }
     
    static class cmdResult implements Runnable{
        private InputStream ins;
         
        public cmdResult(InputStream ins){
            this.ins = ins;
        }
 
        
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
                String line = null;
                while ((line=reader.readLine())!=null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         
    }
 
}
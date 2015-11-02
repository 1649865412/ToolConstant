package thread;


/**
 * java多线程打印
 *  <code>PrintABC.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-11-2 上午10:15:10	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class PrintABC
{
	    public static Boolean isThreadA = true;  
	    public static Boolean isThreadB = false;  
	    public static Boolean isThreadC = false;  
	  
	    public static void main(String[] args) {  
	        final PrintABC abc = new PrintABC();  
	        new Thread(new Runnable() {  
	            public void run() {  
	                for (int i = 0; i < 10; i++) {  
	                    synchronized (abc) {  
	                        while(!isThreadA) {  
	                            try {  
	                                abc.wait();  
	                            } catch (InterruptedException e) {  
	                                // TODO Auto-generated catch block  
	                                e.printStackTrace();  
	                            }  
	                        }  
	                            System.out.print("A");  
	                            isThreadA = false;  
	                            isThreadB = true;  
	                            isThreadC = false;  
	                            abc.notifyAll();  
	                    }  
	                }  
	            }  
	        }).start();  
	  
	        new Thread(new Runnable() {  
	            public void run() {  
	                for (int i = 0; i < 10; i++) {  
	                    synchronized (abc) {  
	                        while(!isThreadB) {  
	                            try {  
	                                abc.wait();  
	                            } catch (InterruptedException e) {  
	                                // TODO Auto-generated catch block  
	                                e.printStackTrace();  
	                            }  
	                        }  
	                            System.out.print("B");  
	                            isThreadA = false;  
	                            isThreadB = false;  
	                            isThreadC = true;  
	                            abc.notifyAll();  
	                    }  
	                }  
	            }  
	        }).start();  
	          
	        new Thread(new Runnable() {  
	            public void run() {  
	                for (int i = 0; i < 10; i++) {  
	                    synchronized (abc) {  
	                        while(!isThreadC) {  
	                            try {  
	                                abc.wait();  
	                            } catch (InterruptedException e) {  
	                                // TODO Auto-generated catch block  
	                                e.printStackTrace();  
	                            }  
	                        }  
	                            System.out.print("C");  
	                            isThreadA = true;  
	                            isThreadB = false;  
	                            isThreadC = false;  
	                            abc.notifyAll();  
	                    }  
	                }  
	            }  
	        }).start();  
	    }  
	}


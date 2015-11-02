package thread;


/**
 *  按0到100的顺序多线程打印 
 *  <code>PrintNumber.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-11-2 下午03:09:57	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class PrintNumber {  
    //state==1表示线程1开始打印，state==2表示线程2开始打印  
    private static int state = 1;  
      
    private static int num1 = 1;  
    private static int num2 = 2;  
    private static int sum =1000;
      
    public static void main(String[] args) {  
        final PrintNumber t = new PrintNumber();  
        new Thread(new Runnable() {  
            public void run() {  
                while(num1<sum){  
                    //两个线程都用t对象作为锁，保证每个交替期间只有一个线程在打印  
                    synchronized (t) {  
                        // 如果state!=1, 说明此时尚未轮到线程1打印, 线程1将调用t的wait()方法, 直到下次被唤醒  
                        if(state!=1){  
                            try {  
                                t.wait();  
                            } catch (InterruptedException e) {  
                                e.printStackTrace();  
                            }  
                        }  
                         // 当state=1时, 轮到线程1打印5次数字  
                    //    for(int j=0; j<5; j++){  
                            System.out.println("当前线程名字："+Thread.currentThread().getName()+num1);  
                            num1 += 2;  
                     //   }  
                        // 线程1打印完成后, 将state赋值为2, 表示接下来将轮到线程2打印  
                        state = 2;  
                        // notifyAll()方法唤醒在t上wait的线程2, 同时线程1将退出同步代码块, 释放t锁  
                        t.notifyAll();  
                    }  
                }  
            }  
        }).start();  
          
        new Thread(new Runnable() {  
            public void run() {  
                while(num2<=sum){  
                    synchronized (t) {  
                        if(state!=2){  
                            try {  
                                t.wait();  
                            } catch (InterruptedException e) {  
                                e.printStackTrace();  
                            }  
                        }  
                      //  for(int j=0; j<5; j++){  
                            System.out.println("当前线程名字："+Thread.currentThread().getName()+num2);  
                            num2 += 2;  
                       // }  
                        state = 1;  
                        t.notifyAll();  
                    }  
                }  
            }  
        }).start();  
    }  
  
}
package thread;


public class ExerciseThread
{
	 public static void main(String[] args)
	{ 
		A a=new ExerciseThread.A();
		B b=new ExerciseThread.B();
		a.start();
		b.start();
	}
	 
	 static class A extends Thread {
	    public void run(){
	    	int i =10;
	    	while(i <100){
	    		System.out.println("a");
	    	}
	    }	 
	 }
	 

	 static class B extends Thread {
		 public void run(){
			 int b = 10;
			 while(b <100){
				 System.out.println("B");
		    	}
		    	
		    }	 
	 }
}

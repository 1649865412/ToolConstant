package text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  <code>IteratorList.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author 杨荣忠 时间 2015-3-11 下午02:41:22	
 *  @version 1.0 
 *  </br>最后修改人 无
 */


public class IteratorList
{
	public static void main(String[] args) {
		  List list =new ArrayList();
		   int i=0;
		   while(i<=3)
		   {
			    list.add(i);
		     	  i++; 
		   }
		   Iterator  iterator = list.iterator();
		   while(iterator.hasNext())
		   {
			   System.out.print(iterator.next()+"\n");
		   }
	}
}



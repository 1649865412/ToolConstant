import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



/**
 *   比较器写法排序
 *  <code>ComparatorTest.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-6-10 上午10:48:08	
 *  @version 1.0 
 *  </br>最后修改人 无
 * @param <T>
 */
public class ComparatorTest<T> implements Comparator<T>
{
	
	/**功能:
	 * <p>作者 杨荣忠 2015-6-10 上午10:09:13
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		List list =new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		Collections.sort(list, new ComparatorTest());
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
		
	}
	
	public int compare(T o1, T o2)
	{
		// TODO Auto-generated method stub
		//<=0(从小到大)
		// >0(从大到小)
		return -1;
	}    
	
}

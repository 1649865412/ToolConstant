import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ListTool
{
	
	/**功能:
	 * <p>作者 杨荣忠 2015-9-7 下午02:15:11
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * 功能:list转set，注意重复的会被取消
	 * <p>作者 杨荣忠 2015-9-7 下午02:15:38
	 * @return 
	 */
	public  static<T> List<T> listToSet(Set<T>set){
	          return new ArrayList(set);	 
	}
	
	/**
	 * 功能:set转List 
	 * <p>作者 杨荣忠 2015-9-7 下午02:15:38
	 */
	public  static <T> Set<T> listToSet(List<T>list){
		  return new HashSet(list);
	}
	
	/**
	 * 功能:list 转 数组
	 * <p>作者 杨荣忠 2015-9-8 上午10:38:18
	 * @param list
	 * @return
	 */
	public static String[] ListToArray(List list){
		 String[]value =(String[]) list.toArray(new String[list.size()]);
		 return value;
	}
	
	/**
	 * 功能:数组转list
	 * <p>作者 杨荣忠 2015-9-8 上午10:40:18
	 * @param array
	 * @return
	 */
	public static List StringToList(String[]array){		
		List list = Arrays.asList(array);
		return list;
	}
	
	/**
	 * 功能:循环读取set数据
	 * <p>作者 杨荣忠 2015-9-8 上午10:40:53
	 */
	public void readSet(Set set){
		Iterator iteartor = set.iterator();
		while(iteartor.hasNext()){
			System.out.println(iteartor.next()+"/n");
		}
	}
	
	
	
	/**
	 * 功能:list转map
	 * <p>作者 杨荣忠 2015-9-8 上午10:58:34
	 * @return
	 */
	public Map  ListToMap(List list){
		Map<String,String> map =new HashMap();
		return map;
		
	}
}

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *  通过set生成不重复的随机数
 *  <code>RandomList.java</code>
 *  <p>
 *  <p>Copyright  2015 All right reserved.
 *  @author admin 时间 2015-9-29 上午10:00:54	
 *  @version 1.0 
 *  </br>最后修改人 无
 */
public class RandomList
{
	

	public static void main(String[] args) {

		int[] num = new int[100];

		for (int i = 0; i < 100; i++) {

		num[i] = i;

		}

		Integer[] result = getRandomNum(num, 10);

		System.out.println(Arrays.toString(result));

		}


	
	/**
	 * 功能:0到10这之间
	 * <p>作者 杨荣忠 2015-9-29 下午01:40:49
	 * @param num
	 * @param n
	 * @return
	 */
   public static Integer[] getRandomNum(int[] num, int n) {

		Set<Integer> sets = new HashSet<Integer>();

		Random random = new Random();

		while (sets.size() < n) {

		sets.add(random.nextInt(9));

		}

		return sets.toArray(new Integer[n]);

		}
}
   

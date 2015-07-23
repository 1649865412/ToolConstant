package baseClass.baseuse;

public class NumberGame {

	/** 1~scopeNumber个整数能组成几个互不相同且无重复的三位数 */
	public void threeNumber(int scopeNumber) {
		int n, count = 0;
		for (int i = 1; i <= scopeNumber; i++) {
			for (int j = 1; j <= scopeNumber; j++) {
				for (int k = 1; k <= scopeNumber; k++) {
					if (i != j && i != k && j != k) {
						n = 100 * i + 10 * j + k;
						System.out.print(n + "\t");
						count++;
					}
				}
			}
			System.out.print("\n");
		}
		System.out.println("总共有" + count + "个互不相同且无重复的三位数！");
	}

	/** 分解质因数, 例如60的质因数为2*2*3*5 = 60 */
	public void natureNumber(int number) {
		int n = number;// n变量为全局变量，存储number原始值，因number变量在运行时会改变
		for (int i = 2; i < n; i++) {
			if (number % i == 0)// 循环试验小于输入值的数，判断哪些会除得尽输入值
			{
				while (number % i == 0)// 循环判断除得尽输入值的数能否继续除尽所得的商
				{
					System.out.print(i + " ");
					number = number / i;
				}
			}
		}
	}

	/** 倒序输出0~任意数字之间的所有偶数序列 */
	public void evenNumber(int scopeNumber) {
		for (int i = scopeNumber / 2; i >= 0; i--) {// 充分利用"/"号特性
			System.out.print(2 * i + " ");
		}
	}

	/** 判断质数 */
	public void primeYesNo(int number) {
		boolean isPrime = true;
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			System.out.println("质数");
		}
	}

	/** 求startNumber-endNumber之内的质数 */
	public void primeNumber(int startNumber, int endNumber) {
		int k = 0;
		for (int n = startNumber; n <= endNumber; n++) {
			int i;
			for (i = 2; i < n; i++) {
				if (n % i == 0) {
					break;
				}
			}
			if (i == n) {// 捕捉当i==n时不符合i<n跳出内循环的i
				System.out.print(n + "\t");
				k++;
			}
			if (k % 10 == 0) {
				System.out.print("\n");
			}
		}
	}

	/** 求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字 */
	public void pyramidNumber(int number, int count) {// number使用的数a，count叠加层数,即加数个数
		int j = 1, x = 0, s = 0;
		System.out.print("s=");

		for (int i = 0; i < count - 1; i++) {
			j *= 10;
			x += number * j / 10;// x存储每个加数
			s += x;// 加数的和
			System.out.print(x + "+");
		}
		x += number * j;
		s += x;
		System.out.print(x + "");
		System.out.println("=" + s);
	}

	/** 打印出所有的“水仙花数”，所谓“水仙花数”是指一个三位数， 其各位数字立方和等于该数 */
	public void daffodilNumber() {
		int n;
		for (int i = 1; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					n = 100 * i + 10 * j + k;
					if (n == i * i * i + j * j * j + k * k * k) {
						System.out.print(n + "\t");
					}
				}
			}
		}
	}

	/** 从0开始到任意数范围内的奇数和 */
	public void oddSumNuber(int scopeNumber) {
		int sum = 0;
		if (scopeNumber % 2 == 0) {
			for (int i = 1; i < scopeNumber; i++) {// 最后一个偶数不算
				sum += i;
				i++;// 直接跳过奇数
			}
		} else {
			for (int i = 1; i <= scopeNumber; i++) {// 最后一个奇数要算
				sum += i;
				i++;
			}
		}
		System.out.println("" + sum);
	}

	/** 将一个整数翻转之后的值返回(正数，负数，0都得搞定)*/
	public void filpNumber(int number) {
		String str = number + "";
		char[] c = new char[str.length()];
		for (int i = 0; i < c.length; i++) {
			c[i] = str.charAt(i);
		}
		str = "";
		if (c[0] >= 48 && c[0] <= 57) {
			for (int i = c.length - 1; i >= 0; i--) {
				str += c[i];
			}
		} else {
			for (int i = c.length - 1; i > 0; i--) {
				str += c[i];
			}
			str = c[0] + str;
		}

		System.out.println(str);
	}

}

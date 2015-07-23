package baseClass.baseuse;

public class CharacterString {

	/** 分别统计出某个字符串中英文字母、数字和其它字符的个数 */
	public static void characterSum(String str) {
		// for循环的“全局变量”
		int charCount = 0;// 英文字母个数
		int numCount = 0;// 数字个数
		int otherCount = 0;// 其他字符个数
		char ch;// 用于存字符串中每个字符，可见本方法主要通过ASCII值进行条件判断
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);// 循环存储字符串中每个字符

			if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122))// 判断字符ch是否是英文字母
			{
				charCount++;// 是的话，进行累加
			} else if (ch >= 48 && ch <= 57)// 判断字符ch是否是数字
			{
				numCount++;
			} else {
				otherCount++;
			}
		}
		System.out.println("英文字母个数：" + charCount);
		System.out.println("数字个数：" + numCount);
		System.out.println("其他字符个数：" + otherCount);
	}

	/** 在给定的任意字符串中查找指定的小写字符，将其删掉，然后将删除后的字符串输出*/
	public void characterDelete(String str, String strDel) {
		char c = strDel.charAt(0);
		char[] ch = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			ch[i] = str.charAt(i);
		}
		int b = (int) c;
		int n = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			int a = (int) ch[i];
			if (a == b) {
				for (int j = i; j < str.length() - 1; j++) {
					ch[j] = ch[j + 1];
				}
				n++;
				i--;
			}
		}
		for (int i = 0; i < ch.length - n; i++) {
			System.out.print("" + ch[i]);
		}
	}

	/** 统计子字符串的个数 */
	public void stringSum(String str, String strSon) {
		// 如str="aajaaj" strSon="aa"
		int index = 0;
		int sum = 0;
		while (true) {
			index = str.indexOf(strSon, index);
			if (index < 0) {
				break;
			}
			index += 4;
			sum++;
		}
		System.out.println(strSon + "个数有：" + sum);
	}

	/** 分割字符串存储于二维数组 */
	public void twoDimension(String str, String strSign1, String strSign2) {
		// 如str="1,2,3!4,5,6,0!7,8,9" strSign1="!" strSign2=","
		String[] outer = str.split(strSign1);
		String[][] arr = new String[outer.length][];
		for (int i = 0; i < outer.length; i++) {
			String[] inner = outer[i].split(strSign2);
			arr[i] = inner;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
      public static void main(String[] args)
	{
    	  characterSum("杨85??荣忠12dsaf3xddddddabc");
	}
}

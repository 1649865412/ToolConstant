package baseClass.baseuse;

public class NetworkUse {

	/** 判断ip是否合法*/
	public static void isIP(String str) {
		String[] strs = str.split(".");
		int[] ip = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
		if (strs.length == 4) {
			for (int i = 0; i < strs.length; i++) {
				ip[i] = Integer.parseInt(strs[i]);
			}

			if (ip[0] != 0) {
				for (int i = 0; i < 4; i++) {
					if (ip[i] <= 255 && ip[i] >= 0) {
						System.out.println("YES");
						break;
					} else {
						System.out.println("NO");
					}
				}
			} else {
				System.out.println("NO");
			}
		} else {
			System.out.println("NO");
		}
	}
	
	public static void main(String[] args)
	{
		isIP("219.136.57.146");
	}
	
}

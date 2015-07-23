package baseClass.baseuse;

public class SystemSwitch {

	/** 十进制转换为二进制 */
	public void change10to2(int num10) {
		String y = "";
		while (num10 / 2 != 0) {
			y += num10 % 2 + " ";
			num10 /= 2;
		}
		y += num10 % 2 + "";
		String[] str = y.split(" ");
		for (int i = str.length - 1; i >= 0; i--) {
			System.out.print(str[i]);
		}
	}

/*	*//** 十进制转换为十六进制 *//*
	public void change10to16(int num10) {
		String num16 = "";
		String y = "";
		while (num10 / 16 != 0) {
			y += num10 % 16 + " ";
			num10 /= 16;
		}
		y += num10 % 16 + "";
		String[] str = y.split(" ");
		for (int i = str.length - 1; i >= 0; i--) {
			switch (str[i]) {
			case "10":
				str[i] = "A";
				break;
			case "11":
				str[i] = "B";
				break;
			case "12":
				str[i] = "C";
				break;
			case "13":
				str[i] = "D";
				break;
			case "14":
				str[i] = "E";
				break;
			case "15":
				str[i] = "F";
				break;
			default:
				break;
			}
			num16 += str[i].toLowerCase();
		}
		System.out.println("0x" + num16);
	}*/

	/** 八进制转换为十进制*/
	public int change8to10(int num8) {//注意num8的输入值要以0开头
		int sum10 = 0;
		int[] X = new int[(num8 + "").length()];
		int[] Y = new int[(num8 + "").length()];
		int x = 1;
		for (int i = 0; i < (num8 + "").length(); i++) {
			x = 8 * x;
			X[i] = x / 8;
		}
		for (int i = (num8 + "").length() - 1; i >= 0; i--) {
			Y[(num8 + "").length() - 1 - i] = Integer.parseInt((num8 + "")
					.charAt(i) + "");
		}
		for (int i = 0; i < X.length; i++) {
			sum10 += X[i] * Y[i];
		}
		return sum10;
	}

}

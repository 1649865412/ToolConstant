package baseClass.baseuse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Gather {

	/** 解析字符串信息*/
	public static void analysisString(String str, String signStr1, String signStr2,
			String signStr3) {
		// 如str="name:Tom,age:21!name:Jo,age:22" signStr1="!" signStr2="," signStr3=":"
		String[] outer = str.split(signStr1);
		List<HashMap<String, String>> l = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < outer.length; i++) {
			HashMap<String, String> m = new HashMap<String, String>();
			String[] mid = outer[i].split(signStr2);
			for (int j = 0; j < mid.length; j++) {
				String[] inner = mid[j].split(signStr3);
				m.put(inner[0], inner[1]);
			}
			l.add(m);
		}
		for (HashMap<String, String> m : l) {
			System.out.println(m.get("name") + " " + m.get("age"));
		}
	}
	
	public static void main(String[] args)
	{
		String str ="name:Tom,age:21!name:Jo,age:22";
		analysisString( str,  "!", ",",":");
	}

}

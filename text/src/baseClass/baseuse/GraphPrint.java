package baseClass.baseuse;

public class GraphPrint {

	/** 打印对角线 */
	public void diagonalLine(int length) {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i == j) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	/** 打印倒三角形 */
	public void triangleFall(int hight) {
		for (int i = hight - 1; i >= 0; i--) {
			for (int j = 0; j < hight - 1 - i; j++) {
				System.out.print(" ");
			}
			for (int j = hight - 1 - i; j <= hight - 1 + i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}

	/** 打印数字三角形 */
	public void triangleNumber(int hight) {
		for (int i = 1; i <= hight; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

	/** 打印平行四边形 */
	public void quadrangle(int hight) {
		for (int i = 0; i < hight; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j < 8 + i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}

	/** 打印实心金字塔 */
	public void pyramid(int hight) {
		for (int i = 1; i <= hight; i++) {
			// 找出规律
			// 1->3 2->2 3->1 4->0找出空格
			for (int k = 1; k <= hight - i; k++) {
				System.out.print(" ");
			}
			// 打印*
			// 1->1 2->3 3->5 4->7找出星的规律
			for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
				System.out.print("*");
			}
			System.out.println();// 换行
		}
	}

	/** 打印镂空金字塔 */
	public void pyramidNull(int hight) {
		for (int i = 1; i <= hight; i++) {
			// 找出规律
			// 1->3 2->2 3->1 4->0找出空格
			for (int k = 1; k <= hight - i; k++) {
				System.out.print(" ");
			}
			// 打印*
			// 1->1 2->3 3->5 4->7找出星的规律
			for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
				// 判断该层是否是顶层或者是底层
				if (i == 1 || i == hight) {
					System.out.print("*");
				} else {
					// 如果是第一个*
					if (j == 1 || j == (i - 1) * 2 + 1) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();// 换行
		}
	}

	/** 打印实心菱形 */
	public void diamond(int hight) {// hight上半部分行数
		for (int i = 1; i <= hight - 1; i++) { // 判断循环上半部分
			for (int k = 1; k <= hight - i; k++) { // 找行内*号前输出空格
				System.out.print(" ");
			}
			for (int j = 1; j <= (i - 1) * 2 + 1; j++) { // 找行内输出星的位置
				System.out.print("*");
			}
			System.out.println(); // 换行
		}
		for (int i = 1; i <= hight; i++) { // 判断循环菱形下半部分
			for (int k = 1; k <= i - 1; k++) { // 判断循环找*号前要输出空格处
				System.out.print(" ");
			}
			for (int j = 1; j <= (hight - i) * 2 + 1; j++) { // 判断循环行长度
				System.out.print("*");
			}
			System.out.println();// 输出换行
		}
	}

	/** 打印镂空菱形 */
	public void diamondNull(int hight) {
		for (int i = 1; i <= hight - 1; i++) { // 判断循环上半部分
			for (int k = 1; k <= hight - i; k++) { // 找行内*号前输出空格
				System.out.print(" ");
			}
			for (int j = 1; j <= (i - 1) * 2 + 1; j++) { // 找行内输出星的位置
				if (j == 1 || j == (i - 1) * 2 + 1) { // 判断行最小长度和最大长度，并在最小长度和最大长度上输出*号，行内输入出空格。
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println(); // 换行
		}
		for (int i = 1; i <= hight; i++) { // 判断循环菱形下半部分
			for (int k = 1; k <= i - 1; k++) { // 判断循环找*号前要输出空格处
				System.out.print(" ");
			}
			for (int j = 1; j <= (hight - i) * 2 + 1; j++) { // 判断循环行长度
				if (j == 1 || j == (hight - i) * 2 + 1) { // 判断行最小长度和最大长度，并在最小长度和最大长度上输出*号，行内输入出空格。
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();// 输出换行
		}
	}

	/** 打印九九乘法表 */
	public void nineNineWatch() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + (i * j) + "\t");// “\t”用于对齐输出字段
			}
			System.out.println("");
		}
	}

	/** 打印杨辉三角*/
	public void triangleYangHui(int hight) {
		int[][] a = new int[hight][hight];
		if (hight == 1) {
			a[0][0] = 1;
		} else {
			a[0][0] = a[1][0] = a[1][1] = 1;

			for (int i = 2; i < hight; i++) {
				for (int j = 1; j <= i; j++) {
					a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
					a[i][0] = a[j][i] = 1;
				}
			}
		}
		for (int i = 0; i < hight; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

}

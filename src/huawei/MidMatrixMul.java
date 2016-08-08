package huawei;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * http://www.nowcoder.com/questionTerminal/15e41630514445719a942e004edc0a5b
 * 矩阵乘法的运算量与矩阵乘法的顺序强相关。 例如： A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
 * 计算A*B*C有两种顺序：（（AB）C）或者（A（BC）），前者需要计算15000次乘法，后者只需要3500次。
 * 编写程序计算不同的计算顺序需要进行的乘法次数
 * 
 * 运行时间限制 10M 内存限制 128 输入 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则 3
 * //矩阵个数n 50 10 //矩阵A的行数50，列数10 10 20 //矩阵B的行数10，列数20 20 5 //矩阵C的行数20，列数5
 * (A(BC)) //矩阵从A开始命名，A、B、C、D...以此类推，通过括号表示运算顺序
 * 
 * 输出 输出需要进行的乘法次数 样例输入 3 50 10 10 20 20 5 (A(BC)) 样例输出 3500
 * 
 * @author han
 *
 */
public class MidMatrixMul {

	static class Point {
		public int row;// 行
		public int col;// 列

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}

	public static int getMul(int n, Point[] points, String str) {
		int sum = 0;
		char[] ch = str.toCharArray();
		int len = ch.length;
		Stack<Point> pointStack = new Stack<>();
		Point a, b;
		int j = 0;
		for (int i = 0; i < len; i++) {
			if (ch[i] == ')' && pointStack.size() > 1) {// 遇到反括号出栈
				a = pointStack.pop();// 获取栈顶元素,并使栈顶元素出栈
				b = pointStack.pop();
				sum += b.row * b.col * a.col;// b是前面的数字,b*a => b的行×b的列×a的列
				b.col = a.col;
				pointStack.push(b);
			}

			if (Character.isAlphabetic(ch[i])) {// 是字母
				pointStack.push(points[j++]);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			Point[] points = new Point[n];
			for (int i = 0; i < n; i++) {
				points[i] = new Point(scanner.nextInt(), scanner.nextInt());
			}
			String str = scanner.next();
			System.out.println(getMul(n, points, str));
		}
		scanner.close();
	}

}

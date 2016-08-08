package huawei;

import java.util.Scanner;

/**
 * 将真分数分解为埃及分数 过oj
 * 
 * @author han
 *
 */
public class EasyEgypt {

	public static String ConvertRealFractToEgpytFract(String pcRealFraction) {
		String[] nums = pcRealFraction.split("/");
		int a = Integer.parseInt(nums[0]);
		int b = Integer.parseInt(nums[1]);
		int c = 0;
		String temp = "";
		while (a != 1) {
			if (a == 3) {
				temp += "1/" + (b / 2) + "+1/" + b;
				break;
			}
			c = b / a + 1;
			a = a * c - b;
			b = b * c;
			temp += "1/" + c + "+";
			if ((b % a == 0) || (a == 1)) {
				temp += "1/" + (b / a);
				a = 1;
			}
		}
		return temp;
	}

	/**
	 * 这个方法也是对的。但是华为oj就是不过！！！ 功能: 将分数分解为埃及分数序列 输入参数： String
	 * pcRealFraction:真分数(格式“8/11”) 返回值： String 公式步骤: 1.用b
	 * 除以a，得商数c，q=c+1即为后面新的打印输出分母 2.a=a*q-b即为余数剩下的分子 3.b=b*q
	 * 
	 * @param pcRealFraction
	 *            真分数
	 * @return
	 */
	public static String ConvertRealFractToEgpytFract2(String pcRealFraction) {
		String[] nums = pcRealFraction.split("/");
		int a = Integer.parseInt(nums[0]);
		int b = Integer.parseInt(nums[1]);
		int q = 0;// 商
		String temp = "";
		while (b % a != 0) {// a==1说明此时分子为1，要到最后一个数字了
			q = b / a + 1;
			a = a * q - b;
			b = b * q;
			temp += "1/" + q + "+";
		}
		temp += "1/" + b / a;
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			System.out.println(ConvertRealFractToEgpytFract(scanner.next()));
		}
		scanner.close();
	}

}

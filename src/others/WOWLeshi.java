package others;
/**
 * 在最近几场魔兽争霸赛中，赫柏对自己的表现都不满意。
 * 为了尽快提升战力，赫柏来到了雷鸣交易行并找到了幻兽师格丽，打算让格丽为自己的七阶幻兽升星。
 * 经过漫长的等待以后，幻兽顺利升到了满星，赫柏很满意，打算给格丽一些小费。
 * 赫柏给小费是有原则的：
 * 1.最终给格丽的钱必须是5的倍数；
 * 2.小费必须占最终支付费用的5%~10%之间（包含边界）。
 * 升星总共耗费A魔卡，赫柏身上带了B魔卡，赫柏想知道他有多少种支付方案可供选择。
 * 注：魔卡是一种货币单位，最终支付费用=本该支付的+小费
 * 
 * 输入描述:
 * 多组测试数据，请处理到文件结束。
 * 
 * 对于每组测试数据：
 * 
 * 包含两个整数A和B。
 * 
 * 保证：
 * 
 * 1<=A,B<=2,000,000,000，A<=B。
 * 
 * 输出描述:
 * 输出一个整数，代表方案数。
 * 
 * 输入例子:
 * 4 100
 * 23 100
 * 
 * 输出例子:
 * 0
 * 1
 */
import java.io.BufferedInputStream;
import java.util.Scanner;

public class WOWLeshi {

	static Scanner scanner;

	static int getCount(int a, int b) {
		int result = 0;
		int min = (int) Math.ceil(a / 0.95);// 升星最小付款（含小费）
		int max = (int) Math.floor(a / 0.9);// 升星最大付款（含小费
		if (min <= b) {
			if (max > b) {
				result = b / 5 - min / 5;
			} else {
				result = max / 5 - min / 5;
			}
			if(min%5==0){
				result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scanner = new Scanner(new BufferedInputStream(System.in));
		while (scanner.hasNext()) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			System.out.println(getCount(a, b));
		}
	}

}

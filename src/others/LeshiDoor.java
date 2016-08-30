package others;

/**
 * http://www.nowcoder.com/questionTerminal/15a0754021c342568c7487b43016ee9a
 * 绝域之门
 * 经过多次强攻之后，赫柏带领的军团不仅没能击败鲁卡斯，反而被鲁卡斯打得七零八落，赫柏终于体会到了高阶天之驱逐者的强大实力。
 * 不过，赫柏最终还是找到了鲁卡斯的致命弱点，他发现鲁卡斯喜欢收集上古卷轴，因为上古卷轴能够让鲁卡斯获得神秘之力。
 * 卢卡斯决定使用上古卷轴将卢卡斯引诱到绝域之门，利用绝域之门的力量消灭卢卡斯。
 * 赫柏注意到卢卡斯喜欢收集不同的卷轴，如果总是捡到相同的上古卷轴，它的兴趣就会逐渐降低。
 * 赫柏现在拥有N种不同的卷轴，每种卷轴有Ai个。现在他要将这N个卷轴分散在鲁卡斯领地到绝域之门的路上，每一种排列方式都有一个吸引值Charm，吸引值越高，鲁卡斯被引诱到绝域之门的概率越高。
 * Charm=Sum of all D(i)，其中D(i)=k-i，i为该排列中卷轴i的下标，k为位于i后面且和i是同一种卷轴的卷轴下标。
 * 现在所有的卷轴以<卷轴名称 数量>的格式给出，你需要输出所有卷轴的排列顺序，使得吸引值最大，如果有多种排列方式满足条件，输出按照名字排列字典序最小的一个。
 * 
 *  输入描述:
 * 多组测试数据，请处理到文件结束。
 * 对于每组测试数据：
 * 第一行：一个整数N，代表有N种卷轴。
 * 第二行：N种卷轴的描述。
 *
 * 保证：
 * 0<=N<=50;
 * 卷轴名称为长度1~10的字母，每种卷轴的数量为1~800之间的一个整数。
 * 
 * 输出描述:
 * 输出所有卷轴的一个排列。
 * 
 * 输入例子:
 * 3
 * Thunder 1 Wind 3 Soil 2
 * 
 * 输出例子:
 * Soil Wind Thunder Wind Soil Wind
 */
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class LeshiDoor {

	private static Scanner scanner;
	static Comparator<Map.Entry<String, Integer>> cmp = new Comparator<Map.Entry<String, Integer>>() {// 字典序排序Comparator
		@Override
		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			// TODO Auto-generated method stub
			return o1.getKey().compareTo(o2.getKey());
		}
	};

	private static String getResult(ArrayList<Map.Entry<String, Integer>> list, int n) {
		Collections.sort(list, cmp);// 将字符串按照字典序排序
		String f = "";// 起始
		String mid = "";// 中间
		String l = "";// 结尾
		for (int i = 0; i < n; i++) {
			if (list.get(i).getValue() > 1) {
				f = f + list.get(i).getKey() + " ";
				l = l + list.get(i).getKey() + " ";
				list.get(i).setValue(list.get(i).getValue() - 2);
			}
		}
		for (int i = 0; i < n; i++) {
			while (list.get(i).getValue() > 0) {
				mid = mid + list.get(i).getKey() + " ";
				list.get(i).setValue(list.get(i).getValue() - 1);
			}
		}
		String res = f + mid + l;
		return res.trim();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
			int n = scanner.nextInt();
			for (int i = 0; i < n; i++) {
				String str = scanner.next();
				int num = scanner.nextInt();
				Map.Entry<String, Integer> pair = new AbstractMap.SimpleEntry<String, Integer>(str, num);
				list.add(pair);
			}
			System.out.println(getResult(list, n));
		}
		scanner.close();
	}

}

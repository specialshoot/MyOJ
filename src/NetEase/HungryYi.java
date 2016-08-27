package NetEase;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * 小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。 最开始小易在一个初始位置x_0。 对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 *
 * x + 3或者8 * x + 7。 因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。
 * 贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。
 * 小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。
 * 
 * @author han
 *
 */
public class HungryYi {

	public static int getNum(long x) {
		Map<Long, Integer> map = new HashMap<>();
		Queue<Long> queue = new LinkedList<>();
		queue.offer(x);
		map.put(x, 0);
		long num = 0;
		while (!queue.isEmpty()) {
			num = queue.poll();
			if (num == 0) {
				return map.get(num);
			}
			if (map.get(num) > 100000) {
				continue;
			}
			long xx = (num * 4 + 3) % 1000000007;// 这边用个变量存下面不用总计算,否则耗时大过不了
			if (!map.containsKey(xx)) {
				map.put(xx, map.get(num) + 1);
				queue.offer(xx);
			}
			xx = (num * 8 + 7) % 1000000007;
			if (!map.containsKey(xx)) {
				map.put(xx, map.get(num) + 1);
				queue.offer(xx);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			long x = scanner.nextLong();
			System.out.println(getNum(x));
		}
		scanner.close();
	}

}

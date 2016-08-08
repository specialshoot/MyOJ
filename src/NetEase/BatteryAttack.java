package NetEase;

import java.util.Scanner;

/**
 * 黑默丁格有三个炮台,炮台能攻击到距离它R的敌人 (两点之间的距离为两点连续的距离,例如(3,0),(0,4)之间的距离是5), 如果一个炮台能攻击
 * 到敌人,那么就会对敌人造成1×的伤害. 黑默丁格将三个炮台放在N*M方格中的点上,并且给出敌人 的坐标. 问:那么敌人受到伤害会是多大?
 * 
 * 输入描述: 一行9个整数,R,x1,y1,x2,y2,x3,y3,x0,y0.R代表炮台攻击的最大距离,(x1,y1),(x2,y2),
 * (x3,y3)代表三个炮台的坐标.(x0,y0)代表敌人的坐标.
 * 
 * 输出描述: 输出一行,这一行代表敌人承受的最大伤害,(如果每个炮台都不能攻击到敌人,输出0×)
 * 
 * 输入例子: 1 1 1 2 2 3 3 1 2
 * 
 * 输出例子: 2x
 */
public class BatteryAttack {

	public static class BatteryPosition {
		public int x;
		public int y;

		public BatteryPosition(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static boolean canAttack(BatteryPosition p, BatteryPosition enemy, int R) {
		int distance = (p.x - enemy.x) * (p.x - enemy.x) + (p.y - enemy.y) * (p.y - enemy.y);
		if (distance <= R * R) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int R = scanner.nextInt();
			int count = 0;
			BatteryPosition position1 = new BatteryPosition(scanner.nextInt(), scanner.nextInt());
			BatteryPosition position2 = new BatteryPosition(scanner.nextInt(), scanner.nextInt());
			BatteryPosition position3 = new BatteryPosition(scanner.nextInt(), scanner.nextInt());
			BatteryPosition enemy = new BatteryPosition(scanner.nextInt(), scanner.nextInt());
			if (canAttack(position1, enemy, R)) {
				count++;
			}
			if (canAttack(position2, enemy, R)) {
				count++;
			}
			if (canAttack(position3, enemy, R)) {
				count++;
			}
			System.out.println(count + "x");
		}
		scanner.close();
	}

}

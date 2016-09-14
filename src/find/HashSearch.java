package find;

/**
 * 散列查找(散列表)
 * 
 * @author han
 *
 */
public class HashSearch {

	/**
	 * 从hashTable中查找数字a
	 * 
	 * @param a
	 *            要查找的数字
	 * @param len
	 *            hashTable表长度
	 * @param ht
	 *            存在的哈希表
	 * @return
	 */
	private static boolean searchHash(int a, int len, int[] ht) {
		int addr = Hash(a, len);
		while (ht[addr] != a) {
			addr = (addr + 1) % len;
			if (ht[addr] == 0 || addr == Hash(a, len)) {
				return false;
			}
		}
		System.out.println(addr);// a在散列表中最终的位置
		return true;
	}

	/**
	 * hashTable插入
	 * 
	 * @param hashTable
	 * @param a
	 */
	private static void InsertHash(int[] hashTable, int a) {
		int len = hashTable.length;
		int addr = Hash(a, len);
		while (hashTable[addr] != 0) {// 已经有其它数字占了这个坑
			addr = (addr + 1) % len;// 看下一个坑有没有人占
		}
		hashTable[addr] = a;// 放入坑中
	}

	private static int Hash(int a, int len) {
		return a % len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[] { 1, 2, 29, 3, 95, 3, 5, 6, 7, 9, 12 };
		int[] hashTable = new int[test.length * 2 + 1];// 保证长度为原数组长度2倍+1
		for (int num : test) {
			InsertHash(hashTable, num);
		}
		System.out.println(searchHash(45, hashTable.length, hashTable));
	}

}

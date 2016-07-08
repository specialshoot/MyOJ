package others;

public class AllRange {

	private static int count = 0;// 计数

	private static void range(int[] nums, int k, int m) {
		if (k == m) {
			System.out.print("第" + (++count) + "种排列 -> ");
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println("");
		} else {
			for (int i = k; i <= m; i++) {
				if (isSwap(nums, k, i)) {
					Swap(nums, k, i);
					range(nums, k + 1, m);
					Swap(nums, k, i);
				}
			}
		}
	}

	private static boolean isSwap(int[] nums, int begin, int end) {
		for (int i = begin; i < end; i++) {
			if (nums[i] == nums[end]) {
				return false;
			}
		}
		return true;
	}

	private static void Swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 1 };
		range(nums, 0, nums.length - 1);
	}

}

package leetcode;

public class MedianOfTwoSortedArrays {
	// Hard!!!
	// https://leetcode.com/problems/median-of-two-sorted-arrays/
	// http://blog.csdn.net/yutianzuijin/article/details/11499917/
	public double findKth(int a[], int startA, int m, int b[], int startB, int n, int k) {
		if (m > n)
			return findKth(b, startB, n, a, startA, m, k);

		if (m == 0)
			return b[startB + k - 1];

		if (k == 1)
			return min(a[startA], b[startB]);

		int pa = min(k / 2, m), pb = k - pa;

		if (a[startA + pa - 1] < b[startB + pb - 1])
			return findKth(a, startA + pa, m - pa, b, startB, n, k - pa);
		else
			return findKth(a, startA, m, b, startB + pb, n - pb, k - pb);
	}

	private int min(int a, int b) {
		return a > b ? b : a;
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// TODO Auto-generated constructor stub
		int m = nums1.length;
		int n = nums2.length;

		int total = m + n;

		if ((total & 1) == 1)
			return findKth(nums1, 0, m, nums2, 0, n, total / 2 + 1);
		else
			return (findKth(nums1, 0, m, nums2, 0, n, total / 2) + findKth(nums1, 0, m, nums2, 0, n, total / 2 + 1))
					/ 2;
	}

	public static void main(String agrs[]) {

	}
}

package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 整型数组合并
 * @author han
 *
 */
public class EasyCombine {

	public static String CombineBySort(int[] array1, int[] array2) {
		Arrays.sort(array1);
		Arrays.sort(array2);
		int len1 = array1.length;
		int len2 = array2.length;
		int[] res = new int[len1 + len2];
		int ap = 0, bp = 0, cp = 0;
		while (ap < len1 && bp < len2) {
			if (array1[ap] < array2[bp]) {
				res[cp] = array1[ap];
				ap++;
			} else if (array1[ap] > array2[bp]) {
				res[cp] = array2[bp];
				bp++;
			} else {
				res[cp] = array1[ap];
				ap++;
				bp++;
			}
			cp++;
		}

		for (int i = ap; i < array1.length; i++) {
			if (array1[i] != res[cp - 1]) {
				res[cp] = array1[i];
				cp++;
			}
		}

		for (int i = bp; i < array2.length; i++) {
			if (array2[i] != res[cp - 1]) {
				res[cp] = array2[i];
				cp++;
			}
		}
		StringBuilder builder = new StringBuilder(cp);
		if (res.length != 0) {
			builder.append(res[0]);
		}
		for (int i = 1; i < cp; i++) {
			if (res[i] == res[i - 1]) {
				continue;
			}
			builder.append(res[i]);
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int m = scanner.nextInt();
			int[] array1 = new int[m];
			for (int i = 0; i < m; i++) {
				array1[i] = scanner.nextInt();
			}

			int n = scanner.nextInt();
			int[] array2 = new int[n];
			for (int i = 0; i < n; i++) {
				array2[i] = scanner.nextInt();
			}
			System.out.println(CombineBySort(array1, array2));
		}
		scanner.close();
	}

}

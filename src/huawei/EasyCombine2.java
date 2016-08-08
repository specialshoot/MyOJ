package huawei;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class EasyCombine2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			Set<Integer> set=new TreeSet<>();
			int m = scanner.nextInt();
			for (int i = 0; i < m; i++) {
				set.add(scanner.nextInt());
			}

			int n = scanner.nextInt();
			for (int i = 0; i < n; i++) {
				set.add(scanner.nextInt());
			}
			for (Integer i : set) {
                System.out.print(i);
            }
		}
		scanner.close();
	}

}

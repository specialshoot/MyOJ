package offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DiDiDinner {

	public static class Person {
		public int num;
		public int value;

		public Person(int num, int value) {
			super();
			this.num = num;
			this.value = value;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[] desk = new int[n];
			for (int i = 0; i < n; i++) {
				desk[i] = scanner.nextInt();
			}
			Arrays.sort(desk);
			Person[] persons = new Person[m];
			for (int i = 0; i < m; ++i) {
				int num = scanner.nextInt();
				int value = scanner.nextInt();
				persons[i] = new Person(num, value);
			}
			Arrays.sort(persons, new Comparator<Person>() {

				@Override
				public int compare(Person o1, Person o2) {
					// TODO Auto-generated method stub
					return o1.value < o2.value ? 1 : -1;
				}
			});

			int maxValue = 0;
			int[] markVec = new int[n];
			for (int i = 0; i < m; ++i) {
				Person g = persons[i];
				int num = g.num;

				for (int j = 0; j < n; ++j) {
					if (markVec[j] == 0 && desk[j] >= num) {
						maxValue += g.value;
						markVec[j] = 1;
						break;
					}
				}
			}
			System.out.println(maxValue);
		}
		scanner.close();
	}

}

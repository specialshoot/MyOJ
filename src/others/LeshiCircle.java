package others;

/**
 * http://www.nowcoder.com/question/next?pid=1868636&qid=45167&tid=3843565
 */
import java.io.BufferedInputStream;
import java.util.Scanner;

public class LeshiCircle {

	static Scanner scanner;

	static int getCount(int S) {
		int result = 0;
		for (int i = 0; i * i < S; i++) {
			int j = S - i * i;
			int s = (int) Math.sqrt(j);
			if (Math.pow(s, 2) == j) {
				result++;
			}
		}
		return 4 * result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scanner = new Scanner(new BufferedInputStream(System.in));
		while (scanner.hasNext()) {
			int num = scanner.nextInt();
			System.out.println(getCount(num) + "");
		}

	}

}

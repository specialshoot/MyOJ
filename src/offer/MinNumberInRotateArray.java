package offer;

/**
 * 旋转数组最小值
 * 
 * @author han
 *
 */
public class MinNumberInRotateArray {

	public static int minNumberInRotateArray(int[] array) {
		int result = 0;
		int count = array.length;
		if (count == 1) {
			result = 0;
		}
		for (int i = 0; i < count - 1; i++) {
			if (array[i + 1] < array[i]) {
				result = array[i + 1];
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

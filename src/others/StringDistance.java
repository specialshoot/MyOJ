package others;

public class StringDistance {

	public int[][] memoizedDistance;// 记录子问题的解,0表示子问题未求解

	private int minValue(int a, int b, int c) {
		return a < b ? (a < c ? a : c) : (b < c ? b : c);
	}

	private double distanceInit(String strA, String strB) {
		int distance = -1;
		if (strA != null && strB != null) {
			int lengthA = strA.length();
			int lengthB = strB.length();
			if (lengthA == 0 && lengthB == 0) {
				return 0;
			}
			if (lengthA == 0 && lengthB != 0) {
				return lengthB;
			}

			if (lengthB == 0 && lengthA != 0) {
				return lengthA;
			}

			memoizedDistance = new int[lengthA+1][lengthB+1];
			for(int i=0;i<=lengthA;i++){
				for(int j=0;j<=lengthB;j++){
					memoizedDistance[i][j]=-1;
				}
			}
			distance=calculateStringDistance(strA, 0, lengthA-1, strB, 0, lengthB-1);
		}
		return 1.0/(distance+1);
	}

	private int calculateStringDistance(String strA, int pABegin, int pAEnd, String strB, int pBBegin, int pBEnd) {

		if (memoizedDistance[pABegin][pBBegin] >= 0) {
			return memoizedDistance[pABegin][pBBegin];
		}
		if (pABegin > pAEnd) {
			if (pBBegin > pBEnd) {
				memoizedDistance[pABegin][pBBegin] = 0;
				return 0;
			} else {
				int temp = pBEnd - pBBegin + 1;
				memoizedDistance[pABegin][pBBegin] = temp;
				return temp;
			}
		}
		if (pBBegin > pBEnd) {
			if (pABegin > pAEnd) {
				memoizedDistance[pABegin][pBBegin] = 0;
				return 0;
			} else {
				int temp = pAEnd - pABegin + 1;
				memoizedDistance[pABegin][pBBegin] = temp;
				return temp;
			}
		}

		if (strA.substring(pABegin, pABegin + 1).equals(strB.substring(pBBegin, pBBegin + 1))) {
			int temp = calculateStringDistance(strA, pABegin + 1, pAEnd, strB, pBBegin + 1, pBEnd);
			memoizedDistance[pABegin][pBBegin] = temp;
			return temp;
		} else {

			int t1 = calculateStringDistance(strA, pABegin + 1, pAEnd, strB, pBBegin, pBEnd);
			int t2 = calculateStringDistance(strA, pABegin, pAEnd, strB, pBBegin + 1, pBEnd);
			int t3 = calculateStringDistance(strA, pABegin + 1, pAEnd, strB, pBBegin + 1, pBEnd);
			
			int temp=minValue(t1, t2, t3)+1;
			memoizedDistance[pABegin][pABegin]=temp;
			return temp;
		}
	}

	public static void main(String[] args) {
		StringDistance distance = new StringDistance();
		// TODO Auto-generated method stub
		System.out.println(distance.distanceInit("abcdfef", "bcf"));
	}

}

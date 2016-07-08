package others;

/*
 * 线段树入门
 * http://bylijinnan.iteye.com/blog/1762878
 * http://blog.csdn.net/libin56842/article/details/8530197
 * 提高
 * http://bylijinnan.iteye.com/blog/1762882
 */
public class SegmentTreeLearn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SegmentTree tree = new SegmentTree(0, 7);  
        int[][] segments = {  
                {2, 5},   
                {4, 6},   
                {0, 7}  
        };  
        int[] targets = {2, 4, 7};
        for (int i = 0, len = segments.length; i < len; i++) {  
            int[] segment = segments[i];
            tree.insert(segment[0], segment[1]);  
        }  
        for(int target : targets) {  
            System.out.println(target + ":" + tree.caculateExistingTimes(target));  
        }  
	}
}

package offer;

import java.util.ArrayList;

/**
 * 重建二叉树，根据二叉树前序和中序遍历结果，重建二叉树
 */
import others.TreeNode;

public class ReConstructBinaryTree {

	/**
	 * 
	 * @param pre 先序遍历
	 * @param in 中序遍历
	 * @return
	 */
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        int i=0;
        if(pre.length!=in.length||pre.length==0||in.length==0)
            return null;
        TreeNode root = new TreeNode(pre[0]);//先序遍历第一个元素为根节点
        while(in[i]!=root.val){//找到中序遍历的根节点
            i++;
        }
        int[] preLeft = new int[i];
        int[] inLeft = new int[i];
        int[] preRight = new int[pre.length-i-1];
        int[] inRight = new int[in.length-i-1];
        for(int j = 0;j<in.length;j++) {
            if(j<i) {
                preLeft[j] = pre[j+1];
                inLeft[j] = in[j];
            } else if(j>i) {
                preRight[j-i-1] = pre[j];
                inRight[j-i-1] = in[j];
            }
        }
        root.left = reConstructBinaryTree(preLeft,inLeft);
        root.right = reConstructBinaryTree(preRight,inRight);
        return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

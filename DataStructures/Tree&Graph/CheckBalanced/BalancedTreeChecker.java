import java.io.*;
import java.util.*;
import java.lang.Math.*;

public class BalancedTreeChecker	{
	public static void main(String[] args)	{
		System.out.println("Start");
		int[] arr = new int[15];
		for(int i = 0; i<15; i++)	{
			arr[i] = i;
			System.out.print(i + " ");
		}
		TreeNode root = createMinimalBST(arr, 0, arr.length - 1);
		System.out.println("Root : " + root.value);
		if(isBalanced(root))
			System.out.println("\nAnswer : True");
		else
			System.out.println("\nAnswer : False");

	}

	static int maxHeight(TreeNode node)	{
		if(node == null)
			return 0;

		return 1 + Math.max(maxHeight(node.left), maxHeight(node.right));
	}

	static boolean isBalanced(TreeNode node)	{
		if(node == null)
			return true;

		if(isBalanced(node.left) && isBalanced(node.right))	{
			int maxLeftHeight = maxHeight(node.left);
			int maxRightHeight = maxHeight(node.right);
			return Math.abs(maxLeftHeight - maxRightHeight) <= 1;
		}

		return false;
	}

	static TreeNode createMinimalBST(int[] arr, int left, int right)	{
		if(left > right)
			return null;
		int mid = (left + right)/2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = createMinimalBST(arr, left, mid - 1);
		node.right = createMinimalBST(arr, mid + 1, right);
		return node;
	}

}

class TreeNode	{
	int value;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val)	{
		value = val;
	}
}
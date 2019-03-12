import java.io.*;
import java.util.*;
class ArrayToBST	{
	static ArrayList<String> resultSorted;
	public static void main(String[] args)	{
		System.out.println("Start");
		int[] array = new int[10];
		for(int i = 0; i<10; i++)	{
			array[i] = i;
			System.out.print(""+i);
		}
		System.out.println();
		TreeNode root = createMinimalBST(array, 0, array.length - 1);
		System.out.println("Root val : " + root.value);
		resultSorted = new ArrayList<String>();
		inorderTraversal(root);
		System.out.println("Re sorted array of BST : " + Arrays.toString(resultSorted.toArray()));

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

	static void inorderTraversal(TreeNode node)	{
		if(node == null)
			return;

		inorderTraversal(node.left);
		resultSorted.add(Integer.toString(node.value));
		inorderTraversal(node.right);
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
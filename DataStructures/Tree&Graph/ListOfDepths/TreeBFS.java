import java.io.*;
import java.util.*;
public class TreeBFS	{
	static ArrayList<ArrayList<Integer>> levelOrderTraversal;
	public static void main(String[] args)	{
		System.out.println("Start");
		int[] array = new int[10];
		for(int i = 0; i<10; i++)	{
			array[i] = i;
			System.out.print(""+i);
		}
		System.out.println();
		levelOrderTraversal = new ArrayList<>();
		TreeNode root = createMinimalBST(array, 0, array.length - 1);
		bfs(root);
		System.out.println("BFS traversal of Tree : " + Arrays.toString(levelOrderTraversal.toArray()));

	}

	public static TreeNode createMinimalBST(int[] arr, int left, int right)	{
		if(left > right)
			return null;
		int mid = (left + right)/2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = createMinimalBST(arr, left, mid - 1);
		node.right = createMinimalBST(arr, mid + 1, right);
		return node;
	}


	public static void bfs(TreeNode node)	{
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> levelNodes = new ArrayList<Integer>();

		queue.add(node);
		levelNodes.add(node.value);
		levelOrderTraversal.add(levelNodes);
		while(!queue.isEmpty())	{
			int levelSize = levelNodes.size();
			levelNodes = new ArrayList<Integer>();
			for(int i = 0; i<levelSize; i++)	{
				TreeNode temp = queue.poll();
				
				if(temp.left != null)	{
					queue.add(temp.left);
					levelNodes.add(temp.left.value);
				}
				else
					System.out.println("Left child of " + temp.value + " is null");
				if(temp.right != null)	{
					queue.add(temp.right);
					levelNodes.add(temp.right.value);
				}
				else
					System.out.println("Right child of " + temp.value + " is null");
			}
			if(levelNodes.size()>0)
				levelOrderTraversal.add(levelNodes);
		}
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
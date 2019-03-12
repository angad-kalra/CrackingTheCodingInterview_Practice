import java.util.*;
public class BinaryTreeOperations	{
	public static void main(String[] args)	{
		System.out.println("Start");

		TreeNode root = new TreeNode(32);
		root.insert(10);
		root.insert(40);
		root.insert(31);
		root.insert(2);
		root.insert(14);
		root.insert(93);
		root.insert(17);
		root.insert(-20);
		System.out.println("Inserted all nodes");
		TreeNode node = root.find(14);
		System.out.println("root : " + node.value + " root.left : " + (node.left != null ? node.left.value : "EMPTY") + " root.right : " + (node.right != null ? node.right.value : "EMPTY"));
		System.out.println("getRandomNode : " + root.getRandomNode().value);
	}
}


class TreeNode 	{
	int value;
	TreeNode left;
	TreeNode right;
	int size = 0;

	TreeNode(int val)	{
		value = val;
		size = 0;
	}

	void insert(int num)	{
		if(num < value)	{
			if(left == null)
				left = new TreeNode(num);
			else
				left.insert(num);
		}
		else 	{
			if(right == null)
				right = new TreeNode(num);
			else
				right.insert(num);
		}
		size++;
	}

	TreeNode find(int n)	{
		if(n == value)
			return this;
		else{
			if(n < value)
				return left!=null ? left.find(n) : null;
			else
				return right!=null ? right.find(n) : null;
		}
	}

	int size()	{
		return size;
	}

	TreeNode getRandomNode()	{
		Random rand = new Random();
		int idx = rand.nextInt(size);
		int leftSize = left == null ? 0 : left.size();
		if(leftSize > idx)
			return left.getRandomNode();
		else if(leftSize == idx)
			return this;
		else
			return right.getRandomNode();
	}
}
import java.lang.*;
import java.io.*;
class Node	{
	int val;
	Node left;
	Node right;

	public Node(int x)	{
		val = x;
	}
}
public class MinHeap	{
	static BufferedReader br;
	public static void main(String[] args)	{
		br = new BufferedReader(new InputStreamReader(System.in));
		String buffer;
		System.out.println("Enter root\n");
		try	{
			Node root = new Node(Integer.parseInt(br.readLine()));
			buildTree(root);
			System.out.println("Menu:\n1.Insert Node\n2.Remove Node\n");
			int choice = Integer.parseInt(br.readLine());
			if(choice == 1)	{
				System.out.println("Enter node to be inserted\n");
				int nodeVal = Integer.parseInt(br.readLine());
				insertIntoMinHeap(root,nodeVal);
			}
			else if(choice == 2)	{
				root = removeFromMinHeap(root);
				root = updateMinHeap(root);
				System.out.println("New root is\t"+root.val+"\n"+root.left.val+"\t\t"+root.right.val);
			}
			else	{
				System.out.println("Invalid choice\n");
			}
		}
		catch(IOException e)	{
			System.out.println("Exception\n"+e);
		}
	}

	public static void buildTree(Node node)	{
		try	{
			System.out.println("Want to add left child for\t"+node.val+"?\n");
			String b = br.readLine();
			if(b.equals("n"))
				return;
			System.out.println("Enter left child of\t"+node.val+"\n");
			node.left = new Node(Integer.parseInt(br.readLine()));
			System.out.println("Want to add right child for\t"+node.val+"?\n");
			b = br.readLine();
			if(b.equals("n"))
				return;
			System.out.println("Enter right child of\t"+node.val+"\n");
			node.right = new Node(Integer.parseInt(br.readLine()));
			
		}
		catch(IOException e)	{
			System.out.println("Exception\n"+e);
		}
		buildTree(node.left);
		buildTree(node.right);
	}


	public static Node removeFromMinHeap(Node root)	{
		Node head = root;
		Node temp = new Node(0);
		while(head.right!=null)	{
			temp = head;
			head = head.right;
		}
		if(head.left!=null)	{
			temp = head;
			head = head.left;
			temp.left = null;
		}
		else
			temp.right = null;

		root.val = head.val;
		return root;
	}

	public static Node updateMinHeap(Node root)	{
		Node head = root;
		while(root!=null)	{
			if(root.left!= null && root.right!=null)	{
				if(root.left.val<root.right.val && root.val>root.left.val)	{
					int temp = root.val;
					root.val = root.left.val;
					root.left.val = temp;
					root = root.left;
				}
				else if(root.right.val<root.left.val && root.val>root.right.val){
					int temp = root.val;
					root.val = root.right.val;
					root.right.val = temp;
					root = root.right;
				}
				else
					break;
			}
			else if(root.left!=null && root.val > root.left.val)	{
				int temp = root.val;
				root.val = root.left.val;
				root.left.val = temp;
				root = root.left;
			}
			else if(root.right!=null && root.val > root.right.val)	{
				int temp = root.val;
				root.val = root.right.val;
				root.right.val = temp;
				root = root.right;
			}
			else
				break;
		}
		return head;
	}

	public static void insertIntoMinHeap(Node root, int nodeVal)	{
		Node head = root;
		while(head.right!=null)	{
			head = head.right;
		}
		if(head.left == null)
			head.left = new Node(nodeVal);
		else
			head.right = new Node(nodeVal);
		System.out.println("Successfully inserted new node as child of\n\t"+head.val+"\n"+head.left.val+"\t\t"+head.right.val);
	}
}
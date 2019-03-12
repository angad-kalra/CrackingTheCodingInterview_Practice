import java.util.*;
class SetOfStacks	{
	static ArrayList<Stack> stacks;
	static int curStackIdx;

	public SetOfStacks()	{
		curStackIdx = -1;
		stacks = new ArrayList<Stack>();
	}

	public static void main(String[] args)	{
		System.out.println("Start!");
		SetOfStacks set = new SetOfStacks();
		stacks.add(new Stack(5));
		push(2);
		push(3);
		push(4);
		System.out.println("Popped : " + pop());
		push(5);
		push(6);
		push(7);
		System.out.println("Stacks array size : " + stacks.size() + " stack(0) full ? " + stacks.get(0).isFull());
		push(8);
		System.out.println("Stacks array size : " + stacks.size() + " stack(1) size : " + stacks.get(1).size);
		System.out.println("Popped : " + pop());
		System.out.println("Stacks array size : " + stacks.size() + " stack(0) size : " + stacks.get(0).size);
		System.out.println("Popped : " + pop());
		System.out.println("Stacks array size : " + stacks.size() + " stack(0) size : " + stacks.get(0).size);
	}

	static void push(int num)	{
		Stack last = getLastStack();
		if(last!=null && !last.isFull())	{
			last.push(num);
		}
		else 	{
			Stack s = new Stack(5);
			s.push(num);
			stacks.add(s);
		}
		System.out.println("Pushed : " + num);
		
	}

	static int pop()	{
		Stack last = getLastStack();
		if(last == null)	{
			throw new NoSuchElementException();
		}
		int val = last.pop();
		if(last.size == 0)	{
			stacks.remove(stacks.size() - 1);
		}
		return val;

	}

	static Stack getLastStack()	{
		if(stacks.size() != 0)	{
			return stacks.get(stacks.size() - 1);
		}
		else{
			System.out.println("Empty!");
			return null;
		}
	}

	
}

class Stack {
	private int capacity;
	public Node top, bottom;
	public int size = 0;

	public Stack(int capacity)	{
		this.capacity = capacity;
	}

	public void push(int num)	{
		if(!isFull())	{
			Node n = new Node(num);
			n.above = null;
			n.below = top;
			if(isEmpty())	{
				bottom = n;
			}
			top = n;
			size++;
		}
		else{
			System.out.println("Full!");
		}
	}

	public int pop()	{
		if(!isEmpty())	{
			int temp = top.value;
			if(top == bottom)	{
				bottom = null;
			}
			if(top.below != null)
				top.below.above = null;
			top = null;
			size--;
			System.out.println("Popping ! Updated size of stack : " + size);
			return temp;
		}

		return -1;
	}

	public int top()	{
		if(!isEmpty())
			return top.value;
		System.out.println("Invalid element request");
		return -1;
	}

	public boolean isEmpty()	{
		return size == 0;
	}

	public boolean isFull()		{
		return size == this.capacity;
	}
}

class Node{
	int value;
	Node below;
	Node above;

	public Node(int v)	{
		this.value = v;
	}
}
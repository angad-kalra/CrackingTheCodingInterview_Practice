import java.util.NoSuchElementException;
class ThreeInOneStack	{
	public static int[] array;
	public static int curIdx;
	public ThreeInOneStack(int size)	{
		array = new int[size];
		curIdx = -1;
	}
	public static void main(String[] args)	{
		int n = Integer.parseInt(args[0]);
		System.out.println("Entered size is : " + n);
		ThreeInOneStack stack = new ThreeInOneStack(n);
		push(2);
		System.out.println("Pushed : 2");
		push(5);
		System.out.println("Pushed : 5");
		push(6);
		System.out.println("Pushed : 6");
		push(7);
		System.out.println("Pushed : 7");
		System.out.println("Is stack full? : " + isFull());
		push(8);
		System.out.println("Pushed : 8");
		System.out.println("Popped element : " + pop());
		System.out.println("stack top : " + top());
		System.out.println("Popped element : " + pop());
		System.out.println("Popped element : " + pop());
		System.out.println("Popped element : " + pop());
		System.out.println("Popped element : " + top());
		System.out.println("Is stack empty? : " + isEmpty());

	}

	public static void push(int num)	{
		if(!isFull())
			array[++curIdx] = num;
		else
			throw new NoSuchElementException();
	}

	public static int pop()	{
		if(isEmpty())	{
			throw new NoSuchElementException();
		}
		else 	{
			int top = array[curIdx];
			array[curIdx--] = Integer.MIN_VALUE;
			return top;
		}
	}

	public static int top()	{
		if(isEmpty())	{
			throw new NoSuchElementException();
		}
		else 	{
			return array[curIdx];
		}
	}

	public static boolean isEmpty()	{
		if(curIdx == -1)
			return true;
		else
			return false;
	}

	public static boolean isFull()	{
		if(curIdx >= array.length)
			return true;
		else
			return false;
	}

}
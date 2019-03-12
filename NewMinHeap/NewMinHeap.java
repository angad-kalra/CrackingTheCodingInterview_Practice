import java.lang.*;
import java.io.*;
import java.util.*;

public class NewMinHeap	{
	int[] Heap;
	int curSize;
	public static final int HEAD = 1;
	public NewMinHeap(int maxSize)	{
		this.Heap = new int[maxSize+1];
		this.curSize = 0;
		Heap[0] = Integer.MIN_VALUE;
	}


	public int parent(int index)	{
		return index/2;
	}



	public int leftChild(int pos)	{
		return 2*pos;
	}


	public int rightChild(int pos)	{
		return 2*pos + 1;
	}


	public void swap(int curPos, int parentPos)	{
		int temp = Heap[curPos];
		Heap[curPos] = Heap[parentPos];
		Heap[parentPos] = temp;
	}


	public void insert(int n)	{
		Heap[++curSize] = n;
		int current = curSize;

		while(Heap[current]<Heap[parent(current)])	{
			swap(current,parent(current));
			current = parent(current);
		}
	}

	public int remove()	{
		int removed = Heap[HEAD];
		Heap[HEAD] = Heap[curSize];
		minHeapify(HEAD);
		return removed;
	}


	public void minHeapify(int position)	{
		if(!isLeaf(position))	{
			if(Heap[position]>Heap[leftChild(position)]	|| Heap[position]>Heap[rightChild(position)])	{
				if(Heap[leftChild(position)]<Heap[rightChild(position)])	{
					swap(position, leftChild(position));
					minHeapify(leftChild(position));
				}
				else	{
					swap(position,rightChild(position));
					minHeapify(rightChild(position));
				}
			}
		}
	}


	public void minHeap()	{
		for(int idx=curSize/2; idx>=0; idx--)	{
			minHeapify(idx);
		}
	}



	public boolean isLeaf(int pos)	{
		return (pos>(curSize/2)) && pos<=curSize;
	}


	public void print()	{
		for (int i = 1; i <= curSize / 2; i++) { 
            System.out.print(" PARENT : " + Heap[i] 
                     + " LEFT CHILD : " + Heap[2 * i] 
                   + " RIGHT CHILD :" + Heap[2 * i + 1]); 
            System.out.println(); 
        } 
	}


	public static void main(String[] args)	{
		
		NewMinHeap nmh = new NewMinHeap(100);
		nmh.insert(5); 
        nmh.insert(3); 
        nmh.insert(17); 
        nmh.insert(10); 
        nmh.insert(84); 
        nmh.insert(19); 
        nmh.insert(6);
        nmh.insert(22); 
        nmh.insert(9);
        nmh.minHeap();

        nmh.print();
		System.out.println("Node removed :\n"+nmh.remove());
		nmh.print();
	}
}
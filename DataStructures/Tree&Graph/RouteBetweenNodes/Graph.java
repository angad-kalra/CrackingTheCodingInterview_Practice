import java.io.*;
import java.util.*;

class Graph	{
	private int vertexCount;
	private LinkedList<Integer> adjacencyList[];
	Graph(int v)	{
		vertexCount = v;
		adjacencyList = new LinkedList[vertexCount];
		for(int i = 0; i<vertexCount; i++)	{
			adjacencyList[i] = new LinkedList();
		}
	}

	public static void main(String[] args)	{
		System.out.println("Start!");
		Graph g = new Graph(4);
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);
        int u = 1; 
        int v = 3; 
        if (g.findRoute(u, v)) 
            System.out.println("There is a path from " + u +" to " + v); 
        else
            System.out.println("There is no path from " + u +" to " + v);; 
  
        u = 3; 
        v = 1; 
        if (g.findRoute(u, v)) 
            System.out.println("There is a path from " + u +" to " + v); 
        else
            System.out.println("There is no path from " + u +" to " + v);
	}

	boolean findRoute(int src, int dest)	{
		LinkedList<Integer> temp;
		if(src == dest)
			return true;
		boolean[] visited = new boolean[vertexCount];

		LinkedList<Integer> queue = new LinkedList();

		visited[src] = true;
		queue.add(src);

		while(!queue.isEmpty())	{
			int curSrc = queue.poll();

			Iterator<Integer> iter = adjacencyList[curSrc].listIterator();

			while(iter.hasNext())	{
				int curDest = iter.next();

				if(curDest == dest)
					return true;

				if(!visited[curDest])	{
					visited[curDest] = true;
					queue.add(curDest);
				}
			}

		}

		return false;
	}

	void addEdge(int src, int dest)	{
		adjacencyList[src].add(dest);
		System.out.println("Added Edge!");
	}
}
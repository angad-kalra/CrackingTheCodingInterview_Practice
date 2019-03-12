from collections import defaultdict
graph = defaultdict(list)

noOfVertices = 4

def addEdge(u,v):
	graph[u].append(v)

def findPathBetween(src, dest):
	visited = [False]*noOfVertices
	queue = []
	queue.append(src)
	visited[src] = True

	while queue : 
		vertex = queue.pop(0)

		if vertex == dest :
			return True

		for v in graph[vertex] :
			if visited[v] == False:
				queue.append(v)
				visited[v] = True

	return False


addEdge(0,1)
addEdge(0,2)
addEdge(1, 2) 
addEdge(2, 0) 
addEdge(2, 3)
addEdge(3, 3)

print (findPathBetween(3,1))
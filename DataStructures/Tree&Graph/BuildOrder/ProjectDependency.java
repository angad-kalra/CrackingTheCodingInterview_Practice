import java.io.*;
import java.lang.*;
import java.util.*;

public class ProjectDependency	{
	public static void main(String[] args)	{
		System.out.println("Start");
		//key represents the project on which the value is dependent
		// Map<Character,Character> dependencyMap = new HashMap<Character, Character>();
		// Set<Character> uniqueProjects = new HashSet<Character>();
		// ArrayList<Character> result = new ArrayList<Character>();
		// uniqueProjects.add('a');
		// uniqueProjects.add('b');
		// uniqueProjects.add('c');
		// uniqueProjects.add('d');
		// uniqueProjects.add('e');
		// uniqueProjects.add('f');
		
		// dependencyMap.put('a','d');
		// dependencyMap.put('f','b');
		// dependencyMap.put('b','d');
		// dependencyMap.put('f','a');
		// dependencyMap.put('d','c');

		// for(Character c : uniqueProjects)	{
		// 	if(!dependencyMap.containsValue(c))	{
		// 		result.add(c);
		// 	}
		// }

		// System.out.println("Initial projects : " + Arrays.toString(result.toArray()));
		String[] projects = {"a","b","c", "d", "e", "f", "g"};
		String[][] dependencies = {{"f","c"}, {"f","b"}, {"f","a"}, {"c","a"}, {"b","a"}, {"a","e"}, {"b","e"}, {"d","g"}};				//{{"a","d"}, {"f","b"}, {"b","d"}, {"f","a"}, {"d","c"}};
		Graph graph = buildGraph(projects, dependencies);
		Project[] order = new Project[projects.length];

		order = orderProjects(graph.getProjectNodes());

		for(Project p : order)	{
			System.out.println(p.name);
		}

	}

	public static Graph buildGraph(String[] projects, String[][] dependencies)	{
		Graph graph = new Graph();

		for(String project : projects)	{
			graph.getOrCreateProjectNode(project);
		}

		for(String[] dependency : dependencies)	{
			String src = dependency[0];
			String dest = dependency[1];
			graph.addEdge(src, dest);
		}

		return graph;
	}

	public static Project[] orderProjects(ArrayList<Project> projects)	{
		Project[] order = new Project[projects.size()];

		int newStartOffset = addNonDependentProjects(order, projects, 0);

		int projectToBeProcessed = 0;
		while(projectToBeProcessed < order.length)	{

			Project cur = order[projectToBeProcessed];

			if(cur == null)
				return null;

			ArrayList<Project> children = cur.getChildren();
			for(Project child : children)	{
				child.decrementDependencies();
			}

			newStartOffset = addNonDependentProjects(order, children, newStartOffset);
			
			projectToBeProcessed++;
		}

		return order;
	}

	public static int addNonDependentProjects(Project[] order, ArrayList<Project> projects, int offset)	{
		for(Project p : projects)	{
			if(p.getDependencyCount() == 0)
				order[offset++] = p;
		}

		return offset;
	}
}

class Graph	{
	ArrayList<Project> nodes = new ArrayList<Project>();
	HashMap<String, Project> nodeMap = new HashMap<String, Project>();


	Project getOrCreateProjectNode(String name)	{
		if(!nodeMap.containsKey(name))	{
			Project node = new Project(name);
			nodes.add(node);
			nodeMap.put(name, node);
		}

		return nodeMap.get(name);
	}

	void addEdge(String srcName, String destName)	{
		Project src = getOrCreateProjectNode(srcName);
		Project dest = getOrCreateProjectNode(destName);
		src.addNeighbour(dest);
	}

	ArrayList<Project> getProjectNodes()	{
		return nodes;
	}
}

class Project 	{
	ArrayList<Project> children = new ArrayList<Project>();
	Set<String> uniqueNeighbours = new HashSet<String>();
	String name;
	int dependencies = 0;

	Project(String n)	{
		name = n;
	}

	void addNeighbour(Project node)	{
		if(!uniqueNeighbours.contains(node.name))	{
			children.add(node);
			uniqueNeighbours.add(node.name);
			node.incrementDependencies();
		}
	}

	void incrementDependencies()	{
		dependencies++;
	}

	void decrementDependencies()	{
		dependencies--;
	}

	String getName()	{
		return name;
	}

	ArrayList<Project> getChildren()	{
		return children;
	}

	int getDependencyCount()	{
		return dependencies;
	}

}
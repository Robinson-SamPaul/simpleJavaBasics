package simple;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AihGraphTraversal {

	public static void breadthFirstTraversal(Graph graph, boolean[] visited, int currentVertex) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(currentVertex);
		while (!queue.isEmpty()) {
			int vertex = queue.remove();
			if (visited[vertex]) {
				continue;
			}
			System.out.print(vertex + "->");
			visited[vertex] = true;
			List<Integer> list = graph.getAdjacentValues(vertex);
			for (int v : list) {
				if (!visited[v]) {
					queue.add(v);
				}
			}
		}
	}
	
	public static void depthFirstTraversal(Graph graph, boolean[] visited, int currentVertex) {
        if (visited[currentVertex]) {
            return;
        }
        visited[currentVertex] = true;
        List<Integer> list = graph.getAdjacentValues(currentVertex);        
        for (int vertex : list) {
            depthFirstTraversal(graph, visited, vertex);
        }
        System.out.print(currentVertex + "->");
    }

	public static void main(String[] args) {
		/*
		 * These traversal only works undirected, not directed
		 */
		Graph graph = new AdjacencyMatrixGraph(8, Graph.GraphType.UNDIRECTED);
		graph.addEdge(1, 0);
		graph.addEdge(1, 2);
		graph.addEdge(1, 5);
		graph.addEdge(3, 4);
		graph.addEdge(2, 7);
		graph.addEdge(2, 4);
		graph.addEdge(2, 3);
		graph.addEdge(5, 6);
		graph.addEdge(6, 3);
		graph.displayGraph(); // draw and understand this
		
		System.out.println("\n------------------------\n");
		boolean[] breadthFirstFlag = new boolean[graph.getNumVertices()];
		// If this needs to work with directed also means, what we can do is
		// create a for loop and start traversal with each values, repeated will be ignored because of boolean array
		/*for(int i=0; i<graph.getNumVertices(); i++) {
			breadthFirstTraversal(graph, breadthFirstFlag, 0);
		}*/
		breadthFirstTraversal(graph, breadthFirstFlag, 0);
		System.out.println("\n\n------------------------\n");
		System.out.println("\n------------------------\n");
		boolean[] depthFirstFlag = new boolean[graph.getNumVertices()];
		depthFirstTraversal(graph, depthFirstFlag, 0);
		System.out.println("\n\n------------------------\n");
	}
}

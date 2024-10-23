package simple;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class AijShortestPathAlgo {

	private static Map<Integer, DistanceEntry> buildDistanceTable(Graph graph, int source) {
		Map<Integer, DistanceEntry> distanceTable = new HashMap<>();
		
		// creating a table for all vertices with default values (-1)
		for (int j = 0; j < graph.getNumVertices(); j++) {
			distanceTable.put(j, new DistanceEntry());
		}
		
		// setting the source's value as 0, cuz A->A distance is 0
		distanceTable.get(source).setDistance(0);
		distanceTable.get(source).setLastVertex(source);
		System.out.println("\nBefore Distance table\n " + distanceTable);
		
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(source);
		while (!queue.isEmpty()) {
			int currentVertex = queue.pollFirst(); // return and remove first element
			
			// Iterating through nearby values of source, getting it and iterating through that and so on
			for (int i : graph.getAdjacentValues(currentVertex)) {
				int currentDistance = distanceTable.get(i).getDistance(); // getting distance of each nearby element
				if (currentDistance == -1) { // first time it'll be -1 as we did it as default value
					currentDistance = 1 + distanceTable.get(currentVertex).getDistance(); // updating the distance based on before element
					distanceTable.get(i).setDistance(currentDistance); // setting the updated distance
					distanceTable.get(i).setLastVertex(currentVertex); // setting the updated values
					// NOTE: Enqueue the neighbor only if it has other adjacent vertices.
					if (!graph.getAdjacentValues(i).isEmpty()) {
						queue.add(i);
					}
				}
			}
		}
		System.out.println("\nAfter Distance table\n " + distanceTable);
		return distanceTable;
	}

	public static void shortestPath(Graph graph, int source, int destination) {
		Map<Integer, DistanceEntry> distanceTable = buildDistanceTable(graph, source);
		Stack<Integer> stack = new Stack<>();
		stack.push(destination); // setting the destination
		int previousVertex = distanceTable.get(destination).getLastVertex();
		while (previousVertex != -1 && previousVertex != source) { // until we found the source, we're iterating
			stack.push(previousVertex); // adding all the vertices on the way
			previousVertex = distanceTable.get(previousVertex).getLastVertex();
		}
		if (previousVertex == -1) {
			System.out.println("There is no path from node: " + source + " to node: " + destination);
		} else {
			System.out.print("\n\nShortest path is " + source);
			while (!stack.isEmpty()) {
				System.out.print(" -> " + stack.pop());
			}
			System.out.println("\n\nShortest Path Unweighted DONE!");
		}
	}

	public static void main(String[] args) {
		Graph graph = new AdjacencyMatrixGraph(8, Graph.GraphType.UNDIRECTED); // can be Directed as well
		graph.addEdge(2, 7);
		graph.addEdge(3, 0);
		graph.addEdge(0, 4);
		graph.addEdge(0, 1);
		graph.addEdge(2, 1);
		graph.addEdge(1, 3);
		graph.addEdge(3, 5);
		graph.addEdge(6, 3);
		graph.addEdge(4, 7);
		graph.addEdge(0, 7);
		graph.displayGraph();
		shortestPath(graph, 7, 5);
	}
}

class DistanceEntry {
    
    private int distance;
    private int lastVertex;

    public DistanceEntry() {
        //distance = -1; 
        distance = Integer.MAX_VALUE; // while running AikDijkstraAlgo, uncomment this line and comment above line
        lastVertex = -1;
    }

    public int getDistance() {
        return distance;
    }

    public int getLastVertex() {
        return lastVertex;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setLastVertex(int lastVertex) {
        this.lastVertex = lastVertex;
    }

	@Override
	public String toString() {
		return "[distance=" + distance + ", lastVertex=" + lastVertex + "]\n";
	}
}

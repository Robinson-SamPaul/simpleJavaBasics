package simple;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class AikDijkstraAlgo {

	public static void main(String[] args) {
		Graph graph = new AdjacencyMatrixGraph(8, Graph.GraphType.UNDIRECTED);
		graph.addEdge(0, 3, 2);
		graph.addEdge(0, 4, 2);
		graph.addEdge(0, 1, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(2, 7, 4);
		graph.addEdge(2, 1, 3);
		graph.addEdge(4, 5, 1);
		graph.addEdge(3, 5, 2);
		graph.addEdge(3, 6, 3);
		graph.addEdge(4, 7, 2);
		graph.addEdge(7, 5, 4);
		graph.displayGraph();
		shortestPath(graph, 0, 1);
	}

	public static Map<Integer, DistanceEntry> buildDistanceTable(Graph graph, int source) {
		Map<Integer, DistanceEntry> distanceTable = new HashMap<>();
		/*PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
			@Override
			public int compare(VertexInfo v1, VertexInfo v2) {
				return ((Integer) v1.getDistance()).compareTo(v2.getDistance());
			}
		});*/
		
		PriorityQueue<VertexInfo> queue = new PriorityQueue<>(
				(v1, v2) -> 
					((Integer) v1.getDistance())
						.compareTo(v2.getDistance())
				);

		for (int j = 0; j < graph.getNumVertices(); j++) {
			distanceTable.put(j, new DistanceEntry());
		}

		distanceTable.get(source).setDistance(0);
		distanceTable.get(source).setLastVertex(source);

		VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
		queue.add(sourceVertexInfo);

		Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
		vertexInfoMap.put(source, sourceVertexInfo);

		while (!queue.isEmpty()) {

			VertexInfo vertexInfo = queue.poll();

			int currentVertex = vertexInfo.getVertexId();

			for (Integer neighbor : graph.getAdjacentValues(currentVertex)) {

				// NOTE: Get the new distance, account for the weighted edge.
				int distance = distanceTable.get(currentVertex).getDistance()
						+ graph.getWeightedEdge(currentVertex, neighbor);

				// NOTE: If we find a new shortest path to the neighbor update
				// the distance and the last vertex.
				if (distanceTable.get(neighbor).getDistance() > distance) {

					distanceTable.get(neighbor).setDistance(distance);
					distanceTable.get(neighbor).setLastVertex(currentVertex);

					// NOTE: We've found a new short path to the neighbor so remove
					// the old node from the priority queue.
					VertexInfo neighborVertexInfo = vertexInfoMap.get(neighbor);

					if (neighborVertexInfo != null) {
						queue.remove(neighborVertexInfo);
					}

					// NOTE: Add the neighbor back with a new updated distance.
					neighborVertexInfo = new VertexInfo(neighbor, distance);

					queue.add(neighborVertexInfo);
					vertexInfoMap.put(neighbor, neighborVertexInfo);
				}
			}
		}

		return distanceTable;
	}

	public static void shortestPath(Graph graph, Integer source, Integer destination) {

		Map<Integer, DistanceEntry> distanceTable = buildDistanceTable(graph, source);

		Stack<Integer> stack = new Stack<>();
		stack.push(destination);

		int previousVertex = distanceTable.get(destination).getLastVertex();

		while (previousVertex != -1 && previousVertex != source) {

			stack.push(previousVertex);
			previousVertex = distanceTable.get(previousVertex).getLastVertex();
		}

		if (previousVertex == -1) {
			System.out.println("There is no path from node: " + source + " to node: " + destination);
		} else {
			System.out.print("\n\nShortest Path is " + source);
			while (!stack.isEmpty()) {
				System.out.print(" -> " + stack.pop());
			}
			System.out.println("\nDijkstra  DONE!");
		}
	}

}

class VertexInfo {
    private int vertexId;
    private int distance;

    public VertexInfo(int vertexId, int distance) {        
        this.vertexId = vertexId;
        this.distance = distance;
    }

    public int getVertexId() {
        return vertexId;
    }

    public int getDistance() {
        return distance;
    }

    public String toString() {
        return "Vertex: " + vertexId + " Edge weight: " + distance;
    }
}


package simple;

import java.util.ArrayList;
import java.util.List;

public class AigAdjacencyListGraph {
	
	public static void main(String[] args) {
		Graph graph = new AdjacencyListGraph(8, Graph.GraphType.UNDIRECTED);

        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(3, 4);
        graph.addEdge(2, 7);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);        
        graph.addEdge(5, 6);        
        graph.addEdge(6, 3);        
        graph.displayGraph();
        
        System.out.println("\nVertices adjacent to 1: " + graph.getAdjacentValues(1));
        System.out.println("\nVertices adjacent to 2: " + graph.getAdjacentValues(2));        
        System.out.println("\nVertices adjacent to 6: " + graph.getAdjacentValues(6));
	}	
}

class AdjacencyListGraph implements Graph {
	private List<Vertex> vertexList = new ArrayList<>(); // change type to set for adjecencySet
	private int numVertices = 0;
	private GraphType graphType = GraphType.DIRECTED;

	public AdjacencyListGraph(int numVertices, GraphType graphType) {
		this.numVertices = numVertices;
		for (int i = 0; i < numVertices; i++) {
			vertexList.add(new Vertex(i, 0)); // we're just randomly setting int values for each node(vertex)
		}
		this.graphType = graphType;
		System.out.println("List created when constructor called ");
		vertexList.stream().forEach(System.out::println);
	}

	@Override
	public void addEdge(int v1, int v2) {
    	addEdge(v1, v2, 1);
    }

    @Override
    public void addEdge(int v1, int v2, int weight) {        
    	if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
            throw new IllegalArgumentException("Vertex number is not valid: " + v1 + ", " + v2);
        }
        vertexList.get(v1).addEdge(v2, weight);
        if (graphType == GraphType.UNDIRECTED) {
            vertexList.get(v2).addEdge(v1, weight);
        }
    }

	@Override
	public List<Integer> getAdjacentValues(int v) {
		if (v >= numVertices || v < 0) {
			throw new IllegalArgumentException("Vertex number is not valid: " + v);
		}
		return vertexList.get(v).getAdjacentNumbers();
	}
	
	public List<Vertex> getAdjacentVertices(int v) {
		if (v >= numVertices || v < 0) {
			throw new IllegalArgumentException("Vertex number is not valid: " + v);
		}
		return vertexList.get(v).getAdjacentVertices();
	}

	@Override
	public int getIndegree(int v) {		
		int indegree = 0;		
		for (Vertex vertex : vertexList) {			
			List<Vertex> adjacentVerticesList = vertex.getAdjacentVertices();
			for (Vertex adjacentVertex : adjacentVerticesList) {
				if (adjacentVertex.getVertexNumber() == v) {
					indegree++;					
				}
			}
		}		
		return indegree;
	}
	
	public int getOutdegree(int v) {
		return vertexList.get(v).getAdjacentVertices().size();
	}

	@Override
	public int getNumVertices() {
		return numVertices;
	}

	@Override
	public void displayGraph() {
        System.out.println("Adjacency List\n");        
		for (Vertex vertex : vertexList) {			
			List<Vertex> adjacentVertices = vertex.getAdjacentVertices();
            System.out.println("Edges from " + vertex.getVertexNumber() + 
            		" to : " + adjacentVertices);
		}

	}
	
	@Override
    public int getWeightedEdge(int v1, int v2) {
        return 0; // yet to implement
    }
}

/*
Duplication:
	Adjacency List: Can contain duplicate entries (if the graph allows parallel edges between the same vertices).
	Adjacency Set: Does not allow duplicate entries (ensures each connection is unique).
Order of Nodes:
	Adjacency List: Preserves the order of insertion (if using an array or linked list).
	Adjacency Set: Does not preserve order (if using an unordered set like a hash set).
Lookup Time:
	Adjacency List: Checking if a node is connected to another node can take O(N) time, where N is the number of adjacent nodes.
	Adjacency Set: Checking if a node is connected to another node can be done in O(1) time (for a hash set) or O(logN) time (for a tree set), where N is the number of adjacent nodes.
Use Cases:
	Adjacency List: Preferred when the graph might have parallel edges or when the order of connections is important.
	Adjacency Set: Preferred when uniqueness of edges is important and faster lookup times are needed.
 */

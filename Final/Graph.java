import java.lang.*;
import java.util.*;

/**
 *  Implements a graph
 *  
 *  @author  Zacharias J. Arthurs
 *  @version 24 April 2013
 */

public class Graph<V, E> extends Object { 
    // PUT CLASS FIELDS HERE (IF ANY), WITH JAVADOC FOR EACH
    /** The list of edges */
    public ArrayList<Edge> edges;

    /** The list of nodes */
    public ArrayList<Node> nodes;

    // PUT CONSTRUCTORS NEXT (IF ANY), WITH JAVADOC FOR EACH
    /** Constructor intailizes with empty node and edge lists */
    public Graph() {
      nodes = new ArrayList<Node>();
      edges = new ArrayList<Edge>();
    }


    // PUT CLASS METHODS NEXT (IF ANY), WITH JAVADOC FOR EACH
    /** Accessor for list of nodes */
    public ArrayList<Node> getNodes() {
      return nodes;
    }

    /** Accessor for list of edges */
    public ArrayList<Edge> getEdges() {
      return edges;
    }

    /** Accessor for nodes */
    public Node getNode(int i) {
      return nodes.get(i);
    }

    /** Accessor for edges */
    public Edge getEdge(int i) {
      return edges.get(i);  
    }

    /** Accessor for a specific edge */
    public Edge getEdgeRef(Node head, Node tail) {
      return head.edgeTo(tail);
    }

    /** Accessor for the number of nodes */
    public int numNodes() {
      return nodes.size();
    }

    /**
     * Adds an edge
     *
     * @params, data, head, tail,
     * @return edge
     */
    public Edge addEdge(E data, Node head, Node tail) {
      Edge edge = new Edge(data, head, tail);
      head.addEdgeRef(edge);
      tail.addEdgeRef(edge);
      edges.add(edge);
      return edge;
    }

    /**
     * Adds a node
     *
     *@param data, the data in the node
     *@return node, the node to be added
     */
    public Node addNode(V data) {
      Node node = new Node(data);
      nodes.add(node);
      return node;
    }

    /**
     * Removes a node
     *
     * @param node, node to be removed
     */
    public void removeNode(Node node) {
      Edge edge;
      while (node.getEdgeRefs().isEmpty() == false) {
        edge = node.getEdgeRefs().get(0);
        removeEdge(edge);
      }
      nodes.remove(node);
    }

    /**
     * Removes an edge
     *
     *@param edge, edge to be removed
     */ 
    public void removeEdge(Edge edge) {
      Node head = edge.getHead();
      Node tail = edge.getTail();
      head.removeEdgeRef(edge);
      tail.removeEdgeRef(edge);
      edges.remove(edge);
    }

    /**
     * Removes an edge
     *
     * @params head, tail, nodes to define edge
     */
    public void removeEdge(Node head, Node tail) {
      Edge edge = head.edgeTo(tail);
      removeEdge(edge);
    }

    /** 
     * Prints a represenation of the graph
     */
     public void print() {
      for (Edge edge: edges) {
        System.out.print(edge.getData());
      }
      for (Node node: nodes) {
        if (node.getNeighbors(node).isEmpty()) {
          System.out.println(node.getData());
        }
      }
     } 

    // PUT NESTED CLASSES HERE
    /** 
     * Implements a node in a graph
     */
    public class Node {
        /** The value at this node */
        private V data;

        /** List of associated edges */
        public ArrayList<Edge> edgeRef;

        /** Constructor that creates a disconnected node */
        public Node(V data) {
            this.data = data;
            edgeRef = new ArrayList<Edge>();
        } 

        /** Acessor for data */
        public V getData() {
            return data;
        }

        /** Accessor for edgeRef */
        public ArrayList<Edge> getEdgeRefs() {
          return edgeRef;
        }

        /** Manipulator for data */
        public void setData(V data) {
            this.data = data;
        }

        /** 
         * Adds an edge to the edge list
         *
         * @param edge, edge to be added
         */
         public void addEdgeRef(Edge edge) {
            edgeRef.add(edge);
         }

         /**
          * Remove edge reference
          *
          * @param edge, edge to be removed
          */
          public void removeEdgeRef(Edge edge) {
            edgeRef.remove(edge);
          }


         /**
          * Returns a list of all the neighbors
          * 
          * @param node, node to get the neighbors of
          * @return neighbors, list of all the neighbors
          */
         public ArrayList<Node> getNeighbors(Node node) {
          ArrayList<Node> neighbors = new ArrayList<Node>();
          for (Edge edge: edgeRef) {
            if (edge.getHead() == node) {
              neighbors.add(edge.getTail());
            } else if (edge.getTail() == node) {
              neighbors.add(edge.getHead());
            }
          }

          return neighbors;
         }

         /**
          * Returns true/false of whether node is a neighbor of the current node
          * 
          * @param node, node to check if it is a neighbor of
          * @return boolean, whether or not it has a Neighbor
          */
         public boolean isNeighbor(Node node) {
          ArrayList<Node> neighbors = getNeighbors(this);
          return neighbors.contains(node);
         }

         /**
          * Returns the edge to a specified node (or null if there is none)
          *
          * @param neighbor, the specified node
          * @return edge, the edge that connect the nodes
          */
          public Edge edgeTo(Node neighbor) {
            Edge test = new Edge(null, this, neighbor);
            if (this.isNeighbor(neighbor) == false) {
              return null;
            }
            for (Edge edge: this.edgeRef) {
              if (edge.equals(test)) {
                return edge;
              }
            }
            return null;
          }        
    }
    /** 
     * Implements an edge in a graph
     */
    public class Edge {
        /** The value of this edge */
        private E data;

        /** The value of the head */
        private Node head;

        /** The value of the tail */
        private Node tail;

        /** Constructor that creates a new edge */
        Edge(E data, Node head, Node tail) {
            this.data = data;
            this.head = head;
            this.tail = tail;
        }

        /** Accessor for data */
        public E getData() {
            return data;
        } 

        /** Accessor for head */
        public Node getHead() {
            return head;
        }

        /** Accessor for tail */
        public Node getTail() {
            return tail;
        }

        /** Manipulator for data */
        public void setData(E data) {
            this.data = data;
        }

        /** 
         * Tests if two edges have the same endpoints 
         * 
         * @param edge, to be compared to
         * @return  boolean of whether to edges are equal or not
         */
         public boolean equals(Object o){
            if (o.getClass().equals(Edge.class) == false) {
              System.err.println("This needs to be an edge.");
              System.exit(-1);
            }
            @SuppressWarnings("unchecked")
            Edge edge = (Edge)o;
            Node head1 = this.head;
            Node tail1 = this.tail;
            Node head2 = edge.head;
            Node tail2 = edge.tail;
            if (head1 == head2 && tail1 == tail2) {
                return true;
            } else if (head1 == tail2 && tail1 == head2) {
                return true;
            } else {
                return false;
            }
         } 
    }
}
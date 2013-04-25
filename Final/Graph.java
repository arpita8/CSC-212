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

    }


    // PUT CLASS METHODS NEXT (IF ANY), WITH JAVADOC FOR EACH
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
      System.out.println(data);
      Node node = new Node(data);
      System.out.println(node);
      nodes.add(node);
      System.out.println(nodes);
      return node;
    }

    /**
     * Removes a node
     *
     * @param node, node to be removed
     */
    public void removeNode(Node node) {
      for (Node neighbor: node.getNeighbors(node)) {
        removeEdge(node.edgeTo(neighbor));
      }
      for (Edge edge: node.edgeRef)
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
     * Prints a represenation of the graph
     */
     public void print() {
      for (Edge edge: edges) {
        System.out.print(edge.getData());
        System.out.print(edge.getHead());
        System.out.print(edge.getTail());
      }
      for (Node node: nodes) {
        if (node.getNeighbors(node) == null) {
          System.out.println(node);
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
        } 

        /** Acessor for data */
        public V getData() {
            return data;
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
          ArrayList<Node> neighbors = null;
          for (Edge edge: edgeRef) {
            if (edge.getHead() == node) {
              neighbors.add(edge.getTail());
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
          if (neighbors.indexOf(node) == -1) {
            return false;
          } else {
            return true;
          }
         }

         /**
          * Returns the edge to a specified node (or null if there is none)
          *
          * @param neighbor, the specified node
          * @return edge, the edge that connect the nodes
          */
          public Edge edgeTo(Node neighbor) {
            if (this.isNeighbor(neighbor)) {
              for (Edge edge: this.edgeRef) {
                if (edge.getTail() == neighbor && edge.getHead() == this) {
                  return edge;
                } 
              }
              return null;
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
         public boolean equals(Edge edge){
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
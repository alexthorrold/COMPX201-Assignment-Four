/**
 * Node class which stores a priority value
 */
public class Node {

    // Priority value of the node for ordering in priority queue
    public int priority;

    /**
     * Initialises a new Node and assigns it a given priority value
     * @param priority Value to be given to the priority member variable
     */
    public Node(int priority) {
        this.priority = priority;
    }

    /**
     * Returns the priority of the node as a string
     * @return The word priority plus the node's priority value
     */
    @Override
    public String toString() {
        return "Priority: " + priority;
    }
}

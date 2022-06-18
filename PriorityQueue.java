/**
 * Priority queue implemented using a min heap based on the stored Node values' priorities
 */
public class PriorityQueue {

    // Min heap stored as an array of nodes
    private Node[] minHeap;
    // Pointer to the position the next insertion will occur at
    private int size;

    /**
     * Initialises a new priority queue, creates the min heap, and sets size to 0
     * @param capacity Max capacity to be given to the min heap
     */
    public PriorityQueue(int capacity) {
        if (capacity < 1) {
            capacity = 1;
        }

        minHeap = new Node[capacity];
        size = 0;
    }

    /**
     * Inserts a given node into the priority queue and calls upHeap to maintain priority
     * @param n Node to be inserted
     */
    public void insert(Node n) {
        if (n == null) {
            return;
        }

        minHeap[size] = n;

        size++;

        upHeap(size - 1);

        // Increases capacity of minHeap if current capacity has been reached
        if (size == minHeap.length) {
            increaseMaxSize();
        }
    }

    /**
     * Doubles the capacity of minHeap
     */
    private void increaseMaxSize() {
        Node[] newHeap = new Node[minHeap.length * 2];
        System.arraycopy(minHeap, 0, newHeap, 0, minHeap.length);
        minHeap = newHeap;
    }

    /**
     * Recursively shifts the final node in the heap upwards until it is in the correct position
     */
    private void upHeap(int i) {
        if (i > 0 && minHeap[i].priority < minHeap[(i - 1) / 2].priority) {
            Node temp = minHeap[(i - 1) / 2];
            minHeap[(i - 1) / 2] = minHeap[i];
            minHeap[i] = temp;

            upHeap((i - 1) / 2);
        }
    }

    /**
     * Deletes the highest priority node from the priority queue and returns it
     * @return The highest priority node
     */
    public Node delete() {
        if (size == 0) {
            return null;
        }

        Node n = minHeap[0];
        minHeap[0] = minHeap[size - 1];
        minHeap[size - 1] = null;

        size--;

        downHeap(0);

        return n;
    }

    /**
     * Recursively shifts the root node downwards until it is in the correct position
     */
    private void downHeap(int i) {
        int min = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < size && minHeap[left].priority < minHeap[min].priority) {
            min = left;
        }

        if (right < size && minHeap[right].priority < minHeap[min].priority) {
            min = right;
        }

        // Swaps the smallest of the left and right children node with the parent
        // node if either is smaller, otherwise finishes the downheap process
        if (min != i) {
            Node temp = minHeap[i];
            minHeap[i] = minHeap[min];
            minHeap[min] = temp;

            downHeap(min);
        }
    }

    /**
     * Prints priority of each node and its children nodes to console
     */
    public void dump() {
        for (int i = 0; i < size; i++) {
            System.out.println(
                    "Root "
                    + minHeap[i]
                    + "; left "
                    + leftChild(i)
                    + "; right "
                    + rightChild(i)
            );
        }
    }

    /**
     * Gets the left child of the node at a given position, unless left child
     * would be at a position outside minheap, in which case returns null
     * @param i Position of the parent node
     * @return The left child of a given node
     */
    private Node leftChild(int i) {
        if (i * 2 + 1 >= size) {
            return null;
        }
        else {
            return minHeap[i * 2 + 1];
        }
    }

    /**
     * Gets the left child of the node at a given position, unless left child
     * would be at a position outside minheap, in which case returns null
     * @param i Position of the parent node
     * @return The right child of a given node
     */
    private Node rightChild(int i) {
        if (i * 2 + 2 >= size) {
            return null;
        }
        else {
            return minHeap[i * 2 + 2];
        }
    }
}

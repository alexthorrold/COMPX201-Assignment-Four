import org.junit.jupiter.api.*;
import java.io.*;

class PriorityQueueTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setOut() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Testing the insert() method by obtaining value from delete() method")
    public void testInsertWithDelete() {
        // Assign
        PriorityQueue pq = new PriorityQueue(10);
        // Act
        pq.insert(new Node(1));
        Node n = pq.delete();
        int actual = n.priority;
        // Assert
        Assertions.assertEquals(1, actual);
    }

    @Test
    @DisplayName("Testing the insert() method by printing to console using dump() method")
    public void testInsertWithDump() {
        // Assign
        PriorityQueue pq = new PriorityQueue(10);
        // Act
        pq.insert(new Node(1));
        pq.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals("Root Priority: 1; left null; right null", actual);
    }

    @Test
    @DisplayName("Testing the insert() method when used multiple times")
    public void testInsertMultipleTimes() {
        // Assign
        PriorityQueue pq = new PriorityQueue(10);
        // Act
        pq.insert(new Node(1));
        pq.insert(new Node(2));
        pq.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals(
                "Root Priority: 1; left Priority: 2; right null" + System.lineSeparator() +
                "Root Priority: 2; left null; right null",
                actual
        );
    }

    @Test
    @DisplayName("Testing the delete() method with no nodes in the priority queue")
    public void testDeleteWithNoNodes() {
        // Assign
        PriorityQueue pq = new PriorityQueue(10);
        // Act
        Node actual = pq.delete();
        // Assert
        Assertions.assertNull(actual);
    }

    @Test
    @DisplayName("Testing the delete() method with multiple nodes")
    public void testDeleteWithMultipleNodes() {
        // Assign
        PriorityQueue pq = new PriorityQueue(10);
        // Act
        pq.insert(new Node(5));
        pq.insert(new Node(3));
        pq.insert(new Node(4));
        Node n = pq.delete();
        int actual = n.priority;
        // Assert
        Assertions.assertEquals(3, actual);
    }

    @Test
    @DisplayName("Testing the dump() method with no nodes in the priority queue")
    public void testDumpWithNoNodes() {
        // Assign
        PriorityQueue pq = new PriorityQueue(10);
        // Act
        pq.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals("", actual);
    }

    @Test
    @DisplayName("Testing the dump() method with a single node")
    public void testDumpAfterDeletion() {
        // Assign
        PriorityQueue pq = new PriorityQueue(10);
        // Act
        pq.insert(new Node(1));
        pq.insert(new Node(2));
        pq.delete();
        pq.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals("Root Priority: 2; left null; right null", actual);
    }

    @Test
    @DisplayName("Testing the dump() method with multiple nodes")
    public void testDumpWithMultipleNodes() {
        // Assign
        PriorityQueue pq = new PriorityQueue(10);
        // Act
        pq.insert(new Node(10));
        pq.insert(new Node(20));
        pq.insert(new Node(5));
        pq.insert(new Node(100));
        pq.insert(new Node(40));
        pq.dump();
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals("Root Priority: 5; left Priority: 20; right Priority: 10" + System.lineSeparator() +
                                "Root Priority: 20; left Priority: 100; right Priority: 40" + System.lineSeparator() +
                                "Root Priority: 10; left null; right null" + System.lineSeparator() +
                                "Root Priority: 100; left null; right null" + System.lineSeparator() +
                                "Root Priority: 40; left null; right null",
                actual);
    }
}
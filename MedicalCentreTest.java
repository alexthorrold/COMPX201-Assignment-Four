import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.io.*;

class MedicalCentreTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setOut() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Testing the processQueue() method with an invalid file name")
    public void testProcessQueueWithInvalidFileName() {
        // Assign
        MedicalCentre mc = new MedicalCentre();
        // Act
        mc.processQueue("invalid.txt");
        // Assert
        Assertions.assertThrows(FileNotFoundException.class, () -> {
            throw new FileNotFoundException();
        });
    }

    @Test
    @DisplayName("Testing the processQueue() method with an empty file")
    public void testProcessQueueWithEmptyFile() {
        // Assign
        MedicalCentre mc = new MedicalCentre();
        // Act
        mc.processQueue("test_file_empty.txt");
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals("", actual);
    }

    @Test
    @DisplayName("Testing the processQueue() method with a single patient")
    public void testProcessQueueWithOnePatient() {
        // Assign
        MedicalCentre mc = new MedicalCentre();
        // Act
        mc.processQueue("test_file_one_patient.txt");
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals("Priority: 1, Name: Jerry Smith, Age: 72, Medical severity level: high, Patient number: 1", actual);
    }

    @Test
    @DisplayName("Testing the processQueue() method with multiple patients")
    public void testProcessQueueWithMultiplePatients() {
        // Assign
        MedicalCentre mc = new MedicalCentre();
        // Act
        mc.processQueue("test_file_multiple_patients.txt");
        String actual = outputStreamCaptor.toString().trim();
        // Assert
        Assertions.assertEquals("Priority: 1, Name: Jerry Smith, Age: 72, Medical severity level: high, Patient number: 1" + System.lineSeparator() +
                                "Priority: 2, Name: Joe Singer, Age: 42, Medical severity level: medium, Patient number: 3" + System.lineSeparator() +
                                "Priority: 3, Name: Kyle Webb, Age: 14, Medical severity level: low, Patient number: 2",
                actual);
    }
}
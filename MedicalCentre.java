import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * MedicalCentre class for processing details of a medical centre's patients
 */
public class MedicalCentre {

    // Priority queue to be used for printing patients and their details to console
    private PriorityQueue pq;

    /**
     * Initialises a new MedicalCentre and initialises the priority queue with an initial capacity of 10000
     */
    public MedicalCentre() {
        pq = new PriorityQueue(1000);
    }

    /**
     * Reads the patient details from a given file then formats and displays to console
     * @param fileName File to read patient data from
     */
    public void processQueue(String fileName) {
        // Number to be assigned to the next patient being processed
        int nextPatientNumber = 1;

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            // Processes all lines of the given file and adds to priority queue
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] split = str.split(",");

                int priority;
                String patientName = split[0];
                int patientAge = Integer.parseInt(split[1]);
                String medicalSeverity = split[2];

                //Assigns a priority level to the patient based on medical severity level and age
                if (medicalSeverity.equals("low")) {
                    priority = 3;
                }
                else if (medicalSeverity.equals("medium") && patientAge < 65) {
                    priority = 2;
                }
                // All patients over 65 or with a high medical severity level are assigned priority level 1
                else {
                    priority = 1;
                }

                Patient p = new Patient(priority, patientName, patientAge, medicalSeverity, nextPatientNumber);
                nextPatientNumber++;

                pq.insert(p);
            }

            Patient p = (Patient) pq.delete();

            // Prints all patients in priority queue to console in order of priority
            while (p != null) {
                System.out.println(p.toStringLong());
                p = (Patient) pq.delete();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

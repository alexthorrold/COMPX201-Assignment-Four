/**
 * Patient class which stores details about a patient
 */
public class Patient extends Node {

    // The name of the patient
    public String name;
    // The age of the patient
    public int age;
    // The medical severity level of the patient
    public String medicalSeverity;
    // The patient's unique identifying number
    public int patientNumber;

    /**
     * Initialises a new Patient and sets all member variables to given values
     * @param priority Priority of the patient
     * @param name Name of the patient
     * @param age Age of the patient
     * @param medicalSeverity Medical severity level of the patient
     * @param patientNumber Unique identifying number for the patient
     */
    public Patient(int priority, String name, int age, String medicalSeverity, int patientNumber) {
        super(priority);
        this.name = name;
        this.age = age;
        this.medicalSeverity = medicalSeverity;
        this.patientNumber = patientNumber;
    }

    /**
     * Returns the patient's priority and name as a formatted string
     * @return Priority and name of the patient
     */
    @Override
    public String toString() {
        return super.toString()
                + ", Name: "
                + name;
    }

    /**
     * Returns all member variable values of patient and node superclass as a formatted string
     * @return All member variable values for the patient
     */
    public String toStringLong() {
        return this
                + ", Age: "
                + age
                + ", Medical severity level: "
                + medicalSeverity
                + ", Patient number: "
                + patientNumber;
    }
}

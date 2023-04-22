import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class PatientList {
    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
    Scanner sc = new Scanner(System.in);
    private ArrayList<Patient> patientList;

    public PatientList() {
        patientList = new ArrayList<Patient>();
    }

    public PatientList(ArrayList<Patient> list) {
        patientList = list;
    }

    // add a patient to the list and database
    public void addPatient(Patient pa) {
        this.patientList.add(pa);
    }

    // show the patient list
    public void showList() {
        int i = 1;
        for (Patient patient : patientList) {
            System.out.print(i + ".");
            i = i + 1;
            System.out.println(patient);
        }
    }

    // add medical chart
    public void addMedicalChart(int id, MedicalChart mc) {
        for (Patient patient : patientList) {
            if (patient.getID() == id) {
                patient.setMedicalChart(mc);
            }
        }
    }

    public boolean check(int id) {
        for (Patient patient : patientList) {
            if (patient.getID() == id) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
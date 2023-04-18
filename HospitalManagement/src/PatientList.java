import java.util.ArrayList;
import java.time.LocalDate;

public class PatientList {
    protected ArrayList<Patient> patientList;

    public PatientList() {
        patientList = new ArrayList<Patient>();
    }

    public PatientList(ArrayList<Patient> list) {
        patientList = list;
    }

    // add a patient to the list
    public void addPatient(Patient pa) {
        this.patientList.add(pa);
    }

    // remove a patient from the list
    public boolean removePatient(String name, int id) {
        for (Patient patient : patientList) {
            if (patient.check(name, id) == true) {
                return this.patientList.remove(patient);
            }
        }
        return false;
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

    // find patient whith age
    public void findPatientWithAge(int age) {
        for (Patient patient : patientList) {
            if (patient.getAge() == age) {
                System.out.println(patient);
            }
        }
    }

    // find patient whith treatmnet room
    public void findPatientWithTreatmentRoom(String treatmentRoom) {
        System.out.println("Patients treated in room" + treatmentRoom);
        for (Patient patient : patientList) {
            if (patient.getTreatmentRoom() == treatmentRoom) {
                System.out.println(patient);
            }
        }
    }

    // change patient information
    public void changeInformation(String name, int id, int newID, LocalDate born) {
        for (Patient patient : patientList) {
            if (patient.check(name, id) == true) {
                patient.changeInformation(name, born, newID);
            }
        }
    }

    // change medical chart
    public void changeMedicalChart(String name, int id, LocalDate dateIn, LocalDate dateOut, String illness,
            String note) {
        for (Patient patient : patientList) {
            if (patient.check(name, id) == true) {
                patient.changePatientMedicalChart(dateIn, dateOut, illness, note);
            }
        }
    }

    // add medical chart
    public void addMedicalChart(String name, int id, MedicalChart mc) {
        for (Patient patient : patientList) {
            if (patient.check(name, id) == true) {
                patient.setMedicalChart(mc);
            }
        }
    }
}
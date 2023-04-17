import java.util.ArrayList;

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
    public boolean removePatient(String name) {
        for (Patient patient : patientList) {
            if (patient.getName() == name) {
                return patientList.remove(patient);
            } else {
                return false;
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
        System.out.println("Patient who " + age + " years old");
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
    public void changeInformation(String name) {
        for (Patient patient : patientList) {
            if (patient.getName() == name) {
                patient.changeInformation();
            }
        }
    }

    // change medical chart
    public void changeMedicalChart(String name) {
        for (Patient patient : patientList) {
            if (patient.getName() == name) {
                patient.changePatientMedicalChart();
            }
        }
    }

    // add medical chart
    public void addMedicalChart(String name, MedicalChart mc) {
        for (Patient patient : patientList) {
            if (patient.getName() == name) {
                patient.setMedicalChart(mc);
            }
        }
    }
}
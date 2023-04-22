import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PatientList {
    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
    Scanner sc = new Scanner(System.in);
    protected ArrayList<Patient> patientList;

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

    // remove a patient from the list and database
    public boolean removePatient(int id) {
        for (Patient patient : patientList) {
            if (patient.getID() == id) {
                return this.patientList.remove(patient);
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
    public void changeInformation(int id) {
        for (Patient patient : patientList) {
            if (patient.getID() == id) {
                System.out.println("Enter new ID: ");
                int newID = sc.nextInt();
                System.out.println("Enter new name: ");
                sc.nextLine();
                String newName = sc.nextLine();
                LocalDate newBirthDate = null;
                while (newBirthDate == null) {
                    try {
                        System.out.println("Enter date of birth(yyyy-MM-dd): ");
                        String input = sc.nextLine();
                        newBirthDate = LocalDate.parse(input, formatter);
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please try again.");
                    }
                }
                patient.changeInformation(newName, newBirthDate, newID);
            }
        }
    }

    // change medical chart
    public void changeMedicalChart(int id) {
        for (Patient patient : patientList) {
            if (patient.getID() == id) {
                LocalDate dateIn = null;
                while (dateIn == null) {
                    try {
                        System.out.println("Enter date in(yyyy-MM-dd): ");
                        String input = sc.nextLine();
                        dateIn = LocalDate.parse(input, formatter);
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please try again.");
                    }
                }
                LocalDate dateOut = null;
                while (dateOut == null) {
                    try {
                        System.out.println("Enter date out(yyyy-MM-dd): ");
                        String input = sc.nextLine();
                        dateOut = LocalDate.parse(input, formatter);
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please try again.");
                    }
                }
                System.out.println("Enter name of illness: ");
                String illness = sc.nextLine();
                System.out.println("Enter note: ");
                String note = sc.nextLine();
                patient.changePatientMedicalChart(dateIn, dateOut, illness, note);
            } else {
                System.out.println("Ther patinent do not exist");
            }
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
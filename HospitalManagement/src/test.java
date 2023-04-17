import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        String[] nameRoom = new String[10];
        TreatmentRoom[] tmr = new TreatmentRoom[10];
        for (int i = 0; i < 10; i++) {
            nameRoom[i] = "Ward " + Integer.toString(i);
            tmr[i].setName(nameRoom[i]);
        }

        int choose;
        do {
            System.out.println("Menu------------------------");
            System.out.println(
                    "0. exit\n" +
                            "1. Patient management\n" +
                            "2. Treatment room management\n");
            choose = sc.nextInt();
            int choose2;
            if (choose == 1) {
                do {
                    System.out.println(
                            "Patient management menu--------\n" +
                                    "0. Back\n" +
                                    "1. Add a patient\n" +
                                    "2. Remove a paitent\n" +
                                    "3. Edit patient information\n" +
                                    "4. Show list patient information\n" +
                                    "5. Classify patients by age\n" +
                                    "6. Classify patinets by room\n");
                    choose2 = sc.nextInt();
                    if (choose2 == 1) {
                        int choose3;
                        System.out.println("Add a patient to: \n" +
                                "1. Ward number 1\n" +
                                "2. Ward number 2\n" +
                                "3. Ward number 3\n" +
                                "4. Ward number 4\n" +
                                "5. Ward number 5\n" +
                                "6. Ward number 6\n" +
                                "7. Ward number 7\n" +
                                "8. Ward number 8\n" +
                                "9. Ward number 9\n" +
                                "10. Ward number 10\n");
                        choose3 = sc.nextInt();
                        System.out.println("Enter name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter age: ");
                        int age = sc.nextInt();
                        System.out.println("Enter date of birth: ");
                        try {
                            Date born = df.parse(sc.nextLine());
                            System.out.println("Enter ID: ");
                            int id = sc.nextInt();
                            Patient pa = new Patient(name, age, born, id, nameRoom[choose3 - 1]);
                            tmr[choose3 - 1].addPatient(pa);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    } else if (choose2 == 2) {
                        int choose3;
                        System.out.println("Remove a patient from: \n" +
                                "1. Ward number 1\n" +
                                "2. Ward number 2\n" +
                                "3. Ward number 3\n" +
                                "4. Ward number 4\n" +
                                "5. Ward number 5\n" +
                                "6. Ward number 6\n" +
                                "7. Ward number 7\n" +
                                "8. Ward number 8\n" +
                                "9. Ward number 9\n" +
                                "10. Ward number 10\n");
                        choose3 = sc.nextInt();
                        System.out.println("Enter name patient: ");
                        String name = sc.nextLine();
                        tmr[choose3 - 1].removePatient(name);
                    } else if (choose2 == 3) {
                        int choose3;
                        System.out.println("Edit a patient in: \n" +
                                "1. Ward number 1\n" +
                                "2. Ward number 2\n" +
                                "3. Ward number 3\n" +
                                "4. Ward number 4\n" +
                                "5. Ward number 5\n" +
                                "6. Ward number 6\n" +
                                "7. Ward number 7\n" +
                                "8. Ward number 8\n" +
                                "9. Ward number 9\n" +
                                "10. Ward number 10\n");
                        choose3 = sc.nextInt();
                        System.out.println("Enter name patient: ");
                        String name = sc.nextLine();
                        tmr[choose3 - 1].changeInformation(name);
                    } else if (choose2 == 4) {
                        System.out.println("PatientList: ");
                        for (int i = 0; i < 10; i++) {
                            tmr[i].showList();
                        }
                    } else if (choose2 == 5) {
                        System.out.println("Enter age: ");
                        int age = sc.nextInt();
                        System.out.println("List patients " + age + " years old: ");
                        for (int i = 0; i < 10; i++) {
                            tmr[i].findPatientWithAge(age);
                        }
                    } else if (choose2 == 6) {
                        int choose3;
                        System.out.println("Find patients in: \n" +
                                "1. Ward number 1\n" +
                                "2. Ward number 2\n" +
                                "3. Ward number 3\n" +
                                "4. Ward number 4\n" +
                                "5. Ward number 5\n" +
                                "6. Ward number 6\n" +
                                "7. Ward number 7\n" +
                                "8. Ward number 8\n" +
                                "9. Ward number 9\n" +
                                "10. Ward number 10\n");
                        choose3 = sc.nextInt();
                        tmr[choose3 - 1].findPatientWithTreatmentRoom(nameRoom[choose3 - 1]);
                    } else if (choose2 > 6) {
                        System.out.println("Error");
                        continue;
                    }
                } while (choose2 != 0);
            } else if (choose == 2) {
                do {
                    System.out.println(
                            "Select treatment room:\n" +
                                    "0.Back\n" +
                                    "1. Treatment room 1\n" +
                                    "2. Treatment room 2\n" +
                                    "3. Treatment room 3\n" +
                                    "4. Treatment room 4\n" +
                                    "5. Treatment room 5\n" +
                                    "6. Treatment room 6\n" +
                                    "7. Treatment room 7\n" +
                                    "8. Treatment room 8\n" +
                                    "9. Treatment room 9\n" +
                                    "10. Treatment room 10\n");
                    choose2 = sc.nextInt();
                    for (int i = 1; i < 11; i++) {
                        if (i == choose2) {
                            int choose3;
                            do {
                                System.out.println(
                                        "Treatment room menu:\n" +
                                                "0. Out\n" +
                                                "1. Add medical charts\n" +
                                                "2. Change medical charts\n");
                                choose3 = sc.nextInt();
                                if (choose3 == 1) {
                                    System.out.println("Enter patient name: ");
                                    String name = sc.nextLine();
                                    System.out.println("Enter Date in: ");
                                    Date dateIn;
                                    try {
                                        dateIn = df.parse(sc.nextLine());
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                    System.out.println("Enter date out: ");
                                    Date dateOut;
                                    try {
                                        dateOut = df.parse(sc.nextLine());
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                    System.out.println("Enter name of illness: ");
                                    String illness = sc.nextLine();
                                    System.out.println("Enter note: ");
                                    String note = sc.nextLine();
                                    MedicalChart mc = new MedicalChart(dateIn, dateOut, illness, note);
                                }
                            } while (choose3 != 0);
                        }
                    }
                } while (choose2 != 0);
            }
        } while (choose != 0);
    }
}

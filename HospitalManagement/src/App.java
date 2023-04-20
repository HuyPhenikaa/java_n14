import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.sql.*;
import java.util.logging.*;

public class App {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        Scanner sc = new Scanner(System.in);

        String nameRoom1 = "Ward 1";
        String nameRoom2 = "Ward 2";
        String nameRoom3 = "Ward 3";
        String nameRoom4 = "Ward 4";
        String nameRoom5 = "Ward 5";
        String nameRoom6 = "Ward 6";
        String nameRoom7 = "Ward 7";
        String nameRoom8 = "Ward 8";
        String nameRoom9 = "Ward 9";
        String nameRoom10 = "Ward 10";
        ArrayList<String> room = new ArrayList<String>();
        room.add(nameRoom1);
        room.add(nameRoom2);
        room.add(nameRoom3);
        room.add(nameRoom4);
        room.add(nameRoom5);
        room.add(nameRoom6);
        room.add(nameRoom7);
        room.add(nameRoom8);
        room.add(nameRoom9);
        room.add(nameRoom10);
        TreatmentRoom[] tmr = new TreatmentRoom[10];
        for (int i = 0; i < 10; i++) {
            tmr[i] = new TreatmentRoom(room.get(i));
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
                        sc.nextLine();
                        String name = sc.nextLine();
                        LocalDate birthDate = null;
                        while (birthDate == null) {
                            try {
                                System.out.println("Enter date of birth(yyyy-MM-dd): ");
                                String input = sc.nextLine();
                                birthDate = LocalDate.parse(input, formatter);
                            } catch (DateTimeParseException e) {
                                System.out.println("Invalid date format. Please try again.");
                            }
                        }
                        System.out.println("Enter ID: ");
                        int id = sc.nextInt();
                        Patient pa = new Patient(name, birthDate, id, room.get(choose3 - 1));
                        tmr[choose3 - 1].addPatient(pa);
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
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.println("Enter ID: ");
                        int id = sc.nextInt();
                        if (tmr[choose3 - 1].removePatient(name, id) == true) {
                            System.out.println("Done");
                        } else {
                            System.out.println("Can't not find patient");
                        }
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
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.println("Enter ID: ");
                        int id = sc.nextInt();
                        tmr[choose3 - 1].changeInformation(name, id);
                    } else if (choose2 == 4) {
                        System.out.println("PatientList: ");
                        Write write = new Write();
                        write.WriteToBinary(tmr);
                        // for (int i = 0; i < 10; i++) {
                        // tmr[i].showList();
                        // }
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
                        tmr[choose3 - 1].findPatientWithTreatmentRoom(room.get(choose3 - 1));
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
                                                "2. Change medical charts\n" +
                                                "3. Show list information of patient");
                                choose3 = sc.nextInt();
                                if (choose3 == 1) {
                                    System.out.println("Enter patient name: ");
                                    sc.nextLine();
                                    String name = sc.nextLine();
                                    System.out.println("Enter ID: ");
                                    int id = sc.nextInt();
                                    tmr[choose2 - 1].addMedicalChart(name, id);
                                } else if (choose3 == 2) {
                                    System.out.println("Enter patient name: ");
                                    sc.nextLine();
                                    String name = sc.nextLine();
                                    System.out.println("Enter ID: ");
                                    int id = sc.nextInt();
                                    tmr[choose2 - 1].changeMedicalChart(name, id);
                                } else if (choose3 == 3) {
                                    System.out.println("Patient in " + room.get(choose2 - 1));
                                    tmr[choose2 - 1].showList();
                                } else if (choose3 > 3) {
                                    System.out.println("Error");
                                    continue;
                                }
                            } while (choose3 != 0);
                        }
                    }
                } while (choose2 != 0);
            }
        } while (choose != 0);
    }
}

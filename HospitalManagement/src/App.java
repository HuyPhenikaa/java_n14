import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.sql.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        PatientList list = new PatientList();
        String[] nameOfRoom = new String[5];

        for (int i = 0; i < 5; i++) {
            nameOfRoom[i] = "room " + Integer.toString(i + 1);
        }

        int choose;

        do {
            System.out.println("Menu--------------------");
            System.out.println(
                    "0. Exit\n" +
                            "1. Add Patient\n" +
                            "2. Add medical Chart\n" +
                            "3. Hospital Management");
            choose = sc.nextInt();

            if (choose == 1) {
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

                int id;
                do {
                    System.out.println("Enter ID: ");
                    id = sc.nextInt();
                } while (DataProcessing.isPatientExist(id) == true);

                System.out.println("Add patient to: ");
                int choose2;
                for (int i = 0; i < 5; i++) {
                    System.out.println((i + 1) + ". " + nameOfRoom[i]);
                }
                choose2 = sc.nextInt();
                Patient pa = new Patient(name, birthDate, id, nameOfRoom[choose2 - 1]);

                list.addPatient(pa);
                // up du lieu vao data
                DataProcessing.addToDB(pa.getID(), pa.getName(), pa.getAge(), pa.getDayOfBirth(), pa.getMonthOfBirth(),
                        pa.getYearOfBirth(), pa.getTreatmentRoom());
            } else if (choose == 2) {
                int choose2;
                do {
                    System.out.println(
                            "0. Out\n" +
                                    "1. Add Medical Chart\n" +
                                    "2. Show list patient has just arrived");
                    choose2 = sc.nextInt();

                    if (choose2 == 1) {
                        System.out.println("Enter patient ID: ");
                        int id = sc.nextInt();

                        LocalDate dateIn = null;
                        LocalDate dateOut = null;
                        String illness;
                        String note;
                        sc.nextLine();
                        if (list.check(id) == true || DataProcessing.isPatientExist(id) == true) {
                            while (dateIn == null) {
                                try {
                                    System.out.println("Enter date in(yyyy-MM-dd): ");
                                    String input = sc.nextLine();
                                    dateIn = LocalDate.parse(input, formatter);
                                } catch (DateTimeParseException e) {
                                    System.out.println("Invalid date format. Please try again.");
                                }
                            }
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
                            illness = sc.nextLine();
                            System.out.println("Enter note: ");
                            note = sc.nextLine();
                            MedicalChart mc = new MedicalChart(dateIn, dateOut, illness, note);

                            list.addMedicalChart(id, mc);
                            // luu vao datat dung mc.get
                            DataProcessing.addtoDB(id, mc.getDayOfIn(), mc.getMonthOfIn(), mc.getYearOfIn(),
                                    mc.getDayOfOut(), mc.getMonthOfOut(), mc.getYearOfOut(), mc.getIllness(),
                                    mc.getNote());
                        } else {
                            System.out.println("The patient do not exist");
                        }
                    } else if (choose2 == 2) {
                        System.out.println("List patient: ");
                        list.showList();
                    } else if (choose2 > 2) {
                        System.out.println("Invalid. Please try again");
                    }
                } while (choose2 != 0);
            } else if (choose == 3) {
                int choose2;
                do {
                    System.out.println(
                            "0. Out\n" +
                                    "1. Show list of patient\n" +
                                    "2. Show list of patient with age\n" +
                                    "3. Remove Patient\n" +
                                    "4. Change patient information\n" +
                                    "5. Change medical chart information");
                    choose2 = sc.nextInt();

                    if (choose2 == 1) {
                        DataProcessing.showInfo();
                    } else if (choose2 == 2) {
                        System.out.println("Enter age: ");
                        int age = sc.nextInt();
                        DataProcessing.filterAge(age);
                    } else if (choose2 == 3) {
                        System.out.println("Enter patient ID: ");
                        int id = sc.nextInt();
                        // check xem benh nhan co trong data khong
                        if (DataProcessing.isPatientExist(id) == true) {
                            // xoa benh nhan khoi data
                            DataProcessing.removeFromDB(id);
                        }
                    } else if (choose2 == 4) {
                        System.out.println("Enter patient ID: ");
                        int id = sc.nextInt();
                        String newName;
                        LocalDate newBirthOfDate = null;
                        int newID;
                        int choose3;
                        // check xem benh nhan co trong data khong
                        if (DataProcessing.isPatientExist(id) == true) {
                            System.out.println("Enter name: ");
                            sc.nextLine();
                            newName = sc.nextLine();
                            while (newBirthOfDate == null) {
                                try {
                                    System.out.println("Enter date of birth(yyyy-MM-dd): ");
                                    String input = sc.nextLine();
                                    newBirthOfDate = LocalDate.parse(input, formatter);
                                } catch (DateTimeParseException e) {
                                    System.out.println("Invalid date format. Please try again.");
                                }
                            }
                            
                            System.out.println("Enter treatment room: ");
                            for (int i = 0; i < 5; i++) {
                                System.out.println((i + 1) + "." + nameOfRoom[i]);
                            }
                            choose3 = sc.nextInt();
                            Patient pa = new Patient(newName, newBirthOfDate, id, nameOfRoom[choose3 - 1]);
                            DataProcessing.changeInformationToDB(pa.getID(), pa.getName(), pa.getAge(), pa.getDayOfBirth(), pa.getMonthOfBirth(), pa.getYearOfBirth(), pa.getTreatmentRoom());
                        } else {
                            System.out.println("Patient do not exist");
                        }
                    } else if (choose2 == 5) {
                        System.out.println("Enter patient ID: ");
                        int id = sc.nextInt();
                        // check xem benh an cua benh nhan co trong data khong
                        if (DataProcessing.isPatientExist(id, true) == true) {
                            LocalDate newDateIn = null;
                            LocalDate newDateOut = null;
                            String newIllness;
                            String newNote;
                            sc.nextLine();
                            while (newDateIn == null) {
                                try {
                                    System.out.println("Enter date in(yyyy-MM-dd): ");
                                    String input = sc.nextLine();
                                    newDateIn = LocalDate.parse(input, formatter);
                                } catch (DateTimeParseException e) {
                                    System.out.println("Invalid date format. Please try again.");
                                }
                            }
                            while (newDateOut == null) {
                                try {
                                    System.out.println("Enter date out(yyyy-MM-dd): ");
                                    String input = sc.nextLine();
                                    newDateOut = LocalDate.parse(input, formatter);
                                } catch (DateTimeParseException e) {
                                    System.out.println("Invalid date format. Please try again.");
                                }
                            }
                            System.out.println("Enter name of illness: ");
                            newIllness = sc.nextLine();
                            System.out.println("Enter note: ");
                            newNote = sc.nextLine();
                            MedicalChart mc = new MedicalChart(newDateIn, newDateOut, newIllness, newNote);
                            DataProcessing.changeInformationToDB(id, mc.getDayOfIn(), mc.getMonthOfIn(), mc.getYearOfIn(), mc.getDayOfOut(), mc.getMonthOfOut(), mc.getYearOfOut(), mc.getIllness(), mc.getNote());
                        }
                    } else if (choose2 > 5) {
                        System.out.println("Invalid. Please try again");
                    }
                } while (choose2 != 0);
            }
        } while (choose != 0);
    }
}
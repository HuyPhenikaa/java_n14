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
            nameOfRoom[i] = "room" + Integer.toString(i + 1);
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

                System.out.println("Enter ID: ");
                int id = sc.nextInt();

                System.out.println("Add patient to: ");
                int choose2;
                for (int i = 0; i < 5; i++) {
                    System.out.println((i + 1) + nameOfRoom[i]);
                }
                choose2 = sc.nextInt();
                Patient pa = new Patient(name, birthDate, id, nameOfRoom[choose2 + 1]);
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
                        list.addMedicalChart(id);
                    } else if (choose2 == 2) {
                        System.out.println("List patient: ");
                        list.showList();
                    } else if (choose2 > 2) {
                        System.out.println("Invalid. Please try again");
                    }
                } while (choose2 != 0);
            } else if (choose == 3) {
                // cap nhat thong tin vao data

                int choose2;
                do {
                    System.out.println(
                            "0. Out\n" +
                                    "1. Show list of patient\n" +
                                    "2. Show list of patient with age\n" +
                                    "3. remove Patient\n" +
                                    "4. Change patient information\n" +
                                    "5. Change medical chart information");
                    choose2 = sc.nextInt();

                    if (choose2 == 1) {
                        // in danh sach benh nhan tu data
                    } else if (choose2 == 2) {
                        System.out.println("Enter age: ");
                        int age = sc.nextInt();
                        // in danh sach benh nhan theo do tuoi tu data
                    } else if (choose2 == 3) {
                        System.out.println("Enter patient ID: ");
                        int id = sc.nextInt();
                        // check xem benh nhan co trong data khong

                        // xoa benh nhan khoi data
                    } else if (choose2 == 4) {
                        System.out.println("Enter patient ID: ");
                        int id = sc.nextInt();
                        // check xem benh nhan co trong data khong
                        // neu co thi thay thay doi thong tin benh nhan trong data
                    } else if (choose2 == 5) {
                        System.out.println("Enter patient ID: ");
                        int id = sc.nextInt();
                        // check xem benh nhan co trong data khong
                        // neu co thi thay doi thong tin benh an cua benh nhan trong data
                    } else if (choose2 > 5) {
                        System.out.println("Invalid. Please try again");
                    }
                } while (choose2 != 0);
            }
        } while (choose != 0);
    }
}
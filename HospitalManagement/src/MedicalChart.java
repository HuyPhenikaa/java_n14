import java.util.Scanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MedicalChart {
    private LocalDate dateIn;
    private LocalDate dateOut;
    private String illness;
    private String note;
    int check;

    Scanner sc = new Scanner(System.in);

    public MedicalChart(LocalDate dateIn, LocalDate dateOut, String illness, String note) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.illness = illness;
        this.note = note;
        this.check = 1;
    }

    public MedicalChart() {
        this.check = 0;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public void setDateOut(LocalDate dateOut) {
        this.dateOut = dateOut;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getDateIn() {
        return this.dateIn;
    }

    public LocalDate getDateOut() {
        return this.dateOut;
    }

    public String getIllness() {
        return this.illness;
    }

    public String getNote() {
        return this.note;
    }

    public String toString() {
        if (this.check == 1) {
            return "Illness: " + illness + "\n" +
                    "DateIn: " + dateIn.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                    "DateOut: " + dateOut.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                    "Note: " + note;
        } else {
            return "Not found";
        }
    }
}

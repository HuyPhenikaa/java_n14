import java.util.Scanner;
import java.time.LocalDate;

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

    public int getDayOfIn() {
        return this.dateIn.getDayOfMonth();
    }

    public int getMonthOfIn() {
        return (int) this.dateIn.getMonthValue();
    }

    public int getYearOfIn() {
        return this.dateIn.getYear();
    }

    public int getDayOfOut() {
        return this.dateOut.getDayOfMonth();
    }

    public int getMonthOfOut() {
        return (int) this.dateOut.getMonthValue();
    }

    public int getYearOfOut() {
        return this.dateOut.getYear();
    }
}

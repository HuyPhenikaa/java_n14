import java.util.Scanner;
import java.time.LocalDate;

public class Patient extends Person {
    private String treatmentRoom;
    private MedicalChart mc;

    Scanner sc = new Scanner(System.in);

    public Patient(String name, LocalDate born, int id, String treatmentRoom, MedicalChart mc) {
        super(name, born, id);
        this.treatmentRoom = treatmentRoom;
        this.mc = mc;
    }

    public Patient(String name, LocalDate born, int id, String treatmentRoom) {
        super(name, born, id);
        this.treatmentRoom = treatmentRoom;
        this.mc = new MedicalChart();
    }

    public void setTreatmentRoom(String treatmentRoom) {
        this.treatmentRoom = treatmentRoom;
    }

    public void setMedicalChart(MedicalChart mc) {
        this.mc = mc;
    }

    public String getTreatmentRoom() {
        return this.treatmentRoom;
    }

    public int getDayOfIn() {
        return this.mc.getDayOfIn();
    }

    public int getMonthOfIn() {
        return this.mc.getMonthOfIn();
    }

    public int getYearOfIn() {
        return this.mc.getYearOfIn();
    }

    public int getDayOfOut() {
        return this.mc.getDayOfOut();
    }

    public int getMonthOfOut() {
        return this.mc.getMonthOfOut();
    }

    public int getYearOfOut() {
        return this.mc.getYearOfOut();
    }

    public String getIllness() {
        return this.mc.getIllness();
    }

    public String getNote() {
        return this.mc.getNote();
    }
}
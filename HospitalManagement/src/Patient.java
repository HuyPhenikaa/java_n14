import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public String toString() {
        return "Name: " + this.name + "\n" +
                "Age: " + this.age + "\n" +
                "Date of brith: " + born.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n" +
                "Id: " + this.id + "\n" +
                "Treatmentroom: " + this.treatmentRoom + "\n" +
                "Medical Chart: \n" + mc.toString();
    }

    public void changePatientMedicalChart(LocalDate dateIn, LocalDate dateOut, String illness, String note) {
        this.mc.setDateIn(dateIn);
        this.mc.setDateOut(dateOut);
        this.mc.setIllness(illness);
        this.mc.setNote(note);
    }

    public boolean check(String name, int id) {
        if (this.name.equals(name) == true && this.id == id) {
            return true;
        } else {
            return false;
        }
    }
}
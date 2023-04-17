import java.util.Date;
import java.util.Scanner;

public class Patient extends Person {
    private String treatmentRoom;
    private MedicalChart mc;

    Scanner sc = new Scanner(System.in);

    public Patient(String name, int age, Date born, int id, String treatmentRoom, MedicalChart mc) {
        super(name, age, born, id);
        this.treatmentRoom = treatmentRoom;
        this.mc = mc;
    }

    public Patient(String name, int age, Date born, int id, String treatmentRoom) {
        super(name, age, born, id);
        this.treatmentRoom = treatmentRoom;
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

    public String toString() {
        return "Name: " + this.name + "\n" +
                "Age: " + this.age + "\n" +
                "Date of brith: " + df.format(this.born) + "\n" +
                "Id: " + this.id + "\n" +
                "Medical Chart: \n" + mc.toString();
    }

    public void changePatientMedicalChart() {
        mc.changeMedicalChart();
    }
}
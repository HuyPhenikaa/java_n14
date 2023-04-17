import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MedicalChart {
    private Date dateIn;
    private Date dateOut;
    private String illness;
    private String note;

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    public MedicalChart(Date dateIn, Date dateOut, String illness, String note) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.illness = illness;
        this.note = note;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDateIn() {
        return this.dateIn;
    }

    public Date getDateOut() {
        return this.dateOut;
    }

    public String getIllness() {
        return this.illness;
    }

    public String getNote() {
        return this.note;
    }

    public String toString() {
        return "Illness: " + illness + "\n" +
                "DateIn: " + df.format(dateIn) + "\n" +
                "DateOut: " + df.format(dateIn) + "\n" +
                "Note: " + note;
    }
}

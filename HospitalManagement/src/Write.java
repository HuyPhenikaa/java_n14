import java.io.*;

public class Write {
    public void WriteToBinary(TreatmentRoom[] tmr) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Patient.dat");

            for(TreatmentRoom i : tmr) {
                i.showList();
            }

            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}

import java.io.*;

import javax.xml.transform.Source;

public class Write {
    public void WriteToBinary(TreatmentRoom[] tmr) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Patient.dat");

            for(TreatmentRoom i : tmr) {
                System.out.println(i.getName());
                i.printNamePatient();
            }

            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}

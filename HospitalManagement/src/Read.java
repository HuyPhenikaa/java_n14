import java.io.*;

public class Read {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("benh_nhan.dat");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            
            
            
            dataInputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


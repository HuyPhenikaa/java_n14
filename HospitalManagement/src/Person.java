import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Person {
    protected String name;
    protected int age;
    protected Date born;
    protected int id;

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    public Person(String name, int age, Date born, int id) {
        this.name = name;
        this.age = age;
        this.born = born;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public Date getBorn() {
        return this.born;
    }

    public int getID() {
        return this.id;
    }

    public void changeInformation() {
        System.out.println("Name: ");
        String realName = sc.nextLine();
        this.name = realName;
        System.out.println("Age: ");
        int realAge = sc.nextInt();
        this.age = realAge;
        Date realDateBorn;
        try {
            realDateBorn = df.parse(sc.nextLine());
            this.born = realDateBorn;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Id: ");
        int realID = sc.nextInt();
        this.id = realID;
    }
}

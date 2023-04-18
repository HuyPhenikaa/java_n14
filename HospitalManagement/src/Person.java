import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class Person {
    public static LocalDate currentDay = LocalDate.now();
    protected String name;
    protected LocalDate born;
    protected int id;
    protected int age;

    Scanner sc = new Scanner(System.in);

    public Person(String name, LocalDate born, int id) {
        this.name = name;
        this.born = born;
        this.id = id;
        Period period = Period.between(born, currentDay);
        this.age = period.getYears();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public void setAge() {
        Period period = Period.between(born, currentDay);
        this.age = period.getYears();
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

    public LocalDate getBorn() {
        return this.born;
    }

    public int getID() {
        return this.id;
    }

    public void changeInformation(String name, LocalDate born, int id) {
        setName(name);
        setBorn(born);
        setID(id);
        setAge();
    }
}

import java.util.Scanner;

public class Person {
    int id;
    String firstName;
    String lastName;
    Marital maritalStatus;

    public Person() {}

    public void input() {
        Scanner scan = new Scanner(System.in);

        System.out.println("ID:");
        this.id = scan.nextInt();

        System.out.println("firstName:");
        this.firstName = scan.next();

        System.out.println("lastName:");
        this.lastName = scan.next();

        System.out.println("maritalStatus:(SINGLE, MARRIED, DIVORCED)");
        this.maritalStatus = Marital.valueOf(scan.next().toUpperCase());
    }

    @Override
    public String toString() {
        return String.format
                ("ID:%d, firstName:%s, lastName:%s, maritalStatus:%s, ",
                id, firstName, lastName, maritalStatus);
    }
}
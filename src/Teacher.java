import java.util.Scanner;

public class Teacher extends Person{
    int wage;

    public Teacher() {
        super();
    }

    @Override
    public void input() {
        super.input();

        Scanner scan = new Scanner(System.in);
        System.out.println("Teacher Wage:");
        wage = scan.nextInt();
    }

    @Override
    public String toString() {
        System.out.println("Teacher:");
        return super.toString() + String.format("wage:%d." , wage);
    }
}

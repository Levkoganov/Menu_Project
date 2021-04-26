import java.util.Scanner;

public class Score {
    public String course;
    public int value;

    public Score() {}

    public void scoreInput() {
        Scanner scan = new Scanner(System.in);

        System.out.println("course name:");
        this.course = scan.next();

        System.out.println("course value:(0 - 100)");
        this.value = scan.nextInt();
    }

    @Override
    public String toString() {
        return String.format
                ("course:%s, value:%d",
                  course, value);
    }
}

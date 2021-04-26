// JAVA PROJECT BY LEV.K

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        main_loop:
        while (true) {
            System.out.println(
                    "1) Add Teacher\n" +
                    "2) Add Student\n" +
                    "3) Show all People\n" +
                    "4) Show all Teachers\n" +
                    "5) Show all Students\n" +
                    "6) Show Teacher By ID\n" +
                    "7) Show Student By ID\n" +
                    "8) Show Student by score range\n" +
                    "0) QUIT\n\n" +
                    "Select a number:");

                if (scan.hasNextInt()) {
                int option = scan.nextInt();
                switch (option) {

                    case 1:
                        System.out.println("Add Teacher:");
                        Teacher teacher = new Teacher();
                        teacher.input();
                        people.add(teacher);
                        break;

                    case 2:
                        System.out.println("Add Student:");
                        Student student = new Student();
                        student.input();
                        people.add(student);
                        break;

                    case 3:
                        if (people.isEmpty())
                            System.out.println("\"People\" is Empty");
                        for (Person p : people) {
                            System.out.println(p);
                        }
                        break;

                    case 4:
                        int count_Case4 = 0;

                        for (Person p_Teacher : people) {
                            if (p_Teacher instanceof Teacher) {
                                System.out.println(p_Teacher);
                            } else {
                                count_Case4++;
                            }
                        }
                        if (count_Case4 == people.size()) {
                            System.out.println("\"Teacher\" is Empty");
                        }
                        break;

                    case 5:
                        int count_Case5 = 0;

                        for (Person p_Student : people) {
                            if (p_Student instanceof Student) {
                                System.out.println(p_Student);
                            } else {
                                count_Case5++;
                            }
                        }
                        if (count_Case5 == people.size()) {
                            System.out.println("\"Student\" is Empty");
                        }
                        break;

                    case 6:
                        int count_Case6 = 0;

                        System.out.println("Enter Teacher ID:");
                        int teacher_ID = scan.nextInt();

                        for (Person person : people) {
                            if (person.id == teacher_ID) {
                                if (person instanceof Teacher) {
                                    System.out.println(person);
                                } else {
                                    System.out.println("Not a Teacher");
                                }
                            } else {
                                count_Case6++;
                            }
                        }
                        if (count_Case6 == people.size()) {
                            System.out.println("ID Doesn't exist");
                        }
                        break;

                    case 7:
                        int count_Case7 = 0;

                        System.out.println("Enter Student ID:");
                        int student_ID = scan.nextInt();

                        for (Person person : people) {
                            if (person.id == student_ID) {
                                if (person instanceof Student) {
                                    System.out.println(person);
                                    studentMenu((Student) person);
                                } else {
                                    System.out.println("Not a Student");
                                }
                            } else {
                                count_Case7++;
                            }
                        }
                        if (count_Case7 == people.size()) {
                            System.out.println("ID Doesn't exist");
                        }
                        break;

                    case 8:
                        int MIN_SCORE;
                        int MAX_SCORE;
                        int count_Case8 = 0;
                        int counter_Student = 0;

                        System.out.println("Enter MIN Score:");
                        MIN_SCORE = scan.nextInt();

                        System.out.println("Enter MAX Score:");
                        MAX_SCORE = scan.nextInt();

                        for (Person p_Student : people) {
                            if (p_Student instanceof Student) {
                                if ( ((Student) p_Student).getAverageScore(((Student) p_Student).score) >= MIN_SCORE
                                && ((Student) p_Student).getAverageScore(((Student) p_Student).score) <= MAX_SCORE) {
                                    System.out.println(p_Student);
                                } else {
                                    counter_Student++;
                                }
                            } else {
                                count_Case8++;
                                counter_Student++;
                            }
                        }
                        if (count_Case8 == people.size()) {
                            System.out.println("\"Student\" is Empty");
                            counter_Student++;
                        }

                        if (counter_Student == people.size()) {
                            System.out.println("no student between that score range");
                        }
                        break;

                    case 0:
                        System.out.println("QUIT");
                        break main_loop;

                    default:
                        System.out.println("ERROR");
                }

            } else {
                System.out.println("Please enter a number");
                scan.nextLine();
                System.out.println(" ");
            }
        }
    }

    public static void studentMenu (Student student) {
        double sum = 0;
        int count = 0;

        while (true) {
            System.out.println(
                    "a) Show all Scores\n" +
                    "b) Insert new Score\n" +
                    "c) Show Avg Score\n" +
                    "d) Return to Main Menu\n");

            char student_Option = scan.next().charAt(0);
            if (student_Option == 'a') {
                if (student.score.isEmpty())
                    System.out.println("Please add a score");
                for (Score s_Score : student.score) {
                    System.out.println(s_Score);
                }
            }

            if (student_Option == 'b') {
                Score score = new Score();
                score.scoreInput();
                if (score.value >= 0 && score.value <= 100) {
                    student.score.add(score);
                } else {
                    System.out.println("Score must be Between 0 - 100");
                }
            }

            if (student_Option == 'c') {
                if (student.score.isEmpty()) {
                    System.out.println(sum);
                } else {
                    for (Score s_Score : student.score) {
                        sum += s_Score.value;
                        count++;
                    }
                    System.out.println(sum/count);
                    sum = 0;
                    count = 0;
                }
            }

            if (student_Option == 'd') {
                break;
            }
        }
    }
}
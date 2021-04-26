import java.util.ArrayList;

public class Student extends Person {
    ArrayList<Score> score = new ArrayList<>();

    public Student() {}

    @Override
    public void input() {
        super.input();
    }

    @Override
    public String toString() {
        System.out.println("Student:");
        return super.toString() + "AvgScore:" + getAverageScore(score);
    }

    public int getAverageScore(ArrayList<Score> scoreAvg) {
        if (scoreAvg.size() == 0) {
            return 0;
        } else {
        int sum = 0;

        for (Score i : scoreAvg) {
            sum += i.value;
        }
        return sum/scoreAvg.size();
        }
    }
}

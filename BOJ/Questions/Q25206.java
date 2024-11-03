//Question No: 25206
//Title: 너의 평점은
//Tier: Silver V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double totalWeightedScore = 0;
        double totalCreditSum = 0;
        String[] grades = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
        double[] gradePoints = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};

        for (int i = 0; i < 20; i++) {
            String inputLine = reader.readLine();
            StringTokenizer tokenizer = new StringTokenizer(inputLine, " ");
            @SuppressWarnings("unused")
            String subject = tokenizer.nextToken();
            double credit = Double.parseDouble(tokenizer.nextToken());
            String grade = tokenizer.nextToken();

            for (int j = 0; j < grades.length; j++) {
                if (grade.equals(grades[j])) {
                    totalWeightedScore += credit * gradePoints[j];
                    if (!grade.equals("P")) {
                        totalCreditSum += credit;
                    }
                }
            }
        }

        double gpa = totalWeightedScore / totalCreditSum;
        System.out.printf("%.6f%n", gpa);

        reader.close();
    }
}
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();

        // Initialize some to variables to track total, highest, and lowest grades
        int totalGrades = 0;
        int highestGrade = Integer.MIN_VALUE;
        int lowestGrade = Integer.MAX_VALUE;

        for (int i = 1; i <= numStudents; i++) {
            System.out.print("Enter the grade for student " + i + ": ");
            int grade = sc.nextInt();
            
            totalGrades += grade;

            // Update the highest and lowest grade
            if (grade > highestGrade) {
                highestGrade = grade;
            }
            if (grade < lowestGrade) {
                lowestGrade = grade;
            }
        }
        double averageGrade = (double) totalGrades / numStudents;

        // For diplaying the results
        System.out.println("Average Grade: " + averageGrade);
        System.out.println("Highest Grade: " + highestGrade);
        System.out.println("Lowest Grade: " + lowestGrade);
        sc.close();
    }
}

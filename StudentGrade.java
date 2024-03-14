import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Student grade calculator");
        System.out.println("Enter number of subjects:");
        int nS = sc.nextInt();
        int total = 0;

        for (int i = 1; i <= nS; i++) {
            System.out.println("Enter marks obtained in Subject " + i + ":");
            int marks = sc.nextInt();
            total += marks;
        }

        double averP = (double) total / nS;
        char Grade;

        if (averP >= 90) {
            Grade = 'A';
        } else if (averP >= 80) {
            Grade = 'B';
        } else if (averP >= 70) {
            Grade = 'C';
        } else if (averP >= 60) {
            Grade = 'D';
        } else if (averP >= 50) {
            Grade = 'E';
        } else {
            Grade = 'F';
        }

        System.out.println("Total marks scored: " + total);
        System.out.println("Average percentage gained: " + averP + "%");
        System.out.println("Grade: " + Grade);
    }
}

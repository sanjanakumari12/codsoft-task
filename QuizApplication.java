import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static int score = 0;
    private static int questionIndex = 0;
    private static String[][] quiz = {
            {"What is the capital of France?", "A. Paris", "B. Rome", "C. London", "A"},
            {"What is the tallest mammal?", "A. Elephant", "B. Giraffe", "C. Lion", "B"},
            // Add more questions here
    };
    private static Timer timer;

    public static void main(String[] args) {
        startQuiz();
    }

    public static void startQuiz() {
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Moving to the next question.");
                showResult();
            }
        };

        timer.schedule(task, 10000); // Timer for 10 seconds per question
        while (questionIndex < quiz.length) {
            displayQuestion();
            getUserAnswer();
        }
        timer.cancel(); // Cancel the timer when all questions are answered
        showResult();
    }

    public static void displayQuestion() {
        System.out.println("\nQuestion " + (questionIndex + 1) + ": " + quiz[questionIndex][0]);
        for (int i = 1; i < 4; i++) {
            System.out.println(quiz[questionIndex][i]);
        }
    }

    public static void getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your answer (A/B/C): ");
        String userAnswer = scanner.nextLine().toUpperCase();
        if (userAnswer.equals(quiz[questionIndex][4])) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect!");
        }
        questionIndex++;
    }

    public static void showResult() {
        System.out.println("\nQuiz finished!");
        System.out.println("Your score: " + score + "/" + quiz.length);
    }
}

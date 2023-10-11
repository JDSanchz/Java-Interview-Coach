import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Instance of the QuizUI class to start the quiz
            QuizUI quizUI = new QuizUI();
            quizUI.startQuiz();
        });
    }
}

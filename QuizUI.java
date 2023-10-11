import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizUI {
    private JFrame frame;
    private List<Question> questions;
    private int currentQuestionIndex;
    private int correctAnswers;
    private JLabel questionLabel;
    private JRadioButton[] answerOptions;
    private ButtonGroup buttonGroup;
    private JButton submitButton;
    private JLabel scoreLabel;
    private Timer delayTimer; // Timer for the delay before restarting the quiz

    public QuizUI() {
        // Initialize the frame and other UI components here
        frame = new JFrame("Java Technical Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLayout(new BorderLayout());

        // Load questions from a QuestionBank instance
        questions = QuestionBank.loadQuestions();

        // Initialize UI components
        questionLabel = new JLabel();
        frame.add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));
        answerOptions = new JRadioButton[4];
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            answerOptions[i] = new JRadioButton();
            optionsPanel.add(answerOptions[i]);
            buttonGroup.add(answerOptions[i]);
        }
        frame.add(optionsPanel, BorderLayout.CENTER);

        submitButton = new JButton("Submit");
        frame.add(submitButton, BorderLayout.SOUTH);

        // Initialize score label
        scoreLabel = new JLabel();
        frame.add(scoreLabel, BorderLayout.EAST);

        // Add action listener for the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });

        // Initialize the delay timer
        delayTimer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartQuiz();
            }
        });
    }

    public void startQuiz() {
        currentQuestionIndex = 0;
        correctAnswers = 0;
        Collections.shuffle(questions); // Shuffle the questions for randomness
        showNextQuestion();
        frame.setVisible(true);
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            questionLabel.setText(currentQuestion.getQuestionText());
            List<String> options = currentQuestion.getAnswerOptions();
            for (int i = 0; i < 4; i++) {
                answerOptions[i].setText(options.get(i));
                answerOptions[i].setSelected(false);
            }
            currentQuestionIndex++;
        } else {
            // All questions have been answered, display the final score
            questionLabel.setText("Quiz completed!");
            submitButton.setEnabled(false);
            scoreLabel.setText("Score: " + correctAnswers + "/" + questions.size());

            // Start the delay timer
            delayTimer.start();
        }
    }

    private void checkAnswer() {
        Question currentQuestion = questions.get(currentQuestionIndex - 1);
        int selectedOption = -1;
        for (int i = 0; i < 4; i++) {
            if (answerOptions[i].isSelected()) {
                selectedOption = i;
                break;
            }
        }
        if (selectedOption == currentQuestion.getCorrectAnswerIndex()) {
            correctAnswers++;
        }
        showNextQuestion();
    }

    private void restartQuiz() {
        // Reset quiz state
        currentQuestionIndex = 0;
        correctAnswers = 0;
        Collections.shuffle(questions); // Shuffle the questions for randomness
        showNextQuestion();
        scoreLabel.setText(""); // Clear the score label
        submitButton.setEnabled(true); // Enable the submit button
        delayTimer.stop(); // Stop the delay timer
    }
}

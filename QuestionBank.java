import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    public static List<Question> loadQuestions() {
        List<Question> questions = new ArrayList<>();

        // Question 1
        questions.add(new Question(
                "What is the purpose of 'public static void main(String[] args)' in Java?",
                List.of("To define instance variables", "To initialize objects", "To declare methods", "To start program execution"),
                3 // Correct answer index
        ));

        // Question 2
        questions.add(new Question(
                "Which data structure uses LIFO (Last-In-First-Out) order?",
                List.of("Queue", "Array", "Stack", "Linked List"),
                2 // Correct answer index
        ));

        // Question 3
        questions.add(new Question(
                "What is the time complexity of the quicksort algorithm in the average case?",
                List.of("O(1)", "O(n)", "O(n log n)", "O(n^2)"),
                2 // Correct answer index
        ));

        // Question 4
        questions.add(new Question(
                "In Java, which keyword is used to implement multiple inheritance?",
                List.of("inherit", "extends", "implements", "inheritance"),
                1 // Correct answer index
        ));

        // Question 5
        questions.add(new Question(
                "What is the purpose of the 'super' keyword in Java?",
                List.of("To call a superclass constructor", "To define a subclass", "To override a method", "To create a new object"),
                0 // Correct answer index
        ));

        // Question 6
        questions.add(new Question(
                "Which Java collection class allows duplicate elements?",
                List.of("HashSet", "ArrayList", "TreeSet", "HashMap"),
                1 // Correct answer index
        ));

        // Question 7
        questions.add(new Question(
                "What is the default value of a boolean in Java?",
                List.of("true", "false", "0", "1"),
                1 // Correct answer index
        ));

        // Question 8
        questions.add(new Question(
                "Which loop in Java is used to iterate over elements of an array or a collection?",
                List.of("for loop", "while loop", "do-while loop", "enhanced for loop"),
                3 // Correct answer index
        ));

        // Question 9
        questions.add(new Question(
                "What is the difference between '== ' and '.equals()' when comparing strings in Java?",
                List.of("There is no difference", "== compares content, .equals() compares references", "== compares references, .equals() compares content", "Both compare content and references"),
                2 // Correct answer index
        ));

        // Question 10
        questions.add(new Question(
                "What is the purpose of the 'finally' block in a try-catch-finally statement?",
                List.of("To define catch clauses", "To handle exceptions", "To specify the type of exception", "To execute cleanup code"),
                3 // Correct answer index
        ));

        // Question 11
        questions.add(new Question(
                "In Java, what keyword is used to explicitly specify that a method cannot be overridden?",
                List.of("override", "final", "private", "static"),
                1 // Correct answer index
        ));

        // Question 12
        questions.add(new Question(
                "What is the Java keyword used to refer to the current object inside a method?",
                List.of("self", "this", "me", "current"),
                1 // Correct answer index
        ));


        return questions;
    }
}



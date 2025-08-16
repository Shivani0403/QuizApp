import java.util.*;

class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswerIndex; // 0-based

    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(int userChoice) {
        return userChoice == correctAnswerIndex;
    }

    public String getCorrectAnswer() {
        return options.get(correctAnswerIndex);
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ✅ List of questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
                "Which language is used for Android app development?",
                Arrays.asList("C++", "Java", "Python", "Kotlin"), 3));
        questions.add(new Question(
                "Who is the father of Java?",
                Arrays.asList("Dennis Ritchie", "James Gosling", "Bjarne Stroustrup", "Guido van Rossum"), 1));
        questions.add(new Question(
                "What does OOP stand for?",
                Arrays.asList("Object Oriented Programming", "Open Our Program", "Only Object Protocol", "Optional Oriented Process"), 0));
        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                Arrays.asList("implement", "this", "extends", "super"), 2));

        int score = 0;

        System.out.println("===== Welcome to the Quiz Application =====");
        System.out.println("Total Questions: " + questions.size() + "\n");

        // ✅ Loop through each question
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + q.getQuestionText());

            // Show options
            List<String> options = q.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            // Accept answer
            System.out.print("Your answer (1-" + options.size() + "): ");
            int userChoice = sc.nextInt() - 1;

            // Check correctness
            if (q.isCorrect(userChoice)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct Answer: " + q.getCorrectAnswer() + "\n");
            }
        }

        // ✅ Final score
        System.out.println("===== Quiz Over =====");
        System.out.println("Your final score: " + score + "/" + questions.size());

        sc.close();
    }
}
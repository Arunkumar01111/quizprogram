import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    char correctAnswer;

    public Question(String questionText, String[] options, char correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }


    public boolean isCorrect(char answer) {
        return answer == correctAnswer;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((char) ('A' + i) + ". " + options[i]);
        }
    }
}

public class Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Question[] questions = new Question[] {
                new Question("What is the capital of India?", new String[] {"Mumbai", "New Delhi", "Bangalore", "Chennai"}, 'B'),
                new Question("What is 2 + 2?", new String[] {"3", "4", "5", "6"}, 'B'),
                new Question("Which language is primarily used for Android development?", new String[] {"Java", "Swift", "Python", "C#"}, 'A')
        };

        int score = 0;

        for (Question question : questions) {
            question.displayQuestion();
            System.out.print("Your answer: ");
            char answer = scanner.next().toUpperCase().charAt(0);
            if (question.isCorrect(answer)) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Wrong! The correct answer is " + question.correctAnswer + ".\n");
            }
        }

        System.out.println("Quiz over! Your score is: " + score + "/" + questions.length);
        scanner.close();
    }
}

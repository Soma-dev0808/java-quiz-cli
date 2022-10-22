
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private int score;
    private List<Question> questions;

    public Quiz() {
        this.score = 0;
        this.questions = new ArrayList<Question>(
                Arrays.asList(
                        new Question(
                                "General Knowledge",
                                Difficulty.MEDIUM,
                                "What does a milliner make and sell?",
                                "Hats",
                                Arrays.asList("Shoes", "Belts", "Hats", "Shirts")),
                        new Question(
                                "General Knowledge",
                                Difficulty.EASY,
                                "On a dartboard, what number is directly opposite No. 1?",
                                "19",
                                Arrays.asList("20", "19", "12", "15")),
                        new Question(
                                "General Knowledge",
                                Difficulty.MEDIUM,
                                "What is the unit of currency in Laos?",
                                "Kip",
                                Arrays.asList("Ruble", "Konra", "Dollar", "Kip")),
                        new Question(
                                "General Knowledge",
                                Difficulty.HARD,
                                "\"Number 16 Bus Shelter\" was a child's name that was approved by the New Zealand government.",
                                "True",
                                Arrays.asList("True", "False")),
                        new Question(
                                "General Knowledge",
                                Difficulty.HARD,
                                "What is the name of the popular animatronic singing fish prop, singing such hits such as \"Don't Worry, Be Happy\"",
                                "Big Mouth Billy Bass",
                                Arrays.asList("Big Billy Bass", "Singing Fish", "Sardeen", "Big Mouth Billy Bass")),
                        new Question(
                                "General Knowledge",
                                Difficulty.EASY,
                                "The Sun rises from the North.",
                                "False",
                                Arrays.asList("True", "False")),
                        new Question(
                                "General Knowledge",
                                Difficulty.MEDIUM,
                                "The website \"Shut Up & Sit Down\" reviews which form of media?",
                                "Board Games",
                                Arrays.asList("Television Shows", "Video Games", "Films", "Board Games")),
                        new Question(
                                "General Knowledge",
                                Difficulty.EASY,
                                "Which of the following is the IATA code for Manchester Airport?",
                                "MAN",
                                Arrays.asList("EGLL", "MAN", "LHR", "EGCC")),
                        new Question(
                                "General Knowledge",
                                Difficulty.MEDIUM,
                                "Which country drives on the left side of the road?",
                                "Japan",
                                Arrays.asList("Germany", "Japan", "Russia", "China")),
                        new Question(
                                "General Knowledge",
                                Difficulty.MEDIUM,
                                "The British organisation CAMRA stands for The Campaign for Real Ale.",
                                "True",
                                Arrays.asList("True", "False"))));

    }

    public List<Question> getQuiz() {
        return this.questions;
    }

    // Check answer and return if it's correct. If it's correct, increase score.
    public boolean answer(int selectedNum, Question question) {
        if (question.checkAnswer(selectedNum)) {
            this.score += 1;
            return true;
        }

        return false;
    }

    // Return score
    public int getScore() {
        return this.score;
    }

    // Check user input until receive valid number.
    // If input is within 1 ~ qNum, return input number.
    public int inputInt(Scanner scanner, int qNum) {
        while (true) {
            try {
                int inputNum = scanner.nextInt();
                if (inputNum < 1 || inputNum > qNum) {
                    throw new java.util.InputMismatchException();
                }

                return inputNum;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please input number : 1 ~ " + qNum);
                scanner.nextLine();
            }
        }
    }

    // Print result of user answer
    public void printAnswerResult(boolean isCorrect) {
        System.out.println("**************");
        System.out.println("*            *");
        if (isCorrect) {
            System.out.println("* Correct!!! *");
        } else {
            System.out.println("* Wrong..... *");
        }
        System.out.println("*            *");
        System.out.println("**************");
    }

    public void showResult(int score) {
        System.out.println("Finished!!");
        System.out.println("Your score is ...." + this.score);

        switch (score) {
            case 1, 2, 3:
                System.out.println("Don't give up!!!");
                break;
            case 4, 5, 6:
                System.out.println("Nice try!!!");
                break;
            case 7, 8, 9:
                System.out.println("Almost there!!!");
                break;
            case 10:
                System.out.println("You've got perfect score!!! Keep it up!!!");
                break;
            default:
                System.out.println("Invalid score.....");
                break;
        }
    }

    public void playGame() {
        int ans = 0;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("==================================");
        System.out.println("Game start");
        System.out.println("You have " + this.questions.size() + " questions to solve.");

        try {

            do {
                Question question = this.questions.remove(this.questions.size() - 1);
                count += 1;

                System.out.println("==================================");
                System.out.println("Question " + count);
                System.out.println("Difficulty: " + question.getDiffifculty());
                System.out.println(question.getQuestion());
                System.out.println("= = = = = = = = = = = = = = = = = ");

                // Display choices
                int index = 0;
                for (String choice : question.getChoices()) {
                    index += 1;
                    System.out.println(index + ": " + choice);
                }

                System.out.println("= = = = = = = = = = = = = = = = = ");

                System.out.print("Choose a number: ");

                // Get user input
                ans = this.inputInt(scanner, index) - 1;

                // Check answer
                boolean res = this.answer(ans, question);

                // Print wheter it's correct or not.
                this.printAnswerResult(res);

                System.out.println();
                System.out.println();

            } while (this.questions.size() != 0);

            this.showResult(this.score);

            scanner.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

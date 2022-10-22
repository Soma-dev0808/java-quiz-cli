import java.util.List;

enum Difficulty {
    EASY,
    MEDIUM,
    HARD
}

public class Question {
    private String category;
    private Difficulty difficulty;
    private String question;
    private String correct_answer;
    private List<String> choices;

    public Question(
            String category,
            Difficulty difficulty,
            String question,
            String correct_answer,
            List<String> choices) {
        this.category = category;
        this.difficulty = difficulty;
        this.question = question;
        this.correct_answer = correct_answer;
        this.choices = choices;
    }

    public String getCategory() {
        return this.category;
    }

    public String getQuestion() {
        return this.question;
    }

    public Difficulty getDiffifculty() {
        return this.difficulty;
    }

    public List<String> getChoices() {
        return this.choices;
    }

    public boolean checkAnswer(int selectedNum) {
        return correct_answer == choices.get(selectedNum);
    }

}

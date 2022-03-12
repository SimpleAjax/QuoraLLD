package models;

public class Answer extends Post{
    private final Question question;
    public Answer(String id, User user, String description, String summary, Question question) {
        super(id, user, description, summary);
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "question id =" + question.getId() +
                super.toString() +
                '}';
    }
}

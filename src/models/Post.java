package models;

public class Post {
    private final String id;
    private final User user;
    private String description;
    private String summary;
    // TODO: Ask if the votes should be present here or Vote should contain post_id just like 'Comment' does
    final private Vote vote;

    public Post(String id, User user, String description, String summary) {
        this.id = id;
        this.description = description;
        this.summary = summary;
        this.user = user;
        vote = new Vote();
    }

    public User getUser() {
        return user;
    }

    public Vote getVote() {
        return vote;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", summary='" + summary + '\'' +
                ", vote=" + vote +
                '}';
    }
}

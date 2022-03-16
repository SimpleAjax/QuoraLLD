package models;

public class Comment {
    private final String postId;
    private String content;
    // TODO: should it be 'User' or 'userId' ?
    private final String userId;

    public Comment(String postId, String userId, String content) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
    }

    public String getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "postId='" + postId + '\'' +
                ", content='" + content + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}

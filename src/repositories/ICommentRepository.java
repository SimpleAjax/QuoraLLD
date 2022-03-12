package repositories;

import models.Comment;

import java.util.List;

public interface ICommentRepository {
    void add(Comment comment);

    List<Comment> get(String postId);

    void printState();
}

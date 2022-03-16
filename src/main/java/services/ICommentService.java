package services;

import models.Comment;
import models.Post;
import models.User;

import java.util.List;

public interface ICommentService {
    void postComment(Comment comment);
    List<Comment> getComments(String postId);
    void printState();
}

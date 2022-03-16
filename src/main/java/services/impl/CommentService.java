package services.impl;

import models.Comment;
import models.Post;
import repositories.ICommentRepository;
import repositories.impl.CommentRepository;
import services.ICommentService;

import java.util.List;

public class CommentService implements ICommentService {
    ICommentRepository commentRepository;

    public CommentService(ICommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void postComment(Comment comment) {
        commentRepository.add(comment);
    }

    @Override
    public void printState() {
        System.out.println("printing comment repo");
        commentRepository.printState();
    }

    public List<Comment> getComments(String postId) {
        return commentRepository.get(postId);
    }
}

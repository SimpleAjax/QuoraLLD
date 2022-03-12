package repositories.impl;

import models.Comment;
import repositories.ICommentRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepository implements ICommentRepository {

    Map<String, List<Comment>> postIdVsComment;

    public CommentRepository() {
        postIdVsComment = new HashMap<>();
    }

    @Override
    public void add(Comment comment) {
        List<Comment> comments = postIdVsComment.getOrDefault(comment.getPostId(), new ArrayList<>());
        comments.add(comment);
        postIdVsComment.put(comment.getPostId(), comments);
    }

    @Override
    public List<Comment> get(String postId) {
        return postIdVsComment.get(postId);
    }

    @Override
    public void printState() {
        System.out.println(postIdVsComment);
    }
}

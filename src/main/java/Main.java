

import models.*;
import repositories.IAnswerRepository;
import repositories.ICommentRepository;
import repositories.IQuestionRepository;
import repositories.impl.AnswerRepository;
import repositories.impl.CommentRepository;
import repositories.impl.QuestionRepository;
import services.ICommentService;
import services.IPostService;
import services.IUserFeedService;
import services.impl.CommentService;
import services.impl.PostService;
import services.impl.UserFeedService;

public class Main {
    public static void main(String[] args) {

        IQuestionRepository questionRepository = new QuestionRepository();
        IAnswerRepository answerRepository = new AnswerRepository();
        ICommentRepository commentRepository = new CommentRepository();

        ICommentService commentService = new CommentService(commentRepository);
        IPostService postService = new PostService(questionRepository, answerRepository);
        IUserFeedService userFeedService = new UserFeedService(questionRepository, answerRepository);

        User user1 = new User("user1", "user1");
        User user2 = new User("user2", "user2");
        User user3 = new User("user3", "user3");
        User user4 = new User("user4", "user4");
        User user5 = new User("user5", "user5");

        // post question1 by user1
        Question question1 = new Question("question1", user1,
                "question1 description", "question1 summary");
        postService.postQuestion(question1);

        // post question2 by user2
        Question question2 = new Question("question2", user2,
                "question2 description", "question2 summary");
        postService.postQuestion(question2);

        // answer11 to question1 by user 3
        Answer answer11 = new Answer("answer11", user3,
                "answer11 description", "answer11 summary", question1);
        postService.postAnswer(answer11);

        // answer12 to question1 by user 2
        Answer answer12 = new Answer("answer12", user2,
                "answer12 description", "answer12 summary", question1);
        postService.postAnswer(answer12);
        // comment21 on question2 by user 5
        Comment comment21 = new Comment(question2.getId(), user5.getId(), "comment21 content");
        commentService.postComment(comment21);

        // comment112 on answer11 by user 3
        Comment comment112 = new Comment(answer11.getId(), user5.getId(), "comment112 content");
        commentService.postComment(comment112);

        // upvote answer12 by user 4
        postService.upvotePost(user4, answer12);

        // downvote question2 by user3
        postService.downvotePost(user3, question2);

        // userfeed fetched by some user
        UserFeed userFeed = userFeedService.getUserFeed(user1);

        postService.printState();
        commentService.printState();
        System.out.println(userFeed);
        System.out.println("completed");
    }
}

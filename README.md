# QuoraLLD
LLD for Quora

Design Quora. Requirements:
> User should be able to ask questions.<br/>
> user should be able to give answers<br/>
> User should be able to add comments to questions and comments<br/>
> User should be able to upvote/downvote a question/answer<br/>
> User sees a feed (where a mix of top questions/answers show up)<br/>



APIs:
>postQuestion(Question question, User user)<br/>
>postAnswer(Answer answer, User user)<br/>
>postComment(Comment comment, User user, String post_id)<br/>
>postVote(Vote voteState, String user_id, String post_id)<br/>
>getUserFeed(User user)<br/>



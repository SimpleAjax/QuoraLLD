# QuoraLLD
LLD for Quora

Design Quora. Requirements:
	User should be able to ask questions
	user should be able to give answers
	User should be able to add comments to questions and comments
	User should be able to upvote/downvote a question/answer
	User sees a feed (where a mix of top questions/answers show up)



APIs:
	postQuestion(Question question, User user)
	postAnswer(Answer answer, User user)
	postComment(Comment comment, User user, String post_id)
	postVote(Vote voteState, String user_id, String post_id)
	getUserFeed(User user)



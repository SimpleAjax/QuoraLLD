# QuoraLLD
LLD for Quora

Design Quora. Requirements:
	• User should be able to ask questions
	• user should be able to give answers
	• User should be able to add comments to questions and comments
	• User should be able to upvote/downvote a question/answer
	• User sees a feed (where a mix of top questions/answers show up)



APIs:
	1. postQuestion(Question question, User user)
	2. postAnswer(Answer answer, User user)
	3. postComment(Comment comment, User user, String post_id)
	4. postVote(Vote voteState, String user_id, String post_id)
	5. getUserFeed(User user)



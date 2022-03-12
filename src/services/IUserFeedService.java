package services;

import models.User;
import models.UserFeed;

public interface IUserFeedService {
    UserFeed getUserFeed(User user);
}

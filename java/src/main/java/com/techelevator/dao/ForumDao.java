package com.techelevator.dao;

import com.techelevator.model.Comments;
import com.techelevator.model.Forum;
import java.util.List;

public interface ForumDao {


    List<Forum>findAllForums();

    Forum findForumByTopic (String topic);

    Forum addForum (Forum forum);

    int findIdByTopic (String topic);
}

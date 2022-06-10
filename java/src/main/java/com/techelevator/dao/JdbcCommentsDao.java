package com.techelevator.dao;

import com.techelevator.model.Book;
import com.techelevator.model.Comments;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcCommentsDao implements CommentsDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcCommentsDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}


    @Override
    public List<Comments> getAllComments() {
        String sql = "SELECT * FROM comments";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql);
        List<Comments> comments = new ArrayList<>();
        while (results.next()) {
            comments.add(commentsObjectMapper(results));
        }
        return comments;

    }

    @Override
    public Comments findCommentById(int commentId) {
        return null;
    }

    @Override
    public Comments addComment(Comments comments) {
        String commentsSql = "INSERT INTO comments (forum_id, comment_title, comments)" +
                    "VALUES (?,?, ?)" +
                    "RETURNING comment_id;";

        int commentId = jdbcTemplate.queryForObject(commentsSql, Integer.class, comments.getForumId(), comments.getCommentTitle(), comments.getComments());

        String retrieveId = "SELECT * FROM comments WHERE comment_id;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(retrieveId, commentId);

        if (result.next()){
            comments = commentsObjectMapper(result);
        }
        return comments;

    }

//    @Override
//    public List<Comments> findAllCommentsByUserId(int userId) {
//        String sql = "SELECT * FROM comments" +
//                "JOIN user_comments ON comments.comment_by = user_comments.user_id" +
//                "WHERE user_id = ?;";
//        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, userId);
//        List<Comments> comments = new ArrayList<>();
//        while (results.next()) {
//            comments.add(commentsObjectMapper(results));
//
//        }
//        return comments;
//    }

    @Override
    public List<Comments> findAllCommentsByForumId(int forumId) {
        String sql = "SELECT * FROM comments" +
                "JOIN forum ON comments.forum_id = forum.forum_id" +
                "WHERE forum_id = ?;";
        SqlRowSet results = this.jdbcTemplate.queryForRowSet(sql, forumId);
        List<Comments> comments = new ArrayList<>();
        while (results.next()) {
            comments.add(commentsObjectMapper(results));

        }
        return comments;
    }


    private Comments commentsObjectMapper(SqlRowSet results){

        Comments comments = new Comments();
        comments.setCommentId(results.getInt("comment_id"));
        comments.setForumId(results.getInt("forum_id"));
        comments.setComments(results.getString("comment_title"));
        comments.setComments(results.getString("comments"));
//        comments.setCommentDate(LocalDate.parse(results.getString("comment_date")));


        return comments;
    }
}

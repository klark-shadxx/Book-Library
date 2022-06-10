package com.techelevator.controller;

import com.techelevator.dao.BookDao;
import com.techelevator.dao.CommentsDao;
import com.techelevator.dao.ForumDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class AppController {


    @Autowired
    BookDao bookDao;

    @Autowired
    CommentsDao commentsDao;

    @Autowired
    ForumDao forumDao;


    @Autowired
    UserDao userDao;

    // BOOK URL REQUESTS
    //update book status
    @RequestMapping(path = "/addBook", method = RequestMethod.POST)
    public Book addNewBook(@RequestBody Book book) {
        //System.out.println("DEBUG, what the object looks like:");
        return bookDao.addBook(book);
    }

    @RequestMapping(path = "/allBooks", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return bookDao.findAllBooks();
    }

    @RequestMapping(path = "/book/title", method = RequestMethod.GET)
    public Book bookTitle(@PathVariable String title) {
        // System.out.println("DEBUG, what the object looks like: ");
        return bookDao.findBookByTitle(title);
    }
//    @RequestMapping(path = "/updateBook/{id}", method = RequestMethod.PUT)
//    public Book updateBook(@RequestBody Book book, @PathVariable int bookId)throws  {
//        // System.out.println("DEBUG, what the object looks like: ");
//        return bookDao.updateBook(book, bookId);
//    }
    @RequestMapping(path = "/myBooks/character", method = RequestMethod.GET)
    public Book myBooksByCharacter(@PathVariable String character) {
        // System.out.println("DEBUG, what the object looks like: ");
        return bookDao.findBookByCharacter(character);

    }

    @RequestMapping(path = "/myBooks/genre", method = RequestMethod.GET)
    public Book myBooksByGenre(@PathVariable String genre) {
        // System.out.println("DEBUG, what the object looks like: ");
        return bookDao.findBookByGenre(genre);

    }

    @RequestMapping(path = "/myBooks/keyword", method = RequestMethod.GET)
    public Book myBooksByKeyword(@PathVariable String keyword) {
        // System.out.println("DEBUG, what the object looks like: ");
        return bookDao.findBookByKeyword(keyword);

    }

    @RequestMapping(path = "/myBooks/author", method = RequestMethod.GET)
    public Book myBooksByAuthor(@PathVariable String author) {
        // System.out.println("DEBUG, what the object looks like: ");
        return bookDao.findBookByAuthor(author);

    }

    // COMMENTS URL REQUESTS
    @RequestMapping(path = "/comment", method = RequestMethod.GET)
    public List<Comments> getComments() {
        return commentsDao.getAllComments();
    }

//    @RequestMapping(path = "/userComment/{id}", method = RequestMethod.GET)
//    public List<Comments> getCommentsByUser(@PathVariable int userId) {
//        return commentsDao.findAllCommentsByUserId(userId);
//    }
    @RequestMapping(path = "/forumComment/{id}", method = RequestMethod.GET)
    public List<Comments> getCommentsByForum(@PathVariable int forumId) {
        return commentsDao.findAllCommentsByForumId(forumId);
    }
    @RequestMapping(path = "/addComment", method = RequestMethod.POST)
    public Comments addNewComment(@RequestBody CommentsDTO commentsDTO) {
        System.out.println("DEBUG, what the object looks like:" + commentsDTO);
        int forumId = forumDao.findIdByTopic(commentsDTO.getTopic());

        Comments comments = new Comments();
        comments.setForumId(forumId);
        comments.setCommentTitle(commentsDTO.getCommentTitle());
        comments.setComments(commentsDTO.getComments());
         commentsDao.addComment(comments);
        return null;
    }
    // FORUM URL REQUESTS

    @RequestMapping(path = "/forum", method = RequestMethod.GET)
    public List<Forum> getForums() {
        return forumDao.findAllForums();
    }

    @RequestMapping(path = "/forum/{topic}", method = RequestMethod.GET)
    public Forum forumTopic(@PathVariable String topic) {
        // System.out.println("DEBUG, what the object looks like: ");
        return forumDao.findForumByTopic(topic);
    }

    @RequestMapping(path = "/addForum", method = RequestMethod.POST)
    public Forum addNewForum(@RequestBody ForumDTO forumDTO) {
        System.out.println("DEBUG, what the object looks like:" + forumDTO);
        int userId = userDao.findIdByUsername(forumDTO.getUsername());

        Forum forum = new Forum();
        forum.setUserId(userId);
        forum.setForumTopic(forumDTO.getTopic());

        forumDao.addForum(forum);

        return null;

//        System.out.println(forum);

//    @RequestMapping(path = "/addForum", method = RequestMethod.POST)
//    public Forum addNewForum(@RequestBody Forum forum) {
//        //System.out.println("DEBUG, what the object looks like:");
//        System.out.println(forum);
//        return forumDao.addForum(forum);
    }


//    @RequestMapping(path = "/addForum", method = RequestMethod.POST)
//    public Forum addNewForum(@RequestBody ForumDTO forumDTO) {
//        System.out.println("DEBUG, what the object looks like:");
//        System.out.println(forum);
//        return forumDao.addForum(forum);
//        System.out.println("hello?");
//        System.out.println(forumDTO.getTopic() + " " + forumDTO.getUsername());

//        // Build a forum object
//        // 1. find out what the user id is, we know what the username is.
//
//        // 2. get the current date
//        LocalDate currentDate = LocalDate.now();
//
//        // 3. Forum ID: ?
//
//        // 4. Call your dao method
//        //        return forumDao.addForum(forum);
//
//        return null;
}
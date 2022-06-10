package com.techelevator.model;

public class CommentsDTO {

    private String topic;
    private String commentTitle;
    private String comments;

    @Override
    public String toString() {
        return "CommentsDTO{" +
                "topic='" + topic + '\'' +
                ", commentTitle='" + commentTitle + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

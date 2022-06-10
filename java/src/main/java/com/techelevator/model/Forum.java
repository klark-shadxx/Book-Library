package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class Forum {

        private int forumId;
        private int userId;
        private String forumTopic;
//        private LocalDate forumDate;



        public Forum () {}

        public Forum(String forumTopic) {
        this.userId = userId;
        this.forumTopic = forumTopic;
//        this.forumDate = forumDate;
    }

    public Forum(int forumId, int userId, String forumTopic) {
        this.forumId = forumId;
        this.userId = userId;
        this.forumTopic = forumTopic;
//        this.forumDate = forumDate;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getForumTopic() {
        return forumTopic;
    }

    public void setForumTopic(String forumTopic) {
        this.forumTopic = forumTopic;
    }
//    public LocalDate getForumDate() {
//        return forumDate;
//    }

//    public void setForumDate(LocalDate forumDate) {
//        this.forumDate = forumDate;
//    }



    @Override
    public String toString() {
        return "Forum{" +
                "forumId=" + forumId +
                ", userId=" + userId +
                ", forumTopic='" + forumTopic +
//                ", forumDate=" + forumDate +
                '}';
    }
}



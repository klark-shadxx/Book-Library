package com.techelevator.model;

public class ForumDTO {

    private String username;

    @Override
    public String toString() {
        return "ForumDTO{" +
                "username='" + username + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }

    private String topic;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}

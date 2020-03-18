package com.kodilla.patterns.strategy.social;


public class User {
    final private String userName;
    protected SocialPublisher socialPublisher;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String share(){
        return socialPublisher.sharePost();
    }

    public void sharePost(SocialPublisher socialPublisher){
        this.socialPublisher=socialPublisher;
    }
}


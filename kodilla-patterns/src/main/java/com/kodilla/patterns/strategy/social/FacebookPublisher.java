package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class FacebookPublisher implements SocialPublisher{
    @Override
    public String sharePost(){
        return "Facebook post shared!";
    }
}







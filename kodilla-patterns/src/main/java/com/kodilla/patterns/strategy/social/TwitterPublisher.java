package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class TwitterPublisher implements SocialPublisher{
    @Override
    public String sharePost(){
        return "Twitter post shared!";
    }
}

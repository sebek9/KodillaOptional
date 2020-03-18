package com.kodilla.stream.forumuser;


import java.time.LocalDate;
import java.time.Month;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class StreamMain {
    public static void main(String[] args) {
        Forum theForumUsers = new Forum();

        LocalDate today= LocalDate.now();


        Map<Integer, ForumUser> theResultMapOfForumUsers = theForumUsers.getList().stream()
                .filter(ForumUser -> ForumUser.getSex() == 'm')
                  .filter(ForumUser -> ForumUser.getAgeDifference() >= 20)
                .filter(ForumUser -> ForumUser.getPosts() > 1)
                .collect(Collectors.toMap(ForumUser::getId, ForumUser->ForumUser));

        System.out.println("# elements: " + theResultMapOfForumUsers.size());
        theResultMapOfForumUsers.entrySet().stream()
                .map(entry->entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}

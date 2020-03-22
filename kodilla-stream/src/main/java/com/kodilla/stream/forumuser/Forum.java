package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.ArrayList;

public final class Forum {
    private final List<ForumUser> theForumUsers = new ArrayList<>();

    public Forum(){

        theForumUsers.add(new ForumUser(2,"Patryk",'m', LocalDate.of(1987, Month.JULY,1),2));
        theForumUsers.add(new ForumUser(2,"Patrycja",'k', LocalDate.of(1988, Month.JUNE,2),8));
        theForumUsers.add(new ForumUser(2,"Kasia",'k', LocalDate.of(1976, Month.DECEMBER,3),10));
        theForumUsers.add(new ForumUser(2,"Jan",'m', LocalDate.of(2019, Month.FEBRUARY,8),120));
        theForumUsers.add(new ForumUser(2,"Tomasz",'m', LocalDate.of(1901, Month.AUGUST,9),1));
        theForumUsers.add(new ForumUser(2,"Piotr",'m', LocalDate.of(2017, Month.APRIL,10),8));
        theForumUsers.add(new ForumUser(2,"Daria",'k', LocalDate.of(2001, Month.JANUARY,10),5));
    }

    public List<ForumUser> getList() {
        return new ArrayList<>(theForumUsers);
    }
}


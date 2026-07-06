package com.aidana.collection.comparable;

import java.util.Comparator;

public class UserAgeComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user2.getAge().compareTo(user1.getAge());
    }
}

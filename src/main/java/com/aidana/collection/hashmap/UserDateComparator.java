package com.aidana.collection.hashmap;


import java.util.Comparator;

public class UserDateComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user2.getCreatedDate().compareTo(user1.getCreatedDate());
    }
}

package com.aidana.collection.hashmap;

import java.util.*;

public class Manager {
    private static Map<String, User> userMap = new HashMap<>();

    public boolean login(String login, String password) {
        if (!userMap.containsKey(login)) {
            System.out.println("Don't exists. Can't login");
            return false;
        }
        if (!userMap.get(login).getPassword().equals(password)) {
            System.out.println("Password is incorrect");
            return false;
        }

        System.out.println("Successfully logged in");
        return true;
    }

    public boolean addNewUser(User user) {
        if (userMap.containsKey(user.getLogin())) {
            System.out.println("Already exists");
            return false;
        }
        userMap.put(user.getLogin(), user);
        System.out.println("Successfully added: " + user.getLogin());
        return true;
    }

    public boolean editUser(User user) {
        if (!userMap.containsKey(user.getLogin())) {
            System.out.println("Don't exists. Can't edit");
            return false;
        }
        userMap.put(user.getLogin(), user);
        System.out.println("Successfully edited: " + user.getLogin());
        return true;
    }

    public boolean deleteUser(String login) {
        if (!userMap.containsKey(login)) {
            System.out.println("Don't exists. Can't delete");
            return false;
        }

        userMap.remove(login);
        System.out.println("Successfully deleted: " + login);
        return true;
    }

    public void getAllUsers() {
        System.out.println(userMap.keySet());
    }

    public void getAllUsers(String sortCriterion) {
        switch (sortCriterion) {
            case "login":
                TreeMap<String, User> userTreeMap = new TreeMap<>(userMap);
                for (Map.Entry entry: userTreeMap.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
                break;
            case "date":
                Comparator<User> userComparator = new UserDateComparator();
                List<User> sortedByDateUsers = new ArrayList<>(userMap.values());
                sortedByDateUsers.sort(userComparator);
                for (User user: sortedByDateUsers) {
                    System.out.println(user);
                }
                break;
        }
    }
}

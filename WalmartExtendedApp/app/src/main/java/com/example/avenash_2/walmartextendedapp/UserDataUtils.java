package com.example.avenash_2.walmartextendedapp;

import java.util.ArrayList;
import java.util.List;

public class UserDataUtils {
    private static final UserDataUtils ourInstance = new UserDataUtils();
    private static List<User> users=new ArrayList<>();
    void addUser(User user){
        users.add(user);
    }

    public static UserDataUtils getInstance() {
        return ourInstance;
    }

    private UserDataUtils() {
    }

    boolean validateUser(User loginUser){
        for(User user:users){
            if(user.equals(loginUser)){
                return true;
            }
        }
        return false;
    }
}

package com.example.ratescore;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserManager {

    private static volatile UserManager instance;
    private UserRepository userRepository;

    public UserManager() {
        userRepository = UserRepository.getInstance();

    }
    public static UserManager getInstance() {
        UserManager result = instance;
        if (result != null) {
            return result;

        }synchronized (UserRepository.class) {
            if(instance == null) {
                instance = new UserManager();
            }
            return instance;
        }
    }
    public Boolean isCurrentUserLogged() {
        return  (userRepository.getCurrentUser() != null);
    }

    public FirebaseUser getCurrentUser() {
        return userRepository.getCurrentUser();
    }
}

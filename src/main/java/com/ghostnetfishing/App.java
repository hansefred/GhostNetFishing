package com.ghostnetfishing;

import javax.ejb.Singleton;
import javax.ejb.Startup;



@Startup
@Singleton
public class App {
    private UserDAO userDAO;

    public App() {
        userDAO = new UserDAO();
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}

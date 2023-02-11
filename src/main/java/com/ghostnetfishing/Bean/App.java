package com.ghostnetfishing.Bean;

import com.ghostnetfishing.Bean.DB.GhostNetDAO;
import com.ghostnetfishing.Bean.DB.UserDAO;

import javax.ejb.Singleton;
import javax.ejb.Startup;



@Startup
@Singleton
public class App {
    private UserDAO userDAO;
    private GhostNetDAO ghostNetDAO;

    public App() {
        userDAO = new UserDAO();
        ghostNetDAO = new GhostNetDAO();
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public GhostNetDAO getGhostNetDAO() {
        return ghostNetDAO;
    }
}

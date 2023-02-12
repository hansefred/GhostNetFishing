package com.ghostnetfishing.Controller;


import com.ghostnetfishing.Bean.App;
import com.ghostnetfishing.Bean.DB.UserDAO;
import com.ghostnetfishing.Bean.DB.UserObj.User;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("UserDetailsController")
@RequestScoped
public class UserDetailsController {


    private String netID;
    private User user;


    private void LoadUser() {

        UserDAO userDAO = App.getApp().getUserDAO();
        int id = Integer.parseInt(netID);
        User u = userDAO.FindByID(id);
        this.user = u;


    }

    public String getNetID() {
        return netID;
    }

    public void setNetID(String netID) {
        this.netID = netID;
        LoadUser();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

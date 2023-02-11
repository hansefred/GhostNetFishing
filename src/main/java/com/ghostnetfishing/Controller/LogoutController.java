package com.ghostnetfishing.Controller;


import com.ghostnetfishing.Bean.ControllerRequests.UserSession;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named("LogoutController")
@RequestScoped
public class LogoutController {




    public String Logout ()
    {
        UserSession userSession = UserSession.getSession();
        userSession.setCurrentUser(null);

        return "Index.xhtml";
    }
}

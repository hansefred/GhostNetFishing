package com.ghostnetfishing.Controller;

import com.ghostnetfishing.UserSession;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


import java.io.Serializable;

@Named("IndexController")
@SessionScoped
public class IndexController implements Serializable {

    public IndexController ()
    {

    }

    public  boolean CheckLoginState ()
    {
        UserSession userSession = UserSession.getSession();

        if (userSession.getCurrentUser() == null)
        {
            return false;
        }

        return true;
    }

    public String Register ()
    {
        FacesContext context = FacesContext.getCurrentInstance();

        UserSession userSession = UserSession.getSession();

        if (userSession.getCurrentUser() == null)
        {
            return "Register.xhtml";
        }

        context.addMessage(null,new FacesMessage("You are already logged in"));
        return null;
    }
}

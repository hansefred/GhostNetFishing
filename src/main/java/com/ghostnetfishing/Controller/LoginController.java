package com.ghostnetfishing.Controller;


import com.ghostnetfishing.App;
import com.ghostnetfishing.Bean.LoginRequest;
import com.ghostnetfishing.User.User;
import com.ghostnetfishing.UserDAO;
import com.ghostnetfishing.UserSession;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import javax.inject.Inject;
import javax.inject.Named;




import java.io.Serializable;

@Named("LoginController")
@RequestScoped

public class LoginController implements Serializable {



    @Inject
    private App app;

    private LoginRequest loginRequest;


    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    public void setLoginRequest(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }

    public  LoginController ()
    {
        loginRequest = new LoginRequest();
    }

    public String Login ()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        UserSession userSession = UserSession.getSession();
        if (userSession.getCurrentUser() != null) {
            context.addMessage(null,new FacesMessage("You are already logged in"));
            return null;
        }


        User foundUser = new User();
        boolean userFound = false;
        for (User u : app.getUserDAO().GetAll()) {
            if (u.geteMail().equals(loginRequest.geteMail())) {
                userFound = true;
                foundUser = u;
                break;
            }
        }

        if (!userFound) {
            context.addMessage(null,new FacesMessage("Username or password invalid"));
            return null;
        }

        int passwordHash = loginRequest.getPassword().hashCode();

        if (passwordHash != foundUser.getPasswordHash())
        {
            context.addMessage(null,new FacesMessage("Username or password invalid"));
            return null;
        }

        userSession.setCurrentUser(foundUser);

        return "Index.xhtml";
    }


}

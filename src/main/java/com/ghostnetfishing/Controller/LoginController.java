package com.ghostnetfishing.Controller;



import com.ghostnetfishing.Bean.App;
import com.ghostnetfishing.Bean.ControllerRequests.LoginRequest;
import com.ghostnetfishing.Bean.ControllerRequests.UserSession;
import com.ghostnetfishing.Bean.DB.UserObj.User;


import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import javax.inject.Inject;
import javax.inject.Named;




import java.io.Serializable;
import java.util.List;

@Named("LoginController")
@RequestScoped

public class LoginController implements Serializable {


    @Inject
    UserSession userSession;


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

        List<User> detectorList =  App.getApp().getUserDAO().GetAll();
    }

    public String Login ()
    {
        FacesContext context = FacesContext.getCurrentInstance();

        if (userSession.getCurrentUser() != null) {
            context.addMessage(null,new FacesMessage("You are already logged in"));
            return null;
        }


        User foundUser = null;
        boolean userFound = false;
        for (User u : App.getApp().getUserDAO().GetAll()) {
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

        userSession.setCurrentUser((User)foundUser);

        return "Index.xhtml?faces-redirect=true";
    }


}

package com.ghostnetfishing;


import com.ghostnetfishing.User.User;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class UserSession  implements Serializable {

    //Singelton implementation for App
    private static UserSession app;
    public static UserSession getApp ()
    {
        if (app == null)
        {
            app = new UserSession();
            return app;
        }
        return app;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    private User currentUser;

}

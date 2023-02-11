package com.ghostnetfishing.Bean.ControllerRequests;



import com.ghostnetfishing.Bean.DB.UserObj.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named("UserSession")
public class UserSession  implements Serializable {

    //Singelton implementation for App
    private static UserSession app;
    public static UserSession getSession ()
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

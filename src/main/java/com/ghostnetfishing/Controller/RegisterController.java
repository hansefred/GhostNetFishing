package com.ghostnetfishing.Controller;

import com.ghostnetfishing.Bean.RegisterRequest;
import com.ghostnetfishing.Bean.Role;
import com.ghostnetfishing.User.Detector;
import com.ghostnetfishing.User.Salvor;
import com.ghostnetfishing.User.User;
import com.ghostnetfishing.UserDAO;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("RegisterController")
@RequestScoped
public class RegisterController implements Serializable {




    public RegisterController() {
        registerRequest = new RegisterRequest();
        selectedRole = Role.DETECTOR;
    }

    @Inject
    private UserDAO userDAO;

    private RegisterRequest registerRequest;
    private Role selectedRole;

    public String Register ()
    {
        FacesContext context = FacesContext.getCurrentInstance();

        if (!registerRequest.getPassword().equals(registerRequest.getRepeatPassword()))
        {
            context.addMessage( "pwd", new FacesMessage("Passwort stimmt nicht überein"));
            return null;
        }

        int passwordHash = registerRequest.getPassword().hashCode();



        for (User u : userDAO.GetAll()) {
            if (u.geteMail().equals(registerRequest.geteMail())) {
                context.addMessage(null,new FacesMessage("User already exists"));
                return null;
            }
        }

        switch (selectedRole)
        {
            case SALVOR:
                Salvor s = new Salvor (registerRequest.getFirstName(), registerRequest.getLastName(), registerRequest.geteMail(),passwordHash, registerRequest.getPhoneNumber());
                userDAO.CreateUser(s);
                break;
            case DETECTOR:
                Detector d = new Detector (registerRequest.getFirstName(), registerRequest.getLastName(), registerRequest.geteMail(),passwordHash, registerRequest.getPhoneNumber());
                userDAO.CreateUser(d);
                break;
        }


        return "Index.xhtml";
    }



    public RegisterRequest getRegisterRequest() {
        return registerRequest;
    }

    public void setRegisterRequest(RegisterRequest registerRequest) {
        this.registerRequest = registerRequest;
    }

    public Role getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(Role role) {
        this.selectedRole = role;
    }


    public Role[] getRoles()
    {
        return Role.values();
    }
}

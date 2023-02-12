package com.ghostnetfishing.Controller;

import com.ghostnetfishing.Bean.App;
import com.ghostnetfishing.Bean.ControllerRequests.UserSession;
import com.ghostnetfishing.Bean.DB.GhostNet;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


import java.io.Serializable;
import java.util.List;

@Named("IndexController")
@RequestScoped
public class IndexController implements Serializable {



    public IndexController ()
    {
        ghostNets = App.getApp().getGhostNetDAO().GetAll();

    }

    private List<GhostNet> ghostNets;

    private GhostNet selectedNet;


    @Inject
    private UserSession userSession;


    public String Register ()
    {
        FacesContext context = FacesContext.getCurrentInstance();


        if (userSession.getCurrentUser() == null)
        {
            return "Register.xhtml";
        }

        context.addMessage(null,new FacesMessage("You are already logged in"));
        return null;
    }

    public  void AcceptSalvage(GhostNet net)
    {

    }


    public List<GhostNet> getGhostNets() {
        return ghostNets;
    }

    public void setGhostNets(List<GhostNet> ghostNets) {
        this.ghostNets = ghostNets;
    }


    public GhostNet getSelectedNet() {
        return selectedNet;
    }

    public void setSelectedNet(GhostNet selectedNet) {
        this.selectedNet = selectedNet;
    }

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }
}

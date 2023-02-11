package com.ghostnetfishing.Controller;

import com.ghostnetfishing.Bean.App;
import com.ghostnetfishing.Bean.ControllerRequests.CreateNetRequest;
import com.ghostnetfishing.Bean.DB.GhostNet;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named("CreateNetController")
@RequestScoped
public class CreateNetController {

    @Inject
    private App app;
    private CreateNetRequest createNetRequest;

    public CreateNetController() {

        createNetRequest = new CreateNetRequest();
    }


    public CreateNetRequest getCreateNetRequest() {
        return createNetRequest;
    }

    public void setCreateNetRequest(CreateNetRequest createNetRequest) {
        this.createNetRequest = createNetRequest;
    }


    public String CreateNet () {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.isValidationFailed()) {
            return null;
        }

        if (createNetRequest.getDetector() == null)
        {
            context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Bitte melden Sie sich als Meldende Person an", "Please Login in or Register"));
            context.isValidationFailed();
            return  null;
        }


        GhostNet ghostNet = new GhostNet(createNetRequest.getLatitude(), createNetRequest.getLongitude(), createNetRequest.getEstimatedSizeinm2());

        ghostNet.setDetector(createNetRequest.getDetector());
        app.getGhostNetDAO().CreateNet(ghostNet);


        return "Index.xhtml";
    }



}

package com.ghostnetfishing.Bean.ControllerRequests;

import com.ghostnetfishing.Bean.DB.UserObj.User;


import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;


public class CreateNetRequest {


    public CreateNetRequest() {

        User u = UserSession.getSession().getCurrentUser();

        this.detector = u;

    }

    @DecimalMin(value ="0.0")
    @DecimalMax( value = "90.0")
    private double latitude;

    @DecimalMin(value ="0.0")
    @DecimalMax( value = "90.0")
    private double longitude;

    @Min(0)
    private int estimatedSizeinm2;


    private User detector;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getEstimatedSizeinm2() {
        return estimatedSizeinm2;
    }

    public void setEstimatedSizeinm2(int estimatedSizeinm2) {
        this.estimatedSizeinm2 = estimatedSizeinm2;
    }

    public User getDetector() {
        return detector;
    }

    public void setDetector(User detector) {
        this.detector = detector;
    }
}

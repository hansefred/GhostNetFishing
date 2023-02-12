package com.ghostnetfishing.Bean.DB;

import com.ghostnetfishing.Bean.DB.UserObj.User;

import javax.persistence.*;

import java.util.Objects;
import java.util.UUID;


@Entity (name = "GhostNet")
public class GhostNet {

    public  GhostNet ()
    {

    }

    public GhostNet(double latitude, double longitude, int estimatedSizeinspuaremetre) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.estimatedSizeinspuaremetre = estimatedSizeinspuaremetre;
        this.state = GhostNetState.REGISTERED;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private double latitude;
    private double longitude;
    private int estimatedSizeinspuaremetre;

    private GhostNetState state;



    @ManyToOne
    private User detector;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GhostNet net = (GhostNet) o;
        return Objects.equals(net.ID, this.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ID);
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

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

    public int getEstimatedSizeinspuaremetre() {
        return estimatedSizeinspuaremetre;
    }

    public void setEstimatedSizeinspuaremetre(int estimatedSizeinspuaremetre) {
        this.estimatedSizeinspuaremetre = estimatedSizeinspuaremetre;
    }

    public GhostNetState getState() {
        return state;
    }

    public void setState(GhostNetState state) {
        this.state = state;
    }

    public User getDetector() {
        return detector;
    }

    public void setDetector(User detector) {
        this.detector = detector;
    }
}



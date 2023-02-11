package com.ghostnetfishing.Bean.DB;

import com.ghostnetfishing.Bean.DB.UserObj.Detector;
import com.ghostnetfishing.Bean.DB.UserObj.Salvor;

import javax.persistence.*;

import java.util.UUID;


@Entity
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
    private UUID ID;
    private double latitude;
    private double longitude;
    private int estimatedSizeinspuaremetre;

    private GhostNetState state;

    @ManyToOne
    private Detector detector;

    @ManyToOne
    private Salvor salvor;


    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
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


    public Detector getDetector() {
        return detector;
    }

    public void setDetector(Detector detector) {
        this.detector = detector;
    }

    public Salvor getSalvor() {
        return salvor;
    }

    public void setSalvor(Salvor salvor) {
        this.salvor = salvor;
    }
}



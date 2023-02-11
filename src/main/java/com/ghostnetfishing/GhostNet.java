package com.ghostnetfishing;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.UUID;


@Entity
public class GhostNet {

    public  GhostNet ()
    {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ID;
    private double latitude;
    private double longitude;
    private int estimatedSizeinspuaremetre;

    private GhostNetState state;


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
}



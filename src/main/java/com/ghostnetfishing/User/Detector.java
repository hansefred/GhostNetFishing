package com.ghostnetfishing.User;

import com.ghostnetfishing.GhostNet;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Detector extends  User{


    public Detector() {

    }

    public Detector(String firstName, String lastName, String eMail, int passwordHash, String phoneNumber) {
        super(firstName, lastName, eMail, passwordHash, phoneNumber);
    }

    @OneToMany
    List<GhostNet> detectedNets;


    public List<GhostNet> getDetectedNets() {
        return detectedNets;
    }

    public void setDetectedNets(List<GhostNet> detectedNets) {
        this.detectedNets = detectedNets;
    }
}

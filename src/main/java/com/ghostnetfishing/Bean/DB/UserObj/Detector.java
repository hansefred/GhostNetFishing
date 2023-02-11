package com.ghostnetfishing.Bean.DB.UserObj;

import com.ghostnetfishing.Bean.DB.GhostNet;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Entity
public class Detector extends  User{


    public Detector() {

    }

    public Detector(String firstName, String lastName, String eMail, int passwordHash, String phoneNumber) {
        super(firstName, lastName, eMail, passwordHash, phoneNumber);
    }

    @OneToMany (mappedBy = "detector", fetch = FetchType.EAGER)
    List<GhostNet> detectedNets;


    public List<GhostNet> getDetectedNets() {
        return detectedNets;
    }

    public void setDetectedNets(List<GhostNet> detectedNets) {
        this.detectedNets = detectedNets;
    }
}

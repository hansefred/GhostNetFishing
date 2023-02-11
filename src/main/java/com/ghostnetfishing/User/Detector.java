package com.ghostnetfishing.User;

import com.ghostnetfishing.GhostNet;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Detectors extends  User{


    public Detectors() {

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

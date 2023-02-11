package com.ghostnetfishing.Bean.DB.UserObj;


import com.ghostnetfishing.Bean.DB.GhostNet;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Salvor  extends  User{

    @OneToMany (mappedBy = "salvor", fetch = FetchType.EAGER)
    List<GhostNet> salvagedNet;
    public Salvor() {
    }

    public Salvor(String firstName, String lastName, String eMail, int passwordHash, String phoneNumber) {
        super(firstName, lastName, eMail, passwordHash, phoneNumber);

    }

    public List<GhostNet> getSalvagedNet() {
        return salvagedNet;
    }

    public void setSalvagedNet(List<GhostNet> salvagedNet) {
        this.salvagedNet = salvagedNet;
    }




}

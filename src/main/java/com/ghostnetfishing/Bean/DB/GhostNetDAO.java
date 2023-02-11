package com.ghostnetfishing.Bean.DB;


import com.ghostnetfishing.Bean.App;
import com.ghostnetfishing.Bean.DB.UserObj.Detector;
import com.ghostnetfishing.Bean.DB.UserObj.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import java.util.List;

@Named
@ApplicationScoped
public class GhostNetDAO {

    private final  static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Default");

    @Inject
    App app;

    public List<GhostNet> GetAll ()
    {

        EntityManager entityManager = emf.createEntityManager();
        Query query = entityManager.createQuery("SELECT G FROM GhostNet G");
        List<GhostNet> nets =   query.getResultList();
        entityManager.close();
        return nets;
    }

    public void CreateNet(GhostNet ghostNet)
    {
        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction t = entityManager.getTransaction();
        t.begin();

        entityManager.persist(ghostNet);


        Detector d = ghostNet.getDetector();
        d.getDetectedNets().add(ghostNet);







        t.commit();
        entityManager.close();
    }

}

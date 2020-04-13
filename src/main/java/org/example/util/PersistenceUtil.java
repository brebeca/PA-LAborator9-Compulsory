package org.example.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static PersistenceUtil instance=null;

    EntityManagerFactory factory =
            Persistence.createEntityManagerFactory(
                    "MusicAlbumsPU", null);
    EntityManager em = factory.createEntityManager();

    public EntityManager getEm() {
        return em;
    }


    public static PersistenceUtil getInstance(){
        if(instance==null)
            instance= new PersistenceUtil();
        return instance;
    }

}

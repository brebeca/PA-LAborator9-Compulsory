package org.example.repo;

import org.example.entity.Artists_;
import org.example.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ArtistRepository {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY= Persistence.
            createEntityManagerFactory("MusicAlbumsPU");

    /**
     *se instantiaza entityMAnager -ul si  EntityTransaction -ul
     * se incepe "tranazactia" intr un bloc de try in cazul in care apar erori
     * se incearca  inregistrarea prin functia persist() a obiectului entity album
     * @param album obiectul care se vrea a fi inregistrat in baza de date
     */
    public void create(Artists_ album){
        EntityTransaction et= null;
        EntityManager em= ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction=null;
        try{
            entityTransaction=em.getTransaction();
            entityTransaction.begin();
            em.persist(album);
            entityTransaction.commit();

        }
        catch(Exception e){
            if(entityTransaction!=null)
                et.rollback();
            System.out.println(e.getMessage());

        }
        finally {
            em.close();
        }
    }

    /**
     * e instantiaza entityMAnager -ul
     *  se incepe "tranazactia"
     * se executa named query ul "Artists_.findById" de la calssa de tip entity Albums_ dupa setarea parametrilor
     * rezultatul este preluat in lista de obiecte album care ar trebui sa aiba doar un element deoarece id ul este unic
     * se inceheie "tranzactia"
     * @param id
     * @return lista de obiecte entity preluata in urma executarii interogarii
     */
    @SuppressWarnings("unchecked")
    public List<Artists_> findById(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();

        List<Artists_> artists = em.createNamedQuery("Artist.findById")
                .setParameter("id", id)
                .getResultList();

        em.getTransaction().commit();
        em.close();
        return artists;
    }

    /**
     * e instantiaza entityMAnager -ul
     *  se incepe "tranazactia"
     * se executa named query ul "Albums_.findById" de la calssa de tip entity Albums_ dupa setarea parametrilor
     * rezultatul este preluat in lista de obiecte album care
     * se inceheie "tranzactia"
     * @param id numele dupa care se face selectia
     * @return lista de obiecte entity preluata in urma executarii interogarii
     */

    @SuppressWarnings("unchecked")
    public List<Artists_> findByName(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();

        List<Artists_> artists = em.createNamedQuery("Artist.findByName")
                .setParameter("name", id)
                .getResultList();

        em.getTransaction().commit();
        em.close();
       return artists;
    }
}

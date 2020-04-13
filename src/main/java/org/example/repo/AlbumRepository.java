package org.example.repo;

import javax.persistence.*;

import org.example.util.PersistenceUtil;
import org.example.entity.Albums_;

import java.util.List;


public class AlbumRepository {
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY= Persistence.createEntityManagerFactory("MusicAlbumsPU");

    /**
     *se instantiaza entityMAnager -ul si  EntityTransaction -ul
     * se incepe "tranazactia" intr un bloc de try in cazul in care apar erori
     * se incearca  inregistrarea prin functia persist() a obiectului entity album
     * @param album obiectul care se vrea a fi inregistrat in baza de date
     */
    public void create(Albums_ album){
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

        System.out.println(e.getMessage());

    }
    finally {
        em.close();
    }
    }

    /**
     * e instantiaza entityMAnager -ul
     *  se incepe "tranazactia"
     * se executa named query ul "Albums_.findById" de la calssa de tip entity Albums_ dupa setarea parametrilor
     * rezultatul este preluat in lista de obiecte album care ar trebui sa aiba doar un element deoarece id ul este unic
     * se inceheie "tranzactia"
     * se afiseaza rezultatele
     * @param id id-ul dupa care se va cauta inregistrarea
     */
    @SuppressWarnings("unchecked")
    public void findById(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();

        List<Albums_> album = em.createNamedQuery("Albums_.findById")
                .setParameter("id", id)
                .getResultList();

        em.getTransaction().commit();
        em.close();
        for(Albums_ albums_:album){
            System.out.println(albums_.getName());
        }
    }

    /**
     * e instantiaza entityMAnager -ul
     *  se incepe "tranazactia"
     * se executa named query ul "Albums_.findByName" de la calssa de tip entity Albums_ dupa setarea parametrilor
     * rezultatul este preluat in lista de obiecte album prin functia getResultList()
     * se inceheie "tranzactia"
     * se afiseaza rezultatele
     * @param id numele dupa care se cauta inregistrarea
     */
    @SuppressWarnings("unchecked")
    public void findByName(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.getTransaction().begin();

        List<Albums_> album = em.createNamedQuery("Albums_.findByName")
                .setParameter("name", id)
                .getResultList();

        em.getTransaction().commit();
        em.close();
        for(Albums_ albums_:album){
            System.out.println(albums_.getName());
        }
    }
}

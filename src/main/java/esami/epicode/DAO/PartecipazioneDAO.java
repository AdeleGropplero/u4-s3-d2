package esami.epicode.DAO;

import esami.epicode.entities.Partecipazione;
import esami.epicode.entities.Persona;

import javax.persistence.EntityManager;

public class PartecipazioneDAO {
    private EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione par){
        em.getTransaction().begin();
        em.persist(par);
        em.getTransaction().commit();
    }

    public Partecipazione getById(long id){
        return em.find(Partecipazione.class, id);
    }

    public void delete(Partecipazione par){
        em.getTransaction().begin();
        em.remove(par);
        em.getTransaction().commit();
    }
}

package esami.epicode.DAO;

import esami.epicode.entities.Evento;

import javax.persistence.EntityManager;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public Evento getByID(long id) {
        return em.find(Evento.class, id);
    }

    public void delete(Evento e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

}

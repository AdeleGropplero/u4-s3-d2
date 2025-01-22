package esami.epicode.DAO;

import esami.epicode.entities.Evento;
import esami.epicode.entities.Location;

import javax.persistence.EntityManager;

public class LocationDAO {
    private EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location l) {
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
    }

    public Location getByID(long id) {
        return em.find(Location.class, id);
    }

    public void delete(Location l) {
        em.getTransaction().begin();
        em.remove(l);
        em.getTransaction().commit();
    }
}

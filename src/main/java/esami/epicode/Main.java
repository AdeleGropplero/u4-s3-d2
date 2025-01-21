package esami.epicode;


import esami.epicode.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-s3-d2");
    public static EntityManager em = emf.createEntityManager();
    //Ora con l'oggetto em posso invocare tutte le azioni dal database.

    public static void main(String[] args) {
        Evento e1 = new Evento(
                "SuperTrampoline", LocalDate.of(2025, 5, 10),
                "Trampolini per tutte le età! Gratis sotto i 10 anni",
                TipoEvento.PUBBLICO, 200);

        Evento e2 = new Evento(
                "Concerto di Rock",
                LocalDate.of(2025, 7, 21),
                "Una serata di puro rock con le migliori band italiane.",
                TipoEvento.PRIVATO, 500);

        Evento e3 = new Evento(
                "Tech Conference 2025",
                LocalDate.of(2025, 9, 20),
                "Una conferenza per scoprire le ultime innovazioni tecnologiche.",
                TipoEvento.PRIVATO, 200);

       /* save(e1);
        save(e2);
        save(e3);*/

        Evento e = find(1);
        System.out.println(e);

  /*      Evento ebt = findByTitle("Tech Conference 2025");
        System.out.println(ebt);*/ // NON SI PUò FARE.

        remove(e);

        em.close();
        emf.close();
    }

    public static void save(Evento evento) {
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
    }

    public static Evento find(long id) {
        em.getTransaction().begin();
        Evento e = em.find(Evento.class, id);
        em.getTransaction().commit();
        return e;
    }

    public static void remove(Evento evento) {
        em.getTransaction().begin();
        em.remove(evento);
        em.getTransaction().commit();
    }

/*    public static Evento findByTitle(String titolo) {
        em.getTransaction().begin();
        Evento e = em.find(Evento.class, titolo);
        em.getTransaction().commit();
        return e;
    }*/ //QUESTO NON LO PUOI FARE, SI ASPETTA UN LONG id COME ARGOMENTO.
}

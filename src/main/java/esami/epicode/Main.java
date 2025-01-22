package esami.epicode;


import com.github.javafaker.Faker;
import esami.epicode.DAO.EventoDAO;
import esami.epicode.DAO.LocationDAO;
import esami.epicode.DAO.PartecipazioneDAO;
import esami.epicode.DAO.PersonaDAO;
import esami.epicode.Enum.Sesso;
import esami.epicode.Enum.StatoPartecipazione;
import esami.epicode.Enum.TipoEvento;
import esami.epicode.entities.Evento;
import esami.epicode.entities.Location;
import esami.epicode.entities.Partecipazione;
import esami.epicode.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-s3-d2");
    public static EntityManager em = emf.createEntityManager();
    //Ora con l'oggetto em posso invocare tutte le azioni dal database.

    public static void main(String[] args) {
/*        Evento e1 = new Evento(
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

        Evento e4 = new Evento(
                "Lelle in vacanza",
                LocalDate.of(2026, 7, 20),
                "Un mese in un paradiso caraibico solo per donne!",
                TipoEvento.PUBBLICO, 200);*/


      /*  EventoDAO eventoDao = new EventoDAO(em);*/
/*
        eventoDao.save(e1);
        eventoDao.save(e2);
        eventoDao.save(e3);
        eventoDao.save(e4);
*/

        // Evento getEv = eventoDao.getByID(1);
        // System.out.println(getEv);

        // eventoDao.delete(getEv);

//-------------------------------------aggiunte-----------------------------------------------------------------//
        Faker faker = new Faker(Locale.ITALY);
        EventoDAO eventoDao = new EventoDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

  /*     Location l1 = new Location(faker.name().name(), faker.address().city());
        locationDAO.save(l1);

       Persona p1 = new Persona(faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                LocalDate.of(1992, 02, 19),
                faker.options().option(Sesso.class));

        personaDAO.save(p1);

        Evento e1 = new Evento(
                faker.book().title(), // Titolo
                LocalDate.now().plusDays(ThreadLocalRandom.current().nextInt(1, 31)), // Data evento casuale
                faker.lorem().sentence(10), // Descrizione
                faker.options().option(TipoEvento.class), // Tipo di evento casuale
                ThreadLocalRandom.current().nextInt(10, 101), // Numero massimo partecipanti
                 l1// Location casuale
        );
        eventoDao.save(e1);*/

        Partecipazione par1 = new Partecipazione( faker.options().option(StatoPartecipazione.class), personaDAO.getById(2), eventoDao.getByID(3));
        partecipazioneDAO.save(par1);



        em.close();
        emf.close();
    }

}

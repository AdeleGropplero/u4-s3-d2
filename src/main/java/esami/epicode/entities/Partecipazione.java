package esami.epicode.entities;

import esami.epicode.Enum.StatoPartecipazione;

import javax.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Aggiunta della strategia di generazione
    private long id;

    @ManyToOne
    @JoinColumn(name = "persona_id") // Imposta nullable per coerenza
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @Enumerated(EnumType.STRING) // Indica che l'enum sarà salvato come stringa nel database

    private StatoPartecipazione stato;

    // Costruttore vuoto
    public Partecipazione() {
    }

    // Costruttore con parametri
    public Partecipazione(StatoPartecipazione stato, Persona persona, Evento evento) {
        this.stato = stato;
        this.persona = persona;
        this.evento = evento;
    }

    // Getter e Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public StatoPartecipazione getStato() {
        return stato;
    }

    public void setStato(StatoPartecipazione stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}

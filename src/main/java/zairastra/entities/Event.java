package zairastra.entities;

//RICORDATIIII!!!
//PRIMA CREI LE CLASSI E SOLO DOPO AGGIUNGI LA CARTELLA RESOURCES COI FILE PERSISTENCE DENTRO

import jakarta.persistence.*;
import zairastra.entities.enums.EventType;

import java.time.LocalDate;
import java.util.List;

@Entity //  QUESTO è FONDAMENTALE PER LEGARE AL DB

@Table(name = "events") // QUESTO è OPZIONALE - CAMBIA IL NOME DELLA TABELLA
public class Event {

    //ATTRIBUTI

    @Id //FONDAMENTALE - SERVE A IDENTIFICARE LA PK DELLA COLONNA

    @GeneratedValue(strategy = GenerationType.IDENTITY) // OPZIONALE - GENERA LE SINGOLE CHIAVI AUTOMATICAMENTE
    private long id;

    @Column(name = "title", nullable = false) //OPZIONALE - SERVE PER PERSONALIZZARE LE CARATTERISTICHE DELLA COLONNA
    private String name;

    @Column(name = "eventDate", nullable = false)
    private LocalDate date;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "eventType")
    @Enumerated(EnumType.STRING) //OBBLIGATORIO QUANDO HO UN ENUM PER EVITARE CHE IN TABELLA ABBIA UN NUMERO
    private EventType type;

    @Column(name = "maxNumbPart", nullable = false)
//C'è UN "EQUIVALENTE" DI LENGHT PER I LIMITI DI GRANDEZZA DEI NUMERI???
    private int numbParticipants;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "event")
    private List<Partecipation> partecipations;


    //COSTRUTTORI

    //è OBBLIGATORIO UN COSTRUTTORE VUOTO SE VOGLIO RICHIAMARE UN OGGETTO DAL DB, SERVE A "INIZIALIZZARLO"
    public Event() {
    }

    public Event(String name, LocalDate date, String description, EventType type, int numbParticipants, String location) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.type = type;
        this.numbParticipants = numbParticipants;
        this.location = location;
    }

    //METODI


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public int getNumbParticipants() {
        return numbParticipants;
    }

    public void setNumbParticipants(int numbParticipants) {
        this.numbParticipants = numbParticipants;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", numbParticipants=" + numbParticipants +
                ", location='" + location + '\'' +
                '}';
    }
}

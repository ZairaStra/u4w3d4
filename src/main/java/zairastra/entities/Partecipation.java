package zairastra.entities;

import jakarta.persistence.*;
import zairastra.entities.enums.State;

@Entity
@Table(name = "partecipations")
public class Partecipation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partecipation_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State state;

    public Partecipation() {

    }

    public Partecipation(Person person, Event event, State state) {
        this.person = person;
        this.event = event;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Partecipation{" +
                "id=" + id +
                ", person=" + person +
                ", event=" + event +
                ", state=" + state +
                '}';
    }
}


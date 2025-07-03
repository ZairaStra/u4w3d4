package zairastra.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import zairastra.entities.enums.EventType;

import java.time.LocalDate;
import java.util.Set;

public class AthleticCompetition extends Event {

    //AthleticCompetition è in relazione con Person perchè serve una lista di partecipanti a ogni gara
    //e in più serve un vincitore per ogni gara

    //1.ogni atleta può partecipare a tante gare e ogni gara è partecipata da più atleti
    //MANYTOMANY

    //per la lista di partecipanti pensavo a un List ma una persona può partecipare una sola volta-> set esclude doppi

    @ManyToMany
    //invece di costruire la tabella di congiunzione a mano come ieri la faccio in automatico
    @JoinTable(
            name = "competition_athletes",
            joinColumns = @JoinColumn(name = "competion_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Person> athletes;

    //2.per il vincitore, ogni gara ha un solo vincitore, ma un vincitore può vincere più gare
    @ManyToOne
    @JoinColumn(name = "winnerAthlet_id")
    private Person winner;

    //costruttori
    public AthleticCompetition() {
    }

    public AthleticCompetition(String name, LocalDate date, String description, EventType type, int numbParticipants, String location, Set<Person> athletes, Person winner) {
        super(name, date, description, type, numbParticipants, location);
        this.athletes = athletes;
        this.winner = winner;
    }

    public Set<Person> getAthletes() {
        return athletes;
    }

    public void setAthletes(Set<Person> athletes) {
        this.athletes = athletes;
    }

    public Person getWinner() {
        return winner;
    }

    public void setWinner(Person winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "AthleticCompetition{" +
                "athletes=" + athletes +
                ", winner=" + winner +
                '}';
    }
}




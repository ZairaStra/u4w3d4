package zairastra.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import zairastra.entities.enums.ConcertGenre;
import zairastra.entities.enums.EventType;

import java.time.LocalDate;

@Entity
public class Concert extends Event {
    @Enumerated(EnumType.STRING)
    private ConcertGenre genre;

    private boolean streaming;

    //costruttori
    public Concert() {
    }

    ;

    public Concert(String name, LocalDate date, String description, EventType type, int numbParticipants, String location, ConcertGenre genre, boolean streaming) {
        super(name, date, description, type, numbParticipants, location);
        this.genre = genre;
        this.streaming = streaming;
    }


    public boolean isStreaming() {
        return streaming;
    }

    public void setStreaming(boolean streaming) {
        this.streaming = streaming;
    }

    public ConcertGenre getGenre() {
        return genre;
    }

    public void setGenre(ConcertGenre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "genre=" + genre +
                ", streaming=" + streaming +
                '}';
    }
}

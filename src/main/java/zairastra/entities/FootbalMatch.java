package zairastra.entities;

import jakarta.persistence.Entity;
import zairastra.entities.enums.EventType;

import java.time.LocalDate;

@Entity
public class FootbalMatch extends Event {

    private String homeTeam;
    private String awayteam;
    private String winningTeam;
    private int homeGoals;
    private int awayGoals;

    //costruttori
    public FootbalMatch() {
    }

    ;

    public FootbalMatch(String name, LocalDate date, String description, EventType type, int numbParticipants, String location, String homeTeam, String awayteam, String winningTeam, int homeGoals, int awayGoals) {
        super(name, date, description, type, numbParticipants, location);
        this.homeTeam = homeTeam;
        this.awayteam = awayteam;
        this.winningTeam = winningTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayteam() {
        return awayteam;
    }

    public void setAwayteam(String awayteam) {
        this.awayteam = awayteam;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(String winningTeam) {
        this.winningTeam = winningTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    @Override
    public String toString() {
        return "FootbalMatch{" +
                "homeTeam='" + homeTeam + '\'' +
                ", awayteam='" + awayteam + '\'' +
                ", winningTeam='" + winningTeam + '\'' +
                ", homeGoals=" + homeGoals +
                ", awayGoals=" + awayGoals +
                '}';
    }
}

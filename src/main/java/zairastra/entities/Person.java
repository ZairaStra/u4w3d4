package zairastra.entities;

import jakarta.persistence.*;
import zairastra.entities.enums.Sex;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @OneToMany(mappedBy = "person")
    private List<Partecipation> partecipations;

    public Person() {
    }

    public Person(String name, String surname, String email, LocalDate birthDate, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
        this.sex = sex;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public List<Partecipation> getPartecipations() {
        return partecipations;
    }

    public void setPartecipations(List<Partecipation> partecipations) {
        this.partecipations = partecipations;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", sex=" + sex +
                // ", partecipations=" + partecipations +
                '}';
    }
}



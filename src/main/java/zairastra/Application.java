package zairastra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import zairastra.dao.EventsDAO;
import zairastra.dao.PartecipationsDAO;
import zairastra.dao.PersonsDAO;

public class Application {
    //FAI ATTENZIONE: DEVE CHIAMARSI ESATTAMENTE COME è SCRITTO NEL PERSISTENCE.XML
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d3pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager(); //è LUI A GESTIRE LE RELAZIONI COL DB TRAMITE I METODI IN EVENTSDAO
        EventsDAO ed = new EventsDAO(em);
        PersonsDAO pd = new PersonsDAO(em);
        PartecipationsDAO part = new PartecipationsDAO(em);

        //per estendere event lo rendo abstract, quindi non è più istanziabile direttamente - commento tutto
//
//        //CREO UNA SERIE DI EVENTI - come controllo nel programma per il db???
//        //vai in pgAdmin->tables->events->tasto dx->view/edit data
//        Event matrimonio = new Event("Matrimonio Virgi", LocalDate.of(2025, 6, 28), "Matrimonio a Torino", EventType.PUBLIC, 134, "Villa Langhe");
//        Event concerto = new Event("Concerto in Sila", LocalDate.of(2025, 8, 3), "BeAlternativeFest", EventType.PUBLIC, 789, "Camigliatello");
//        Event controllo = new Event("Mappatura nei", LocalDate.of(2025, 7, 6), "Appuntamento dermatologico", EventType.PRIVATE, 2, "Studio associato");
//        Event cena = new Event("Cena a Roseto", LocalDate.of(2025, 9, 3), "Cena con Clara, Paolo e Agata", EventType.PRIVATE, 4, "La Vela");
//        //SALVO GLI EVENTI - SE NON USO SAVEEVENT NON SUCCEDE NIENTE ALLA TABELLA
////        ed.saveEvent(matrimonio);
////        ed.saveEvent(concerto);
////        ed.saveEvent(controllo);
////        ed.saveEvent(cena);
//
//        //CREO UN PAIO DI PERSONE
//        Person p1 = new Person("Zaira", "Straticò", "zairastra@email.it", LocalDate.of(1993, 1, 28), Sex.F);
//        Person p2 = new Person("Matteo", "Alfano", "matthew@email.it", LocalDate.of(1993, 11, 8), Sex.M);
//        Person p3 = new Person("Lady", "Rose", "ladyrose@email.it", LocalDate.of(1987, 6, 4), Sex.T);
//
////        pd.savePerson(p1);
////        pd.savePerson(p2);
////        pd.savePerson(p3);
//
//        //CREO UN PAIO DI PARTECIPAZIONI
//        Partecipation part1 = new Partecipation(p1, concerto, State.CONFIRMED);
//        Partecipation part2 = new Partecipation(p2, concerto, State.CONFIRMED);
//        Partecipation part3 = new Partecipation(p3, controllo, State.TO_CONFIRM);
//        Partecipation part4 = new Partecipation(p1, matrimonio, State.CONFIRMED);
//
////        part.savePartecipation(part1);
////        part.savePartecipation(part2);
////        part.savePartecipation(part3);
////        part.savePartecipation(part4);
//
//
//        //RECUPERO A CASO COL FINDBYYD
//
//        Person p1FromDb = pd.getById(10);
//        System.out.println("Ho trovato questo soggetto: " + p1FromDb.getName());
//
//        Person p2FromDb = pd.getById(5);
//        System.out.println("Ho trovato questo soggetto: " + p2FromDb.getName());
//
//        Partecipation part1FromDb = part.getById(2);
//        System.out.println("Ho trovato questo invito: " + part1FromDb);
//
//        Person p12FromDb = pd.getById(1);
//        System.out.println("Ho trovato questo lista di inviti per " + p12FromDb.getName() + ": " + p12FromDb.getPartecipations());
////ho dovuto commentare perchè andava in stackoverflow
//        //RICORDATI DI CHIUDERE DOPO CHE LO USI
//        em.close();
//        emf.close();
    }
}

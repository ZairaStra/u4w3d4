package zairastra.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import zairastra.entities.Concert;
import zairastra.entities.Event;
import zairastra.entities.enums.ConcertGenre;
import zairastra.exceptions.NotFound;

import java.util.List;

public class EventsDAO {
    //ENTITYMANAGER SERVE A GESTIRE I METODI TUTTI NEL DAO PASSANDOLA COME PARAMETRO IN MODO DA LASCIARE PULITO IL MAIN
    //E NON RISCRIVERE I METODI OGNI VOLTA CHE VOGLIO RICHIAMARLI SU UN ELEMENTO DELLA TABELLA
    private EntityManager entityManager;

    public EventsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveEvent(Event newEvent) {
        //PER LE AZIONI CHE HANNO UNA DURATA TEMPORALE ABBIAMO BISOGNI DI UNA TRANSAZIONE
        //EVITA CHE DUE AZIONI SI SOVRAPPONGANO

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newEvent); //QUI L'EVENTO è SOLO MANAGED, "GESTITO,PRESO IN CARICO"
        transaction.commit();// è SOLO IN QUESTO MOMENTO CHE L'EVENTO VIENE EFFETTIVAMENTE AGGIUNTO IN TABELLA
        //PRIMA SI TROVA IN UN "LIMBO", QUELLO DEL MANAGED

        System.out.println("L'evento " + newEvent.getName() + " è stato aggiunto all'agenda");
    }

    //PER CERCARE PER ID SFRUTTO IL METODO FIND DELL'ENTITYMANAGER
    //RICORDA DI GESTIRE LE ECCEZIONI
    public Event getById(long eventId) {
        Event found = entityManager.find(Event.class, eventId);
        if (found == null) throw new NotFound(eventId);
        return found;
    }

    public void deleteEvent(Event newEvent) {
        //PER LE AZIONI CHE HANNO UNA DURATA TEMPORALE ABBIAMO BISOGNI DI UNA TRANSAZIONE
        //EVITA CHE DUE AZIONI SI SOVRAPPONGANO

        //L'UNICA DIFFERENZA RISPETTO ALLA CREAZIONE è CHE PER RIMUOVERLO LO CERCO PER ID, usando il metodo di sopra
        Event found = this.getById(newEvent.getId());

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found); //QUI L'EVENTO è SOLO MANAGED, "GESTITO,PRESO IN CARICO"
        transaction.commit();// è SOLO IN QUESTO MOMENTO CHE L'EVENTO VIENE EFFETTIVAMENTE AGGIUNTO IN TABELLA
        //PRIMA SI TROVA IN UN "LIMBO", QUELLO DEL MANAGED

        System.out.println("L'evento " + newEvent.getName() + " è stato rimosso dall'agenda");
    }


    //estendo event per Concert
    //getConcertsperGenre

    public List<Concert> getConcertsperGenre(ConcertGenre genre) {
        TypedQuery<Concert> query = entityManager.createQuery("SELECT c FROM Concert c WHERE c.genre = :genre", Concert.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }

    //getStreamingConcert
    public List<Concert> getStreamingConcert(boolean streaming) {
        TypedQuery<Concert> query = entityManager.createQuery("SELECT c FROM Concert c WHERE c.streaming = :streaming", Concert.class);
        query.setParameter("streaming", streaming);
        return query.getResultList();
    }
}

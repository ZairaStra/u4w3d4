package zairastra.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import zairastra.entities.Partecipation;
import zairastra.exceptions.NotFound;

public class PartecipationsDAO {
    private EntityManager entityManager;

    public PartecipationsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void savePartecipation(Partecipation newPart) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPart);
        transaction.commit();

        System.out.println("Partecipazione salvata per " + newPart.getPerson().getName()
                + " all'evento " + newPart.getEvent().getName());
    }

    public Partecipation getById(long partId) {
        Partecipation found = entityManager.find(Partecipation.class, partId);
        if (found == null) throw new NotFound(partId);
        return found;
    }

    public void deletePartecipation(Partecipation part) {
        Partecipation found = this.getById(part.getId());

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("Partecipazione rimossa per " + part.getPerson().getName()
                + " all'evento " + part.getEvent().getName());
    }
}

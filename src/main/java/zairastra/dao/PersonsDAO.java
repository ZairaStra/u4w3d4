package zairastra.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import zairastra.entities.Person;
import zairastra.exceptions.NotFound;

public class PersonsDAO {
    private EntityManager entityManager;

    public PersonsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void savePerson(Person newPerson) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPerson);
        transaction.commit();

        System.out.println("La persona " + newPerson.getName() + " " + newPerson.getSurname() + " è stata aggiunta.");
    }

    public Person getById(long personId) {
        Person found = entityManager.find(Person.class, personId);
        if (found == null) throw new NotFound(personId);
        return found;
    }

    public void deletePerson(Person person) {
        Person found = this.getById(person.getId());

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();

        System.out.println("La persona " + person.getName() + " " + person.getSurname() + " è stata rimossa.");
    }
}

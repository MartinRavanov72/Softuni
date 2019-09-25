package hibernate_excr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        String name = scanner.readLine();
        Address address = new Address("Vitoshka 15", 32);
        em.persist(address);
        em.getTransaction().commit();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE Employee AS e\n" +
                "SET e.address_id = ?1\n" +
                "WHERE e.lastName LIKE (?2)");
        query.setParameter(1, address.getAddress_id());
        query.setParameter(2, name);
        query.executeUpdate();
        em.getTransaction().commit();
    }
}
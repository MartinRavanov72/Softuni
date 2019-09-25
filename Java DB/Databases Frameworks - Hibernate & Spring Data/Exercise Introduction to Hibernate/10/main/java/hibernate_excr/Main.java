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
        String townForDelete = scanner.readLine();

        Query query = em.createQuery("SELECT e FROM Employee AS e\n" +
                "JOIN Address AS a\n" +
                "ON a.address_id = e.address_id\n" +
                "JOIN Town AS t\n" +
                "ON t.id = a.town_id\n" +
                "WHERE t.name LIKE (?1)");

        query.setParameter(1, townForDelete);
        List<Employee> employees = query.getResultList();
        for (Employee employee : employees) {
            employee.setAddress_id(1);
        }
        em.getTransaction().commit();
        em.getTransaction().begin();

        query = em.createQuery("SELECT a FROM Address AS a\n" +
                "JOIN Town AS t\n" +
                "ON t.id = a.town_id\n" +
                "WHERE t.name LIKE (?1)");
        query.setParameter(1, townForDelete);
        List<Address> addresses = query.getResultList();
        for (Address address : addresses) {
            em.remove(address);
        }
        em.getTransaction().commit();
        em.getTransaction().begin();

        query = em.createQuery("SELECT t FROM Town AS t WHERE t.name = ?1");
        query.setParameter(1, townForDelete);
        Town town = (Town) query.getSingleResult();
        em.remove(town);

        if (addresses.size() == 1) {
            System.out.println(String.format("%d address in %s deleted", addresses.size(), townForDelete));
        } else {
            System.out.println(String.format("%d addresses in %s deleted", addresses.size(), townForDelete));
        }

        em.getTransaction().commit();
    }
}
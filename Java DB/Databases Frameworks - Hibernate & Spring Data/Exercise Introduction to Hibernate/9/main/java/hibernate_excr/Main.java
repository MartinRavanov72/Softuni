package hibernate_excr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE Employee AS e\n" +
                "SET e.salary = 1.12 * e.salary\n" +
                "WHERE e.departmentId IN(1, 2, 4, 11)");
        query.executeUpdate();
        em.getTransaction().commit();
        em.getTransaction().begin();
        query = em.createQuery("SELECT e.firstName, e.lastName, e.salary\n" +
                "FROM Employee AS e\n" +
                "WHERE e.departmentId IN(1, 2, 4, 11)");
        List<Object[]> result = query.getResultList();
        for (Object[] a : result) {
            String firstName = (String) a[0];
            String lastName = (String) a[1];
            double salary = (double) a[2];
            System.out.println(firstName + " " + lastName + " ($" + salary + ")");
        }
        em.getTransaction().commit();
    }
}
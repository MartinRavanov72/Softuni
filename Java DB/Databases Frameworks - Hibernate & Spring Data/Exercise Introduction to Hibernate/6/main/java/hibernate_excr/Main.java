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
        Query query = em.createQuery("SELECT a.address_text, t.name, COUNT(e.id) AS employee_count\n" +
                "FROM Address AS a\n" +
                "JOIN Employee AS e\n" +
                "ON e.address_id = a.address_id\n" +
                "JOIN Town AS t\n" +
                "ON a.town_id = t.id\n" +
                "GROUP BY e.address_id\n" +
                "ORDER BY employee_count DESC, t.id");
        query.setMaxResults(10);
        List<Object[]> result = query.getResultList();
        for (Object[] a : result) {
            String addressText = (String) a[0];
            String name = (String) a[1];
            long count = (long) a[2];
            System.out.println(addressText + ", " + name + " - " + count + " " + "employees");
        }
        em.getTransaction().commit();
    }
}
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
        String townName = scanner.readLine();
        Query query = em.createQuery("SELECT e.firstName, e.lastName, e.jobTitle, e.salary\n" +
                "FROM Employee AS e\n" +
                "WHERE e.firstName LIKE (?1)");
        query.setParameter(1, townName + "%");
        List<Object[]> result = query.getResultList();
        for (Object[] a : result) {
            String firstName = (String) a[0];
            String lastName = (String) a[1];
            String jobTitle = (String) a[2];
            double salary = (double) a[3];
            System.out.println(firstName + " " + lastName + " - " + jobTitle + " - ($" + salary + ")");
        }
        em.getTransaction().commit();
    }
}
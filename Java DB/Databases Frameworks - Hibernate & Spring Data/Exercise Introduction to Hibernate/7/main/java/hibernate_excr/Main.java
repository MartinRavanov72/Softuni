package hibernate_excr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        int employeeId = Integer.parseInt(scanner.readLine());
        Query query = em.createQuery("SELECT e.firstName, e.lastName, e.jobTitle, p.name\n" +
                "FROM Employee AS e\n" +
                "LEFT JOIN Employee_Project AS ep\n" +
                "ON e.id = ep.employee_id\n" +
                "LEFT JOIN Project AS p\n" +
                "ON p.project_id = ep.project_id\n" +
                "WHERE e.id = ?1\n" +
                "ORDER BY p.name");
        query.setParameter(1, employeeId);
        List<Object[]> result = query.getResultList();
        System.out.println(result.get(0)[0] + " " + result.get(0)[1] + " - " + result.get(0)[2]);
        for (Object[] a : result) {
            String name = (String) a[3];
            System.out.println("    " + name);
        }
        em.getTransaction().commit();
    }
}
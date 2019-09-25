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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT d.name, MAX(e.salary)\n" +
                "FROM Employee AS e\n" +
                "JOIN Department AS d\n" +
                "ON e.departmentId = d.department_id\n" +
                "WHERE e.salary < 30000 OR e.salary > 70000\n" +
                "GROUP BY d.department_id");
        List<Object[]> result = query.getResultList();
        for (Object[] a : result) {
            String name = (String) a[0];
            double salary = (double) a[1];
            System.out.println(name + " - " + salary);
        }
        em.getTransaction().commit();
    }
}
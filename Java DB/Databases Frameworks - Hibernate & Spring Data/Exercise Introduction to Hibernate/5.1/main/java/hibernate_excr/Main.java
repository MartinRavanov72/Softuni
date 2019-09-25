package hibernate_excr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e.firstName, e.lastName, d.name, e.salary\n" +
                "FROM Employee AS e\n" +
                "JOIN Department AS d\n" +
                "ON e.departmentId = d.department_id\n" +
                "WHERE d.name LIKE ('Research and Development')\n" +
                "ORDER BY e.salary, e.id");
        List<Object[]> employees = query.getResultList();
        for (Object[] entry : employees) {
            String firstName = (String) entry[0];
            String lastName = (String) entry[1];
            String name = (String) entry[2];
            double salary = (double) entry[3];
            System.out.println(firstName + " " + lastName + " from " + name + " - $" + salary);
        }
        em.getTransaction().commit();
    }
}
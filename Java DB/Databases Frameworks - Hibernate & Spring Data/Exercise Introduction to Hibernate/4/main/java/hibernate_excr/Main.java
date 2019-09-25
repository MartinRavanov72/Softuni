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
        Query query = em.createQuery("SELECT e.firstName FROM Employee AS e\n" +
                "WHERE e.salary > 50000");
        List<String> employees = query.getResultList();
        for (String employee : employees) {
            System.out.println(employee);
        }
        em.getTransaction().commit();
    }
}
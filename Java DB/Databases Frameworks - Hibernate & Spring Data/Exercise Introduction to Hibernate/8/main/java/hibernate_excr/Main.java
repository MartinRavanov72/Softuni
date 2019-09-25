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
        Query query = em.createQuery("SELECT p.name, p.description, p.start_date, p.end_date\n" +
                "FROM Project AS p\n" +
                "ORDER BY p.start_date DESC");
        query.setMaxResults(10);
        List<Object[]> result = query.getResultList();
        for (Object[] a : result) {
            String name = (String) a[0];
            String description = (String) a[1];
            LocalDate startDate = (LocalDate) a[2];
            LocalDate endDate = (LocalDate) a[3];
            System.out.println("Project name: " + name + "\n" +
                    "   Project Description: " + description + "\n" +
                    "   Project Start Date:" + startDate + "\n" +
                    "   Project End Date: " + endDate);
        }
        em.getTransaction().commit();
    }
}
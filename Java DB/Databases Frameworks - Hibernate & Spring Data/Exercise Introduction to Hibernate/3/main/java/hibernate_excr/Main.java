package hibernate_excr;

import javax.persistence.*;
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
        Query query = em.createQuery("SELECT CONCAT(e.firstName, ' ', e.lastName) FROM Employee AS e\n" +
                "WHERE e.firstName LIKE (?1) AND e.lastName LIKE (?2)");
        query.setParameter(1, name.split("\\s+")[0]);
        query.setParameter(2, name.split("\\s+")[1]);
        try {
            String foundName = (String) query.getSingleResult();
            System.out.println("Yes");
        }
        catch (NoResultException nre){
            System.out.println("No");
        }
        em.getTransaction().commit();
    }
}
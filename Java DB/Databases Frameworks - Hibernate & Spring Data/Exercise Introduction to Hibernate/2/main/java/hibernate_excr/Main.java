package hibernate_excr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE Town AS t\n" +
                "SET t.name = LOWER(t.name)\n" +
                "WHERE CHAR_LENGTH(t.name) > 5");
        query.executeUpdate();
        em.getTransaction().commit();
    }
}
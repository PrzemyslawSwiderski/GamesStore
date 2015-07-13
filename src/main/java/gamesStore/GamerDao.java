package gamesStore;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import static java.lang.System.out;

@Component
public class GamerDao {
    private Session session;

    public int register(Gamer g) {

        session = new Configuration().configure().buildSessionFactory().openSession();

        int i = 0;

        Transaction t = session.beginTransaction();
        t.begin();

        i = (Integer) session.save(g);

        t.commit();

        session.close();

        return i;
    }

    public List<Gamer> loadList() {
        session = new Configuration().configure().buildSessionFactory().openSession();
        Query query = session.createQuery("from Gamer");

        @SuppressWarnings("unchecked")
        List<Gamer> list = query.list();

        session.close();

        return list;
    }

    public String gamersToString() {
        session = new Configuration().configure().buildSessionFactory().openSession();
        Query query = session.createQuery("from Gamer");

        @SuppressWarnings("unchecked")
        List<Gamer> list = query.list();

        String stringList = "";
        Iterator<Gamer> itr = list.iterator();
        while (itr.hasNext()) {
            Gamer g = itr.next();
            stringList += g;
            stringList += "\n";
        }
        session.close();

        return stringList;
    }

    public void deleteAll() {
        session = new Configuration().configure().buildSessionFactory().openSession();
        out.println("Trying to delete entitiessssss.");

        Transaction t = session.beginTransaction();
        t.begin();

        Query query = session.createQuery("delete from Gamer");
        query.executeUpdate();

        t.commit();

        session.close();
    }
}

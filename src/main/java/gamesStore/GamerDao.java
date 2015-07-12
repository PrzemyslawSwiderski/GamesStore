package gamesStore;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class GamerDao
{
	private Session session;
	public GamerDao()
	{
		session = new Configuration().configure().buildSessionFactory()
				.openSession();
	}
	
	public int register(Gamer g)
	{
		int i = 0;

		Transaction t = session.beginTransaction();
		t.begin();

		i = (Integer) session.save(g);

		t.commit();

		return i;
	}

	public List<Gamer> loadList()
	{
		Session session = new Configuration().configure()
				.buildSessionFactory().openSession();

		Query query = session.createQuery("from Gamer");
		
		@SuppressWarnings("unchecked")
		List<Gamer> list = query.list();

		session.close();
		
		return list;
	}
	public String gamersToString()
	{
		Session session = new Configuration().configure()
				.buildSessionFactory().openSession();

		Query query = session.createQuery("from Gamer");
		
		@SuppressWarnings("unchecked")
		List<Gamer> list = query.list();

		String stringList="";
		Iterator<Gamer> itr = list.iterator();
		while (itr.hasNext())
		{
			Gamer g = itr.next();
			stringList+=g;
			stringList+="\n";
		}
		session.close();
		
		return stringList;
	}
	public void deleteAll()
	{
		Session session = new Configuration().configure()
				.buildSessionFactory().openSession();
		
		session.createSQLQuery("truncate table gamer").executeUpdate();
		session.close();
	}
}

package gamesStore.dao;

import gamesStore.model.Gamer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Przemek_Swiderski on 2015-07-15.
 */
public class GamerDaoImp implements GamerDao
{

    @Autowired
    private SessionFactory sessionFactory;

    public GamerDaoImp(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    @Override
    @Transactional
    public List<Gamer> list() {
        @SuppressWarnings("unchecked")
        List<Gamer> listGamer = (List<Gamer>) sessionFactory.getCurrentSession()
                .createCriteria(Gamer.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listGamer;
    }

    @Override
    @Transactional
    public void saveOrUpdate(Gamer gamer) {
        sessionFactory.getCurrentSession().saveOrUpdate(gamer);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Gamer gamerToDelete = new Gamer();
        gamerToDelete.setIdGamer(id);
        sessionFactory.getCurrentSession().delete(gamerToDelete);
    }

    @Override
    @Transactional
    public void clear()
    {
        String hql = "delete from Gamer";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public Gamer get(int id) {
        String hql = "from Gamer where idGamer=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<Gamer> gamerList = (List<Gamer>) query.list();

        if (gamerList != null && !gamerList.isEmpty()) {
            return gamerList.get(0);
        }

        return null;
    }

}
package gamesStore.dao;

import gamesStore.model.Game;
import gamesStore.model.Gamer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Przemek_Swiderski on 2015-07-16.
 */
public class GameDaoImp implements GameDao
{
    @Autowired
    private SessionFactory sessionFactory;

    public GameDaoImp(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Game> list()
    {
        @SuppressWarnings("unchecked")
        List<Game> listGame = (List<Game>) sessionFactory.getCurrentSession()
                .createCriteria(Game.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listGame;
    }

    @Override
    @Transactional
    public Game get(int id)
    {
        String hql = "from Game where idGame=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<Game> gameList = (List<Game>) query.list();

        if (gameList != null && !gameList.isEmpty()) {
            return gameList.get(0);
        }

        return null;
    }

    @Override
    @Transactional
    public void saveOrUpdate(Game game)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(game);
    }

    @Override
    @Transactional
    public void delete(int id)
    {
        Game gameToDelete = new Game();
        gameToDelete.setIdGame(id);
        sessionFactory.getCurrentSession().delete(gameToDelete);
    }

    @Override
    @Transactional
    public void clear()
    {
        String hql = "delete from Game";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.executeUpdate();
    }
}

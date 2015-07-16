package gamesStore.dao;

import gamesStore.model.Game;

import java.util.List;

/**
 * Created by Przemek_Swiderski on 2015-07-16.
 */
public interface GameDao
{

    public List<Game> list();

    public Game get(int id);

    public void saveOrUpdate(Game game);

    public void delete(int id);

    public void clear();

}

package gamesStore.dao;

import gamesStore.model.Gamer;

import java.util.List;

public interface GamerDao {

    public List<Gamer> list();

    public Gamer get(int id);

    public void saveOrUpdate(Gamer user);

    public void delete(int id);

    public void clear();

}

package gamesStore;

import gamesStore.config.ApplicationContextConfig;
import gamesStore.dao.GameDao;
import gamesStore.model.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Przemek_Swiderski on 2015-07-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ApplicationContextConfig.class)
public class GameDaoTest
{
    @Autowired
    private GameDao gameDao;

    @Test
    public void saveTest()
    {
        gameDao.saveOrUpdate(new Game("asdas", "gfd123", Calendar.getInstance().getTime(), 5));
        gameDao.saveOrUpdate(new Game("s", "213ds", Calendar.getInstance().getTime(), 51));
        gameDao.saveOrUpdate(new Game("ddsds", "23sad", Calendar.getInstance().getTime(), 4));
        gameDao.saveOrUpdate(new Game("aas", "23asdas", Calendar.getInstance().getTime(), 1));
    }

    @Test
    public void clearTest()
    {
        gameDao.clear();
    }

    @Test
    public void printTest()
    {
        List<Game> gameList = gameDao.list();
        for (Game g : gameList)
        {
            System.out.println(g);
        }
    }
}

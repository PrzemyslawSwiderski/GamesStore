package gamesStore;

import gamesStore.config.ApplicationContextConfig;
import gamesStore.dao.GameDao;
import gamesStore.model.Game;
import gamesStore.model.Gamer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Przemek_Swiderski on 2015-07-16.
 */
public class GameDaoTest
{
    private GameDao gameDao;

    @Before
    public void setUp()
    {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(ApplicationContextConfig.class);
        appContext.refresh();
        gameDao = appContext.getBean(GameDao.class);
    }

    @Test
    public void saveTest()
    {
        gameDao.saveOrUpdate(new Game("asdas","gfd123", LocalDate.now(),5));
        gameDao.saveOrUpdate(new Game("s","213ds",LocalDate.now(), 51));
        gameDao.saveOrUpdate(new Game("ddsds","23sad",LocalDate.now() ,4));
        gameDao.saveOrUpdate(new Game("aas","23asdas",LocalDate.now(),1));
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

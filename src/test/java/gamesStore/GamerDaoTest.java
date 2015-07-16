package gamesStore;

import gamesStore.config.ApplicationContextConfig;
import gamesStore.dao.GamerDao;
import gamesStore.dao.GamerDaoImp;
import gamesStore.model.Gamer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.List;

/**
 * Created by Przemek_Swiderski on 2015-07-15.
 */
public class GamerDaoTest
{
    private GamerDao gamerDao;

    @Before
    public void setUp()
    {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(ApplicationContextConfig.class);
        appContext.refresh();
        gamerDao = appContext.getBean(GamerDao.class);
    }

    @Test
    public void clearTest()
    {
        gamerDao.clear();
    }

    @Test
    public void fillTest()
    {
        gamerDao.saveOrUpdate(new Gamer("d", "safasf"));
        gamerDao.saveOrUpdate(new Gamer("ds", "sssssf"));
        gamerDao.saveOrUpdate(new Gamer("dsdd", "aaaaaf"));
        gamerDao.saveOrUpdate(new Gamer("dsdasd", "cccccf"));
    }

    @Test
    public void printTest()
    {
        List<Gamer> gamerList = gamerDao.list();
        for (Gamer g : gamerList)
        {
            System.out.println(g);
        }
    }
}

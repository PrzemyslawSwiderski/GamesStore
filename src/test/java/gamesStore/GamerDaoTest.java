package gamesStore;

import gamesStore.config.ApplicationContextConfig;
import gamesStore.dao.GamerDao;
import gamesStore.model.Gamer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by Przemek_Swiderski on 2015-07-15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ApplicationContextConfig.class)
public class GamerDaoTest
{
    @Autowired
    private GamerDao gamerDao;

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

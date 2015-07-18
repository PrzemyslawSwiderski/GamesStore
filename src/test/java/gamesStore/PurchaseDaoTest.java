package gamesStore;

import gamesStore.config.ApplicationContextConfig;
import gamesStore.dao.GameDao;
import gamesStore.dao.GamerDao;
import gamesStore.dao.PurchaseDao;
import gamesStore.model.Game;
import gamesStore.model.Gamer;
import gamesStore.model.Purchase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Przemek_Swiderski on 2015-07-18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ApplicationContextConfig.class)
public class PurchaseDaoTest
{
    @Autowired
    private GameDao gameDao;
    @Autowired
    private GamerDao gamerDao;
    @Autowired
    private PurchaseDao purchaseDao;

    @Test
    public void saveTest()
    {
        Game game = new Game("asdas", "gfd123", Calendar.getInstance().getTime(), 5);
        Gamer gamer = new Gamer("d", "safasf");
        gameDao.saveOrUpdate(game);
        gamerDao.saveOrUpdate(gamer);

        purchaseDao.saveOrUpdate(new Purchase(game, gamer));
    }

    @Test
    public void clearTest()
    {
        purchaseDao.clear();
    }

    @Test
    public void printTest()
    {
        List<Purchase> purchaseList = purchaseDao.list();
        for (Purchase p : purchaseList)
        {
            System.out.println(p.getIdPurchase()+"  "+p.getName()+"  "+p.getTitle());
        }
    }
    @Test
    public void integrityTest()
    {
        Game game = new Game("asdas", "gfd123", Calendar.getInstance().getTime(), 5);
        Gamer gamer = new Gamer("d", "safasf");
        gameDao.saveOrUpdate(game);
        gamerDao.saveOrUpdate(gamer);

        purchaseDao.saveOrUpdate(new Purchase(game, gamer));
        gameDao.delete(game.getIdGame());
    }
}

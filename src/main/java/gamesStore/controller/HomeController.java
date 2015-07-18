package gamesStore.controller;

import gamesStore.dao.GameDao;
import gamesStore.dao.GamerDao;
import gamesStore.dao.PurchaseDao;
import gamesStore.model.Game;
import gamesStore.model.Gamer;
import gamesStore.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class HomeController
{
    @Autowired
    private GamerDao gamerDao;
    @Autowired
    private GameDao gameDao;
    @Autowired
    private PurchaseDao purchaseDao;

    @RequestMapping("/")
    public ModelAndView handleRequest() throws Exception
    {
        ModelAndView model = new ModelAndView("Home");

        List<Gamer> gamerList = gamerDao.list();
        model.addObject("gamerList", gamerList);

        List<Game> gameList = gameDao.list();
        model.addObject("gameList", gameList);

        List<Purchase> purchaseList = purchaseDao.list();
        model.addObject("purchaseList", purchaseList);

        return model;
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.GET)
    public ModelAndView addPurchase(HttpServletRequest request)
    {
        int gamerId;
        int gameId;
        try
        {
            gamerId = Integer.parseInt(request.getParameter("gamerID"));
            gameId = Integer.parseInt(request.getParameter("gameID"));
        } catch (Exception e)
        {
            return new ModelAndView("redirect:.");
        }

        Gamer gamer = gamerDao.get(gamerId);
        Game game = gameDao.get(gameId);

        purchaseDao.saveOrUpdate(new Purchase(game, gamer));
        gameDao.saveOrUpdate(game);
        return new ModelAndView("redirect:.");
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public ModelAndView deleteAll()
    {
        purchaseDao.clear();
        return new ModelAndView("redirect:.");
    }
}

package gamesStore.controller;

import gamesStore.dao.GameDao;
import gamesStore.dao.GamerDao;
import gamesStore.dao.PurchaseDao;
import gamesStore.model.Game;
import gamesStore.model.Gamer;
import gamesStore.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

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
    public ModelAndView addPurchase(@RequestParam("gamerID") Integer gamerId, @RequestParam("gameID") Integer gameId)
    {
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

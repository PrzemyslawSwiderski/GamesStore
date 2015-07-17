package gamesStore.controller;

import gamesStore.dao.GameDao;
import gamesStore.dao.GamerDao;
import gamesStore.model.Game;
import gamesStore.model.Gamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class HomeController
{
    @Autowired
    private GamerDao gamerDao;
    @Autowired
    private GameDao gameDao;

    @RequestMapping("/")
    public ModelAndView handleRequest() throws Exception
    {
        ModelAndView model = new ModelAndView("Home");

        List<Gamer> gamerList = gamerDao.list();
        model.addObject("gamerList", gamerList);

        List<Game> gameList = gameDao.list();
        model.addObject("gameList", gameList);

        return model;
    }
}

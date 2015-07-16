package gamesStore.controller;

import gamesStore.dao.GameDao;
import gamesStore.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Przemek_Swiderski on 2015-07-16.
 */
@Controller
public class GameController
{

    @Autowired
    private GameDao gameDao;

    @RequestMapping("/gamelist")
    public ModelAndView getGameList() throws Exception
    {
        List<Game> gameList = gameDao.list();
        ModelAndView model = new ModelAndView("GameList");
        model.addObject("gameList", gameList);
        return model;
    }

    @RequestMapping(value = "/gamelist/new", method = RequestMethod.GET)
    public ModelAndView newGame()
    {
        ModelAndView model = new ModelAndView("GameForm");
        model.addObject("game", new Game());
        return model;
    }

    @RequestMapping(value = "/gamelist/edit", method = RequestMethod.GET)
    public ModelAndView editGame(HttpServletRequest request)
    {
        int gameId = Integer.parseInt(request.getParameter("id"));
        Game game = gameDao.get(gameId);
        ModelAndView model = new ModelAndView("GameForm");
        model.addObject("game", game);
        return model;
    }

    @RequestMapping(value = "/gamelist/delete", method = RequestMethod.GET)
    public ModelAndView deleteGame(HttpServletRequest request)
    {
        int gameId = Integer.parseInt(request.getParameter("id"));
        gameDao.delete(gameId);
        return new ModelAndView("redirect:/gamelist");
    }

    @RequestMapping(value = "/gamelist/save", method = RequestMethod.POST)
    public ModelAndView saveGame(@ModelAttribute Game game)
    {
        gameDao.saveOrUpdate(game);
        return new ModelAndView("redirect:/gamelist");
    }

    @RequestMapping(value = "/gamelist/deleteAll", method = RequestMethod.GET)
    public ModelAndView deleteAll()
    {
        gameDao.clear();
        return new ModelAndView("redirect:/gamelist");
    }
}

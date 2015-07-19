package gamesStore.controller;

import gamesStore.dao.GameDao;
import gamesStore.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Przemek_Swiderski on 2015-07-16.
 */

@Controller
@RequestMapping("/gamelist")
public class GameController
{

    @Autowired
    private GameDao gameDao;


    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @RequestMapping("/")
    public ModelAndView getGameList() throws Exception
    {
        List<Game> gameList = gameDao.list();
        ModelAndView model = new ModelAndView("GameList");
        model.addObject("gameList", gameList);
        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newGame()
    {
        ModelAndView model = new ModelAndView("GameForm");
        model.addObject("game", new Game());
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editGame(HttpServletRequest request)
    {
        int gameId = Integer.parseInt(request.getParameter("id"));
        Game game = gameDao.get(gameId);
        ModelAndView model = new ModelAndView("GameForm");
        model.addObject("game", game);
        return model;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteGame(HttpServletRequest request)
    {
        int gameId = Integer.parseInt(request.getParameter("id"));
        gameDao.delete(gameId);
        return new ModelAndView("redirect:.");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveGame(@ModelAttribute Game game, BindingResult result)
    {
        if (result.hasErrors())
        {
            return new ModelAndView("GameForm");
        }
        gameDao.saveOrUpdate(game);
        return new ModelAndView("redirect:.");
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public ModelAndView deleteAll()
    {
        gameDao.clear();
        return new ModelAndView("redirect:.");
    }
}

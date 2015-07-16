package gamesStore.controller;

import gamesStore.dao.GameDao;
import gamesStore.dao.GamerDao;
import gamesStore.model.Gamer;
import org.springframework.beans.factory.annotation.Autowired;
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
public class GamerController
{
    @Autowired
    private GamerDao gamerDao;

    @RequestMapping("/gamerlist")
    public ModelAndView getGamerList() throws Exception {
        List<Gamer> gamerList = gamerDao.list();
        ModelAndView model = new ModelAndView("GamerList");
        model.addObject("gamerList", gamerList);
        return model;
    }

    @RequestMapping(value = "/gamerlist/new", method = RequestMethod.GET)
    public ModelAndView newGamer() {
        ModelAndView model = new ModelAndView("GamerForm");
        model.addObject("gamer", new Gamer());
        return model;
    }

    @RequestMapping(value = "/gamerlist/edit", method = RequestMethod.GET)
    public ModelAndView editGamer(HttpServletRequest request) {
        int gamerId = Integer.parseInt(request.getParameter("id"));
        Gamer gamer = gamerDao.get(gamerId);
        ModelAndView model = new ModelAndView("GamerForm");
        model.addObject("gamer", gamer);
        return model;
    }

    @RequestMapping(value = "/gamerlist/delete", method = RequestMethod.GET)
    public ModelAndView deleteGamer(HttpServletRequest request) {
        int gamerId = Integer.parseInt(request.getParameter("id"));
        gamerDao.delete(gamerId);
        return new ModelAndView("redirect:/gamerlist");
    }

    @RequestMapping(value = "/gamerlist/save", method = RequestMethod.POST)
    public ModelAndView saveGamer(@ModelAttribute Gamer gamer) {
        gamerDao.saveOrUpdate(gamer);
        return new ModelAndView("redirect:/gamerlist");
    }
    @RequestMapping(value = "/gamerlist/deleteAll", method = RequestMethod.GET)
    public ModelAndView deleteAll() {
        gamerDao.clear();
        return new ModelAndView("redirect:/gamerlist");
    }
}

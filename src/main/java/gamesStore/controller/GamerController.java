package gamesStore.controller;

import gamesStore.dao.GamerDao;
import gamesStore.model.Gamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
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
@RequestMapping(value = "/gamerlist")
public class GamerController
{
    @Autowired
    private GamerDao gamerDao;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @RequestMapping(value = "/")
    public ModelAndView getGamerList() throws Exception
    {
        List<Gamer> gamerList = gamerDao.list();
        ModelAndView model = new ModelAndView("GamerList");
        model.addObject("gamerList", gamerList);
        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newGamer()
    {
        ModelAndView model = new ModelAndView("GamerForm");
        model.addObject("gamer", new Gamer());
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editGamer(HttpServletRequest request)
    {
        int gamerId = Integer.parseInt(request.getParameter("id"));
        Gamer gamer = gamerDao.get(gamerId);
        ModelAndView model = new ModelAndView("GamerForm");
        model.addObject("gamer", gamer);
        return model;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteGamer(HttpServletRequest request)
    {
        int gamerId = Integer.parseInt(request.getParameter("id"));
        gamerDao.delete(gamerId);
        return new ModelAndView("redirect:.");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveGamer(@ModelAttribute Gamer gamer)
    {
        gamerDao.saveOrUpdate(gamer);
        return new ModelAndView("redirect:.");
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    public ModelAndView deleteAll()
    {
        gamerDao.clear();
        return new ModelAndView("redirect:.");
    }
}

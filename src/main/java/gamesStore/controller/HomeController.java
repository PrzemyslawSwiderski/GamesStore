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


@Controller
public class HomeController
{
    @RequestMapping("/")
    public ModelAndView handleRequest() throws Exception {
        return  new ModelAndView("Home");
    }
}

package gamesStore;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GamerController
{
	@Autowired
	private GamerDao	gamerDao;

	@RequestMapping(value = "/gamer")
	public ModelAndView gamersList(HttpServletRequest request)
	{

		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");

		if (name != "" && lastname != "" && name != null && lastname != null)
			gamerDao.register(new Gamer(name, lastname));

		return new ModelAndView("gamer.jsp", "gamerDao", gamerDao);
	}

}

package am.bagiryan.sboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

@Controller
public class RenderController {

    @RequestMapping(method = RequestMethod.GET, path = "/goto-register")
    public ModelAndView registration() {
        return new ModelAndView("register");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }


}

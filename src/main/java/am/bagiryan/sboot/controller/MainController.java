/*
package am.bagiryan.sboot.controller;

import am.bagiryan.sboot.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {


    @Autowired
    private MainService mainService;


    @RequestMapping(method = RequestMethod.GET, path = {"", "/", "index"})
    public ModelAndView home(@CookieValue(value = "cookieUsername", required = false) Cookie cookieUsername,
                             HttpSession session) {

        return mainService.home(session, cookieUsername);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/register")
    public ModelAndView registration() {

        return new ModelAndView("register");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/validation")
    public ModelAndView validation() {

        return new ModelAndView("validation");
    }


    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password,
                              @RequestParam(required = false, defaultValue = "false") boolean remember,
                              HttpSession session, HttpServletResponse response) {

        return mainService.login(username, password, session, response, remember);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public ModelAndView register(@RequestParam String name, @RequestParam String surname,
                                 @RequestParam String username, @RequestParam String password,
                                 @RequestParam(required = false, defaultValue = "0") int age, HttpSession session) {

        return mainService.register(username, name, surname, password, age, session);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/validate")
    public ModelAndView validate(@RequestParam(defaultValue = "0") int code, HttpSession session) {

        return mainService.validate(code, session);
    }
}
*/

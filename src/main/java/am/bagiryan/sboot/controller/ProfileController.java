package am.bagiryan.sboot.controller;

import am.bagiryan.sboot.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping(method = RequestMethod.GET, path = "/profile")
    public ModelAndView profile(HttpSession session) {

        return profileService.profile(session);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/logout")
    public ModelAndView logout(@CookieValue(value = "cookieUsername", required = false) Cookie cookieUsername,
                               HttpSession session, HttpServletResponse response) {

        return profileService.logout(session, cookieUsername, response);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/delete")
    public ModelAndView delete(@CookieValue(value = "cookieUsername", required = false) Cookie cookieUsername,
                               HttpSession session, HttpServletResponse response) {

        return profileService.delete(session, cookieUsername, response);
    }
}

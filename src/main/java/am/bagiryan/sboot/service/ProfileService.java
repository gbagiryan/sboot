package am.bagiryan.sboot.service;

import am.bagiryan.sboot.model.User;
import am.bagiryan.sboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class ProfileService {

    @Autowired
    private UserRepository userRepository;

    public ModelAndView profile(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return new ModelAndView("index", "login", "you must log in");
        }
        return new ModelAndView("profile");
    }
    public ModelAndView logout(HttpSession session, Cookie cookieUsername, HttpServletResponse response){
        if (cookieUsername!=null) {
            cookieUsername.setMaxAge(0);
            cookieUsername.setPath("/");
            response.addCookie(cookieUsername);
        }
        session.invalidate();
        return new ModelAndView("redirect:/");
    }

    public ModelAndView delete(HttpSession session, Cookie cookieUsername, HttpServletResponse response) {

        userRepository.delete((User) (session.getAttribute("user")));
        if (cookieUsername!=null) {
            cookieUsername.setMaxAge(0);
            cookieUsername.setPath("/");
            response.addCookie(cookieUsername);
        }
        session.invalidate();
        return new ModelAndView("redirect:/");
    }
}

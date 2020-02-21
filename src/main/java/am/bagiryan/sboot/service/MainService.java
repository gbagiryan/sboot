/*
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
public class MainService {

    @Autowired
    private UserRepository userRepository;

    public ModelAndView home(HttpSession session, Cookie cookieUsername) {
        if (cookieUsername != null) {
            session.setAttribute("user", userRepository.getByUsername(cookieUsername.getValue()));
            return new ModelAndView("redirect:/profile");
        } else {
            return new ModelAndView("index");
        }
    }


    public ModelAndView login(String username, String password, HttpSession session, HttpServletResponse response, Boolean remember) {

        User user = userRepository.getByUsernameAndPassword(username, password);
        if (user == null) {
            return new ModelAndView("index", "login", "Wrong login or password");
        }

        else  {
            session.setAttribute("user", user);

            if (remember) {
                Cookie cookie = new Cookie("cookieUsername", user.getUsername());
                cookie.setMaxAge(30 * 24 * 60);
                response.addCookie(cookie);
            }
            if (user.getStatus() == -1) {
                return new ModelAndView("redirect:/validation");
            }

            return new ModelAndView("redirect:/profile");
        }
    }


    public ModelAndView register(String username, String name, String surname, String password, int age, HttpSession session) {

        if (userRepository.existsByUsername(username)) {
            return new ModelAndView("register", "reg", "That username already exists");
        } else if (name == null || surname == null || username == null || password == null ||
                name.equals("") || surname.equals("") || username.equals("") || password.equals("")) {
            return new ModelAndView("register", "reg", "All fields must be filled");
        } else {
            User user = new User();

            user.setName(name);
            user.setSurname(surname);
            user.setUsername(username);
            user.setPassword(password);
            user.setAge(age);
            user.setStatus(-1);


            user.setCode((int) ((Math.random() * ((99999 - 10000) + 1)) + 10000));

            userRepository.save(user);

            session.setAttribute("user", user);
            return new ModelAndView("redirect:/validation");
        }
    }

    public ModelAndView validate(int code, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (code == user.getCode()) {
            user.setStatus(0);
            userRepository.save(user);
            return new ModelAndView("redirect:/profile");
        }
        return new ModelAndView("validation", "code","wrong validation code");

    }
}
*/

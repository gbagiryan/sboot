package am.bagiryan.sboot.controller;

import am.bagiryan.sboot.exceptions.DuplicateDataException;
import am.bagiryan.sboot.model.User;
import am.bagiryan.sboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = "/sign-on")
    public ModelAndView signOn(@RequestParam String username, @RequestParam String name,
                               @RequestParam String surname, @RequestParam String password,
                               @RequestParam(required = false, defaultValue = "0") int age) {
        try {
            User user = new User();

            user.setName(name);
            user.setSurname(surname);
            user.setUsername(username);
            user.setPassword(password);
            user.setAge(age);
            user.setStatus(-1);

            userService.add(user);
            return new ModelAndView("index", "message", "success");


        } catch (DuplicateDataException e) {
            return new ModelAndView("register", "message", e.getMessage());
        } catch (Throwable throwable) {
            return new ModelAndView("register", "message", "unexpected error");

        }


    }

}

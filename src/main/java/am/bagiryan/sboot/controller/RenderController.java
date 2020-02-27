package am.bagiryan.sboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RenderController {

    @RequestMapping(method = RequestMethod.GET, path = "/goto-register")
    public String registration() {
        return "register";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String home() {
        return "index";
    }


}

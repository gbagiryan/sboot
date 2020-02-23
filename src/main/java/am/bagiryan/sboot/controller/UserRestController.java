package am.bagiryan.sboot.controller;

import am.bagiryan.sboot.dto.VerifyDto;
import am.bagiryan.sboot.exceptions.DuplicateDataException;
import am.bagiryan.sboot.exceptions.NotFoundException;
import am.bagiryan.sboot.exceptions.ForbiddenException;
import am.bagiryan.sboot.model.User;
import am.bagiryan.sboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity resp() {
        User user = new User();
        user.setName("Trying");
        user.setSurname("Checking");

        return ResponseEntity.ok(user);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/sign-on")
    public ResponseEntity resp2(@RequestBody User user) {

        try {
            userService.add(user);
            return ResponseEntity.ok().build();
        } catch (DuplicateDataException e) {
            return ResponseEntity.status(409).build();
        } catch (Throwable throwable) {
            return ResponseEntity.status(500).build();

        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/username")
    public ResponseEntity resp3(@RequestParam String username) {
        System.out.println(username);

        return ResponseEntity.ok(username);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/verify")
    public ResponseEntity verification(@RequestBody VerifyDto verifyDto) {
        try {
            userService.verify(verifyDto);
            return ResponseEntity.ok().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ForbiddenException e) {
            return ResponseEntity.status(406).build();
        } catch (Throwable throwable) {
            return ResponseEntity.status(500).build();
        }
    }

}

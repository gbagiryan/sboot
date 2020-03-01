package am.bagiryan.sboot.controller;

import am.bagiryan.sboot.dto.ConfirmDto;
import am.bagiryan.sboot.dto.RecoverPasswordDto;
import am.bagiryan.sboot.dto.VerifyDto;
import am.bagiryan.sboot.exceptions.DuplicateDataException;
import am.bagiryan.sboot.exceptions.NotFoundException;
import am.bagiryan.sboot.exceptions.ForbiddenException;
import am.bagiryan.sboot.model.User;
import am.bagiryan.sboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity signOn(@RequestBody @Valid User user ) throws DuplicateDataException {
        userService.add(user);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/username")
    public ResponseEntity resp3(@RequestParam String username) {
        System.out.println(username);

        return ResponseEntity.ok(username);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/verify")
    public ResponseEntity verification(@RequestBody VerifyDto verifyDto) throws NotFoundException, ForbiddenException {

        userService.verify(verifyDto);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/recover-password")
    public ResponseEntity recover(@RequestBody RecoverPasswordDto dto) throws NotFoundException {

        userService.recoverPassword(dto);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/confirm-recovery")
    public ResponseEntity confirmRecovery(@RequestBody ConfirmDto confirmDto) throws NotFoundException, ForbiddenException {

        userService.confirmRecovery(confirmDto);
        return ResponseEntity.ok().build();

    }

}

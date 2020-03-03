package am.bagiryan.sboot.controller;

import am.bagiryan.sboot.exceptions.DuplicateDataException;
import am.bagiryan.sboot.exceptions.NotFoundException;
import am.bagiryan.sboot.model.Phone;
import am.bagiryan.sboot.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public class PhoneRestController {
    @Autowired
    PhoneService phoneService;

    @PostMapping
    public ResponseEntity addPhone(@Valid @RequestBody Phone phone) throws DuplicateDataException {
        phoneService.add(phone);
        return ResponseEntity.ok().build();
    }

    @PostMapping( path = "/get-card")
    public ResponseEntity getCard(@RequestBody Phone phone) throws NotFoundException {

        phoneService.get(phone);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getPhones() {
        List<Phone> phones = phoneService.getAll();
        return ResponseEntity.ok(phones);
    }
    @GetMapping("/{id}")
    public ResponseEntity getAPhone(@PathVariable int id){
        Phone phone = phoneService.getById(id);
        return ResponseEntity.ok(phone);
    }
}

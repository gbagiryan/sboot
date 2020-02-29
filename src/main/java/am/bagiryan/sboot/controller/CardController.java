package am.bagiryan.sboot.controller;

import am.bagiryan.sboot.exceptions.DuplicateDataException;
import am.bagiryan.sboot.exceptions.NotFoundException;
import am.bagiryan.sboot.model.Card;
import am.bagiryan.sboot.model.User;
import am.bagiryan.sboot.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/card")
public class CardController {

    @Autowired
    CardService cardService;

    @RequestMapping(method = RequestMethod.POST, path = "/add-card")
    public ResponseEntity addCard(@RequestBody Card card) {

        try {
            cardService.add(card);
            return ResponseEntity.ok().build();
        } catch (DuplicateDataException e) {
            return ResponseEntity.status(409).build();
        } catch (Throwable throwable) {
            return ResponseEntity.status(500).build();

        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/delete-card")
    public ResponseEntity deleteCard(@RequestBody Card card) {
        try {
            cardService.delete(card);
            return ResponseEntity.ok().build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/get-card")
    public ResponseEntity getCard(@RequestBody Card card) {
        try {
            cardService.get(card);
            return ResponseEntity.ok().build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

}

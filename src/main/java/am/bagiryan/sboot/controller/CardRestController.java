package am.bagiryan.sboot.controller;

import am.bagiryan.sboot.exceptions.DuplicateDataException;
import am.bagiryan.sboot.exceptions.NotFoundException;
import am.bagiryan.sboot.model.Card;
import am.bagiryan.sboot.model.User;
import am.bagiryan.sboot.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v2/card")
public class CardRestController {

    @Autowired
    CardService cardService;

    @PostMapping
    public ResponseEntity addCard(@Valid @RequestBody Card card) throws DuplicateDataException {
        cardService.add(card);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteCard(@RequestBody Card card) throws NotFoundException {

        cardService.delete(card);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(method = RequestMethod.POST, path = "/get-card")
    public ResponseEntity getCard(@RequestBody Card card) throws NotFoundException {

        cardService.get(card);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getCards() {
        List<Card> cards = cardService.getAll();
        return ResponseEntity.ok(cards);
    }
    @GetMapping("/{id}")
    public ResponseEntity getACard(@PathVariable int id){
        Card card = cardService.getById(id);
        return ResponseEntity.ok(card);
    }

}

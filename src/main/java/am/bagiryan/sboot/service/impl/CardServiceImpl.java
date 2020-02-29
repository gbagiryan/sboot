package am.bagiryan.sboot.service.impl;

import am.bagiryan.sboot.exceptions.DuplicateDataException;
import am.bagiryan.sboot.exceptions.NotFoundException;
import am.bagiryan.sboot.model.Card;
import am.bagiryan.sboot.repository.CardRepository;
import am.bagiryan.sboot.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;


    @Override
    public void add(Card card) throws DuplicateDataException {
        boolean exists = cardRepository.existsByNumber(card.getNumber());
        DuplicateDataException.check(exists, "card.by.number.exists");
        cardRepository.save(card);
    }

    @Override
    public void delete(Card card) throws NotFoundException {
        boolean exists = cardRepository.existsByNumber(card.getNumber());
        NotFoundException.check(!exists, "card.by.number.doesn't.exist");
        Card dbCard = cardRepository.getByNumber(card.getNumber());
        cardRepository.delete(dbCard);
    }

    @Override
    public Card get(Card card) throws NotFoundException {
        boolean exists = cardRepository.existsByNumber(card.getNumber());
        NotFoundException.check(!exists, "card.by.number.doesn't.exist");
        return cardRepository.getByNumber(card.getNumber());
    }

}

package am.bagiryan.sboot.service;

import am.bagiryan.sboot.exceptions.DuplicateDataException;
import am.bagiryan.sboot.exceptions.NotFoundException;
import am.bagiryan.sboot.model.Card;

public interface CardService {
    void add(Card card) throws DuplicateDataException;

    void delete(Card card) throws NotFoundException;

    Card get(Card card) throws NotFoundException;

}

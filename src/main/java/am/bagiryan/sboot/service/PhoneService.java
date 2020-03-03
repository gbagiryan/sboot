package am.bagiryan.sboot.service;

import am.bagiryan.sboot.exceptions.DuplicateDataException;
import am.bagiryan.sboot.model.Phone;

import java.util.List;

public interface PhoneService {
    void add(Phone phone) throws DuplicateDataException;

    List<Phone> getAll();

    void get(Phone phone);

    Phone getById(int id);
}

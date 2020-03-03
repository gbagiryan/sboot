package am.bagiryan.sboot.service.impl;

import am.bagiryan.sboot.exceptions.DuplicateDataException;
import am.bagiryan.sboot.model.Phone;
import am.bagiryan.sboot.repository.PhoneRepository;
import am.bagiryan.sboot.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {
    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public void add(Phone phone) throws DuplicateDataException {
        phoneRepository.save(phone);
    }

    @Override
    public List<Phone> getAll() {
        return null;
    }
}

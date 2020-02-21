package am.bagiryan.sboot.service;

import am.bagiryan.sboot.exceptions.DuplicateDataException;
import am.bagiryan.sboot.model.User;

public interface UserService {

    void add(User user) throws DuplicateDataException;
}

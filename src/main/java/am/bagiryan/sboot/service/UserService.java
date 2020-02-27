package am.bagiryan.sboot.service;

import am.bagiryan.sboot.dto.ConfirmDto;
import am.bagiryan.sboot.dto.RecoverPasswordDto;
import am.bagiryan.sboot.dto.VerifyDto;
import am.bagiryan.sboot.exceptions.DuplicateDataException;
import am.bagiryan.sboot.exceptions.NotFoundException;
import am.bagiryan.sboot.exceptions.ForbiddenException;
import am.bagiryan.sboot.model.User;

public interface UserService {

    void add(User user) throws DuplicateDataException;

    void verify(VerifyDto verifyDto) throws NotFoundException, ForbiddenException;

    void recoverPassword(RecoverPasswordDto dto) throws NotFoundException;

    void confirmRecovery(ConfirmDto confirmDto) throws NotFoundException, ForbiddenException;
}

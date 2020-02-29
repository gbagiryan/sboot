package am.bagiryan.sboot.service.impl;

import am.bagiryan.sboot.dto.ConfirmDto;
import am.bagiryan.sboot.dto.RecoverPasswordDto;
import am.bagiryan.sboot.dto.VerifyDto;
import am.bagiryan.sboot.exceptions.DuplicateDataException;
import am.bagiryan.sboot.exceptions.NotFoundException;
import am.bagiryan.sboot.exceptions.ForbiddenException;
import am.bagiryan.sboot.model.User;
import am.bagiryan.sboot.repository.UserRepository;
import am.bagiryan.sboot.service.UserService;
import am.bagiryan.sboot.util.Generator;
import am.bagiryan.sboot.util.MailSenderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MailSenderClient mailSender;


    @Override
    public void add(User user) throws DuplicateDataException {
        boolean exists = userRepository.existsByUsername(user.getUsername());
        DuplicateDataException.check(exists, "user.by.username.exists");
        user.setStatus(-1);
        user.setCode(Generator.randomString(5));
        userRepository.save(user);
        mailSender.send(user.getUsername(), "verify", "verification code is " + user.getCode());
    }

    @Override
    public void verify(VerifyDto verifyDto) throws NotFoundException, ForbiddenException {
        User user = userRepository.getByUsername(verifyDto.getUsername());
        NotFoundException.check(user == null, "Username doesn't exist");
        ForbiddenException.check(!user.getCode().equals(verifyDto.getCode()), "Wrong verification code");
        user.setStatus(0);
    }

    @Override
    public void recoverPassword(RecoverPasswordDto dto) throws NotFoundException {
        NotFoundException.check(!userRepository.existsByUsername(dto.getUsername()), "Username doesn't exist");
        User user = userRepository.getByUsername(dto.getUsername());
        user.setCode(Generator.randomString(5));
        userRepository.save(user);
        mailSender.send(user.getUsername(), "password change", "code is " + user.getCode());
    }

    @Override
    public void confirmRecovery(ConfirmDto confirmDto) throws NotFoundException, ForbiddenException {
        boolean exists = userRepository.existsByUsername(confirmDto.getUsername());
        NotFoundException.check(!exists, "Username doesn't exist");
        User user = userRepository.getByUsername(confirmDto.getUsername());
        ForbiddenException.check(!user.getCode().equals(confirmDto.getCode()), "Wrong verification code");
        user.setPassword(confirmDto.getPassword());
        userRepository.save(user);
    }
}

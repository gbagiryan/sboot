package am.bagiryan.sboot.service.impl;

import am.bagiryan.sboot.exceptions.DuplicateDataException;
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
        if (exists) {
            throw new DuplicateDataException("user.by.username.exists");
        }

        user.setStatus(-1);
        user.setCode(Generator.randomString(5));
        userRepository.save(user);
        mailSender.send(user.getUsername(), "verify", "verification code is "+ user.getCode() );
    }
}

package am.bagiryan.sboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class DuplicateDataException extends Exception {

    public DuplicateDataException(String message) {
        super(message);
    }
}

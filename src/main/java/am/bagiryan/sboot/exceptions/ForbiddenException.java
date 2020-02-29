package am.bagiryan.sboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends Exception {
        public ForbiddenException(String message) {
            super(message);
        }

    public static void check(boolean expresion, String message) throws ForbiddenException {
        if (expresion){
            throw new ForbiddenException(message);
        }
    }
}

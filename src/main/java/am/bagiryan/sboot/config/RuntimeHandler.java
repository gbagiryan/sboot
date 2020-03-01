package am.bagiryan.sboot.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;

@ControllerAdvice
public class RuntimeHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity handleRuntime(RuntimeException runtimeException, WebRequest webRequest) {
/*        if (runtimeException instanceof ValidationException){
            throw runtimeException;
        }*/
            return ResponseEntity.status(500).body("Something went wrong");
    }

}

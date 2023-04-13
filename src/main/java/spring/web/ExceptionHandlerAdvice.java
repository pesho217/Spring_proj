package spring.web;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.error.InvalidObjectPropertiesException;
import spring.error.NotfoundObjectException;

import java.io.InvalidObjectException;
import java.util.Map;
import java.util.UUID;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidObjectPropertiesException.class)
    public ResponseEntity<GenericExeptionBody> handleInvalidObjectException(
            InvalidObjectPropertiesException ex) {

        GenericExeptionBody exceptionBody =
                new GenericExeptionBody(ex.getErrorId(), ex.getMessage(), ex.getErrors(), null);
        return ResponseEntity.badRequest().body(exceptionBody);
    }


    @ExceptionHandler(NotfoundObjectException.class)
    public ResponseEntity<GenericExeptionBody> handleObjectNotFoundException(
            NotfoundObjectException ex) {

        GenericExeptionBody exceptionBody = new GenericExeptionBody(ex.getErrorId(),
                ex.getMessage() + ": " + ex.getId(), null, ex.getObjectClazz());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionBody);
    }

    @Data
    private static class GenericExeptionBody {
        private final UUID id;
        private final String message;
        private final Map<String, String> errors;
        private final String clazz;

        public GenericExeptionBody(UUID id, String message, Map<String, String> errors,
                                   String clazz) {
            this.id = id;
            this.message = message;
            this.errors = errors;
            this.clazz = clazz;
        }

    }

}

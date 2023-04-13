package spring.error;

import java.util.Map;

public class InvalidObjectPropertiesException extends PersonsApiBaseException {
    private final Map<String, String> errors;

    public InvalidObjectPropertiesException(String message, Map<String, String> errors){
        super(message);
        this.errors = errors;
    }
    public Map<String, String> getErrors(){
        return errors;
    }


}

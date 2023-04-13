package spring.error;

import java.util.UUID;

public class PersonsApiBaseException extends RuntimeException{
    private final UUID errorId;

    public UUID getErrorId() {
        return errorId;
    }

    public PersonsApiBaseException(String message){
        super(message);
        this.errorId = UUID.randomUUID();
    }

}

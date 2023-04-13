package spring.error;

public class NotfoundObjectException extends PersonsApiBaseException{

    private String ObjectClazz;
    private String id;

    public NotfoundObjectException(String message, String ObjectClazz, String id){
        super(message);
        this.ObjectClazz = ObjectClazz;
        this.id = id;
    }

    public String getObjectClazz() {
        return ObjectClazz;
    }

    public String getId() {
        return id;
    }
}

package spring.web.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;



@Data
@Builder
public class PersonResponse {

    private UUID id;
    private String name;
    private int age;
    private AddressDto address;
    private String egnNumber;

}

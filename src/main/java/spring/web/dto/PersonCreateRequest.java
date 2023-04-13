package spring.web.dto;

import org.hibernate.validator.constraints.Range;
import lombok.Builder;
import lombok.Data;
import spring.validation.ValidEgn;

@Data
@Builder
public class PersonCreateRequest {

    private String name;
    @Range(min = 0, max = 200, message = "i like ages from 0 to 200")
    private Integer age;

    private AddressDto address;

    @ValidEgn(message = "Persons EGN shçould have exactly 10 chars")
    private String egnNumber;

}

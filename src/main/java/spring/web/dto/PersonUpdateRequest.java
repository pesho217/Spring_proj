package spring.web.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@Builder
public class PersonUpdateRequest {

    private String name;
    @Range(min = 0, max = 200, message = "i like ages from 0 to 200")
    private Integer age;

    private AddressDto address;
}


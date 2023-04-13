package spring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import spring.model.Person;
import spring.web.dto.PersonCreateRequest;
import spring.web.dto.PersonResponse;
import spring.web.dto.PersonUpdateRequest;

import java.util.List;

@Mapper(uses = AddressMapper.class)
@Component
public interface PersonMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "photos", ignore = true)
    Person modelFromCreateRequest(PersonCreateRequest personCreateDto);

    PersonResponse responseFromModel(Person person);

    @Mapping(target = "photos", ignore = true)
    @Mapping(target = "egnNumber", ignore = true)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "age", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "address", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(PersonUpdateRequest personUpdateDto, @MappingTarget Person person);

    List<PersonResponse> listOfModelToListOfDto(Iterable<Person> persons);
}



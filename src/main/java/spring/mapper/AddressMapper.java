package spring.mapper;

import org.mapstruct.Mapper;
import spring.model.Address;
import spring.web.dto.AddressDto;


@Mapper
public interface AddressMapper {

    AddressDto modelToDto(Address address);
    Address dtoToModel(AddressDto addressDto);
}

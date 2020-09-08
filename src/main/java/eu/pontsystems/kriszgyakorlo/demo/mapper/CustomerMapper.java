package eu.pontsystems.kriszgyakorlo.demo.mapper;

import eu.pontsystems.kriszgyakorlo.demo.dto.CustomerDto;
import eu.pontsystems.kriszgyakorlo.demo.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "color", target = "favouriteColor")
    CustomerDto customerToCustomerDto(Customer customer);
}

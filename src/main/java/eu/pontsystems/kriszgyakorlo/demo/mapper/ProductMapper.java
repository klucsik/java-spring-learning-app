package eu.pontsystems.kriszgyakorlo.demo.mapper;

import eu.pontsystems.kriszgyakorlo.demo.dto.ProductDto;
import eu.pontsystems.kriszgyakorlo.demo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "customer", target = "customerDto")
    ProductDto productToDto(Product customer);

    @Mapping(source = "customerDto", target = "customer")
    Product dtoToProduct(ProductDto customerDto);


}

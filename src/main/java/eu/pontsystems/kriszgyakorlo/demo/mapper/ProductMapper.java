package eu.pontsystems.kriszgyakorlo.demo.mapper;

import eu.pontsystems.kriszgyakorlo.demo.dto.ProductDto;
import eu.pontsystems.kriszgyakorlo.demo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto productToDto(Product customer);

    Product dtoToProduct(ProductDto customerDto);


}

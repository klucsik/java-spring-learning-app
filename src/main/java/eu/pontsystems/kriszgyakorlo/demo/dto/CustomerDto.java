package eu.pontsystems.kriszgyakorlo.demo.dto;

import eu.pontsystems.kriszgyakorlo.demo.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;
    private String favouriteColor;
    private List<ProductDto> productDtos;
}

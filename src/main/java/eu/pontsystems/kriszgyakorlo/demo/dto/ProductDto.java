package eu.pontsystems.kriszgyakorlo.demo.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ProductDto {
    private Long id;
    private String Name;
    private Integer Price;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdatedAt;
}

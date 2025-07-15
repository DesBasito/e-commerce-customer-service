package kg.manurov.ecommerce.customer;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class Address {
    String street;
    String houseNumber;
    String zipCode;
}

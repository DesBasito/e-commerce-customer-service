package kg.manurov.ecommerce.customer;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {
    @Id
    String id;
    String firstName;
    String lastName;
    String email;
    Address address;
}

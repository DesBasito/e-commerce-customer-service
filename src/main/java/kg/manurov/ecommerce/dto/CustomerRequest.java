package kg.manurov.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kg.manurov.ecommerce.customer.Address;

public record CustomerRequest(
        String id,

        @NotNull(message = "first name is required!")
        @NotBlank(message = "first name is should not to be blank or empty!")
        String firstName,

        @NotNull(message = "last name is required!")
        @NotBlank(message = "last name is should not to be blank or empty!")
        String lastName,

        @Email
        @NotNull(message = "email name is required!")
        @NotBlank(message = "email is should not to be blank or empty!")
        String email,

        Address address
) {
}

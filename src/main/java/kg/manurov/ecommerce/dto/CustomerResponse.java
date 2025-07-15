package kg.manurov.ecommerce.dto;

import kg.manurov.ecommerce.customer.Address;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        Address address
){}

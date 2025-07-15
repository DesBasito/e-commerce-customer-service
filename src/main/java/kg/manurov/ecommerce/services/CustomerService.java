package kg.manurov.ecommerce.services;

import jakarta.validation.Valid;
import kg.manurov.ecommerce.customer.Customer;
import kg.manurov.ecommerce.dto.CustomerRequest;
import kg.manurov.ecommerce.dto.CustomerResponse;
import kg.manurov.ecommerce.errors.CustomerNotFoundException;
import kg.manurov.ecommerce.mapper.CustomerMapper;
import kg.manurov.ecommerce.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    public String createCustomer(CustomerRequest customerRequest) {
        Customer customer = repository.save(mapper.toCustomer(customerRequest));
        return customer.getId();
    }

    public void updateCustomer(CustomerRequest request) {
        Customer customer = repository.findById(request.id()).orElseThrow(() -> new CustomerNotFoundException(
            String.format("Cannot update customer: No customer found with the provided ID:: %s%n", request.id())
        ));

        mergeCustomer(customer, request);
        repository.save(customer);

    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstName())){
            customer.setFirstName(request.firstName());
        }
        if (StringUtils.isNotBlank(request.lastName())){
            customer.setLastName(request.lastName());
        }
        if (StringUtils.isNotBlank(request.email())){
            customer.setEmail(request.email());
        }
        if (request.address() != null){
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public Boolean existsById(String id) {
        return repository.findById(id).isPresent();
    }

    public CustomerResponse findById(String id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new CustomerNotFoundException(
                String.format("No customer found with the provided ID:: %s%n", id)
        ));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}

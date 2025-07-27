package kg.manurov.ecommerce.controller;

import jakarta.validation.Valid;
import kg.manurov.ecommerce.dto.CustomerRequest;
import kg.manurov.ecommerce.dto.CustomerResponse;
import kg.manurov.ecommerce.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest customerRequest){
        return ResponseEntity.ok(service.createCustomer(customerRequest));
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(@RequestBody @Validated CustomerRequest request){
        service.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/esists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable("id") String id){
        return ResponseEntity.ok(service.existsById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findByById(@PathVariable("id") String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByById(@PathVariable("id") String id){
        service.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}

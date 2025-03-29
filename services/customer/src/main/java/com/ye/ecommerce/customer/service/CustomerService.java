package com.ye.ecommerce.customer.service;

import com.ye.ecommerce.customer.entity.Customer;
import com.ye.ecommerce.customer.exception.CustomerNotFoundException;
import com.ye.ecommerce.customer.mapper.CustomerMapper;
import com.ye.ecommerce.customer.models.CustomerRequest;
import com.ye.ecommerce.customer.models.CustomerResponse;
import com.ye.ecommerce.customer.repo.CustomerRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.String.format;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequest request){

        var customer = customerRepository.save(mapper.toCustomer(request));

        return customer.getId();
    }

    public void updateCustomer ( CustomerRequest request ) {

        var customer = customerRepository.findById(request.id()).orElseThrow(
                () -> new CustomerNotFoundException(
                        format("Cannot update customer:: No Customer with provided ID :: %s" , request.id())
                )
        );

        mergerCustomer(customer , request);
        customerRepository.save(customer);
    }

    public List<CustomerResponse> findAllCustomer(){
        return customerRepository.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    private void mergerCustomer(Customer customer, CustomerRequest request){
        if (StringUtils.isNotBlank(request.firstName())){
            customer.setFirstName(request.firstName());
        }
        if (StringUtils.isNotBlank(request.lastName())){
            customer.setLastName(request.lastName());
        }
        if (StringUtils.isNotBlank(request.email())){
            customer.setEmail(request.email());
        }
        if ( request.address() != null){
            customer.setAddress(request.address());
        }
    }


    public Boolean existsById(String customerId) {
        return customerRepository.findById(customerId).isPresent();
    }

    public CustomerResponse findCustomerById(String customerId) {
        return customerRepository.findById(customerId)
                .map(mapper::fromCustomer)
                .orElseThrow( () -> new CustomerNotFoundException(format("No Customer found with the provided ID :: %s " , customerId)));
    }

    public void deleteCustomerById(String customerId) {
        customerRepository.deleteById(customerId);
    }
}

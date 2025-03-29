package com.ye.ecommerce.customer.models;

import com.ye.ecommerce.customer.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
         String id ,
         @NotNull(message="Customer First Name is required") String firstName ,
         @NotNull(message="Customer Last Name is required")  String lastName ,
         @NotNull(message="Customer Email is required")
         @Email(message = "Customer email is not a valid email address")
         String email ,
         Address address

) {
}

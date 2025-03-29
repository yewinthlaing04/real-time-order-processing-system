package com.ye.ecommerce.customer.models;

import com.ye.ecommerce.customer.entity.Address;

public record CustomerResponse (
        String id,
        String firstName ,
        String lastName ,
        String email,
        Address address
) {
}

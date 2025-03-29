package com.ye.ecommerce.customer.repo;

import com.ye.ecommerce.customer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer , String> {
}

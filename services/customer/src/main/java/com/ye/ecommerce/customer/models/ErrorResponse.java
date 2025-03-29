package com.ye.ecommerce.customer.models;

import java.util.Map;

public record ErrorResponse (
        Map<String , String> errors
){
}

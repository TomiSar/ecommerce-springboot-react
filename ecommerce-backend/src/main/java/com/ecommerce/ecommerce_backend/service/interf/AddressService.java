package com.ecommerce.ecommerce_backend.service.interf;

import com.ecommerce.ecommerce_backend.dto.AddressDto;
import com.ecommerce.ecommerce_backend.dto.Response;

public interface AddressService {

    Response saveAndUpdateAddress(AddressDto addressDto);

}

package com.conductor.challengecdt.service;

import com.conductor.challengecdt.controller.dto.AddressDto;
import org.hibernate.ObjectNotFoundException;

/**
 * class represantation
 */

public interface AddressService {

    /**
     * Method for persist entity address 
     *
     * @param addressDto object dto of address
     * @return return address persisted
     */
    AddressDto save(AddressDto addressDto);


    /**
     * Method for search Address by Id
     * @param id identity Entity Address
     * @return address if it exists in the database
     * @throws ObjectNotFoundException if not found in the database
     */
    AddressDto findById(Long id) throws ObjectNotFoundException;


    /**
     * Method for update Address entity
     *
     * @param addressDto objecto dto of address
     * @return address object persisted
     */
    AddressDto update(AddressDto addressDto);
}

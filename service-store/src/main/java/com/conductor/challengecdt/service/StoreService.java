package com.conductor.challengecdt.service;

import com.conductor.challengecdt.controller.dto.AddressDto;
import com.conductor.challengecdt.controller.dto.StoreDto;
import org.hibernate.ObjectNotFoundException;

/**
 * class represantation
 */

public interface StoreService {

    /**
     * Method for persist entity store
     *
     * @param storeDto object dto of store
     * @return return store persisted
     */
    StoreDto save(StoreDto storeDto);


    /**
     * Method for search Store by Id
     * @param id identity Entity Store
     * @return store if it exists in the database
     * @throws ObjectNotFoundException if not found in the database
     */
    StoreDto findById(Long id);


    /**
     * Method for update Store entity
     *
     * @param storeDto objecto dto of store
     * @return store object persisted
     */
    StoreDto update(Long id, StoreDto storeDto);

    /**
     * Method for updatePartial Store entity
     *
     * @param id identity store for update address
     * @param addressDto objecto dto of store
     * @return store object persisted
     */
    StoreDto updateAddressStore(final Long id, final AddressDto addressDto);
}

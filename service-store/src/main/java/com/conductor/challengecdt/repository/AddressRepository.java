package com.conductor.challengecdt.repository;

import com.conductor.challengecdt.model.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * interface to represent address entity repository contracts
 *
 * @author Rodrigo
 */
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
}

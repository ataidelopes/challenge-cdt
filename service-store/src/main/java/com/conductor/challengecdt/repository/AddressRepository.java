package com.conductor.challengecdt.repository;

import com.conductor.challengecdt.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

/**
 * interface to represent address entity repository contracts
 *
 * @author Rodrigo
 */
public interface AddressRepository extends JpaRepository<Address, Long> {
}

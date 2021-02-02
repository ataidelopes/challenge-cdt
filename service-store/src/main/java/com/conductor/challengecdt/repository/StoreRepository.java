package com.conductor.challengecdt.repository;

import com.conductor.challengecdt.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * interface to represent store entity repository contracts
 *
 * @author Rodrigo
 */
public interface StoreRepository extends JpaRepository<Store, Long> {
}

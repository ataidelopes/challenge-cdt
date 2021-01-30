package com.conductor.challengecdt.service.impl;

import com.conductor.challengecdt.controller.dto.StoreDto;
import com.conductor.challengecdt.controller.mapper.StoreMapper;
import com.conductor.challengecdt.model.Store;
import com.conductor.challengecdt.repository.StoreRepository;
import com.conductor.challengecdt.service.StoreService;
import com.conductor.challengecdt.util.exceptions.BusinessRulesExceptions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * class represantation
 */
@Service
@Transactional
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    @Override
    public StoreDto save(StoreDto storeDto) {
        Store storeSaved = storeRepository.save(mapperStoreDtoForEntity(storeDto));
        return storeMapper.map(storeSaved, StoreDto.class);
    }

    @Override
    public StoreDto findById(Long id) throws ObjectNotFoundException {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Store.class.getName()));
        return storeMapper.map(store, StoreDto.class);
    }

    @Override
    public StoreDto update(StoreDto storeDto) {
        Store store = storeRepository.save(mapperStoreDtoForEntity(storeDto));
        return storeMapper.map(store, StoreDto.class);
    }

    /**
     * method to map a StoreDto object to store entity
     *
     * @param storeDto object for transform in entity
     * @return object mapper to Entity Store
     */
    private Store mapperStoreDtoForEntity(StoreDto storeDto) {
        StoreDto store = Optional.ofNullable(storeDto).orElseThrow(() -> new BusinessRulesExceptions("store object cannot be null"));
        return storeMapper.map(storeDto, Store.class);
    }
}

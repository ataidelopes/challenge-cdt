package com.conductor.challengecdt.service.impl;

import com.conductor.challengecdt.controller.dto.AddressDto;
import com.conductor.challengecdt.controller.dto.StoreDto;
import com.conductor.challengecdt.controller.mapper.StoreMapper;
import com.conductor.challengecdt.model.Store;
import com.conductor.challengecdt.repository.StoreRepository;
import com.conductor.challengecdt.service.AddressService;
import com.conductor.challengecdt.service.StoreService;
import com.conductor.challengecdt.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * class represantation
 */
@Service
@Transactional
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final AddressService addressService;
    private final StoreMapper storeMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public StoreDto save(StoreDto storeDto) {
        AddressDto addressSave = addressService.save(storeDto.getAddress());
        storeDto.setAddress(addressSave);
        Store storeSaved = storeRepository.save(mapperStoreDtoForEntity(storeDto));
        return storeMapper.map(storeSaved, StoreDto.class);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public StoreDto findById(Long id) throws ObjectNotFoundException {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Store.class.getName()));
        return storeMapper.map(store, StoreDto.class);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public StoreDto update(StoreDto storeDto) {
        Store mapper = MapperUtil.map(storeMapper, storeDto, Store.class);
        Store store = storeRepository.save(mapper);
        return storeMapper.map(store, StoreDto.class);
    }

    /**
     * method to converter a StoreDto object to store entity
     *
     * @param storeDto object for transform in entity
     * @return object mapper to Entity Store
     */
    private Store mapperStoreDtoForEntity(StoreDto storeDto) {
        return storeMapper.validateMapperOfNullabe(storeDto, storeMapper).map(storeDto, Store.class);
    }
}

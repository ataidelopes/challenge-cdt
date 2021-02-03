package com.conductor.challengecdt.service.impl;

import com.conductor.challengecdt.controller.dto.AddressDto;
import com.conductor.challengecdt.controller.dto.StoreDto;
import com.conductor.challengecdt.controller.mapper.StoreMapper;
import com.conductor.challengecdt.model.Store;
import com.conductor.challengecdt.repository.StoreRepository;
import com.conductor.challengecdt.service.StoreService;
import common.mapper.PatchMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

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
    @Transactional(propagation = Propagation.REQUIRED)
    public StoreDto save(final StoreDto storeDto) {
        Store storeSaved = storeRepository.save(mapperStoreDtoForEntity(storeDto));
        return storeMapper.map(storeSaved, StoreDto.class);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public StoreDto findById(final Long id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Store.class.getName()));
        return storeMapper.map(store, StoreDto.class);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public StoreDto update(final Long id, final StoreDto storeDto) {
        Store storeFind = storeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Store.class.getName()));
        PatchMapper.changeIfPresentValue(storeDto.getName(), storeFind::setName);
        changeValueForUpdateAddressOfStore(storeDto.getAddress(), storeFind);
        Store store = storeRepository.save(storeFind);

        return storeMapper.map(store, StoreDto.class);
    }

    @Override
    public StoreDto updateAddressStore(final Long id, final AddressDto addressDto) {
        Store storeFind = storeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Store.class.getName()));
        changeValueForUpdateAddressOfStore(addressDto, storeFind);
        Store store = storeRepository.save(storeFind);

        return storeMapper.map(store, StoreDto.class);
    }


    /**
     * method to converter a StoreDto object to store entity
     *
     * @param storeDto object for transform in entity
     * @return object mapper to Entity Store
     */
    private Store mapperStoreDtoForEntity(final StoreDto storeDto) {
        return storeMapper.validateMapperOfNullabe(storeDto, storeMapper).map(storeDto, Store.class);
    }

    /**
     * method to change the address information of a store
     *
     * @param addressDto address of a store
     * @param storeFind  store to be changed
     */
    private void changeValueForUpdateAddressOfStore(final AddressDto addressDto, Store storeFind) {
        if(ObjectUtils.isEmpty(addressDto)) return;

        PatchMapper.changeIfPresentValue(addressDto.getPostalCode(), storeFind.getAddress()::setPostalCode);
        PatchMapper.changeIfPresentValue(addressDto.getComplement(), storeFind.getAddress()::setComplement);
        PatchMapper.changeIfPresentValue(addressDto.getNumber(), storeFind.getAddress()::setNumber);
        PatchMapper.changeIfPresentValue(addressDto.getProvince(), storeFind.getAddress()::setProvince);
        PatchMapper.changeIfPresentValue(addressDto.getStreet(), storeFind.getAddress()::setStreet);
    }

}

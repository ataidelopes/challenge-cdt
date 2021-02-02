package com.conductor.challengecdt.service.impl;

import com.conductor.challengecdt.controller.dto.AddressDto;
import com.conductor.challengecdt.controller.mapper.AddressMapper;
import com.conductor.challengecdt.model.Address;
import com.conductor.challengecdt.repository.AddressRepository;
import com.conductor.challengecdt.service.AddressService;
import com.conductor.challengecdt.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.cfg.NotYetImplementedException;
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
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public AddressDto save(AddressDto addressDto) {
        Address mapper = addressMapper.validateMapperOfNullabe(addressDto, addressMapper)
                .map(addressDto, Address.class);
        Address address = addressRepository.saveAndFlush(mapper);
        return addressMapper.map(address, AddressDto.class);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public AddressDto findById(Long id) throws ObjectNotFoundException {
        Address store = addressRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Address.class.getName()));
        return addressMapper.map(store, AddressDto.class);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public AddressDto update(AddressDto addressDto) {
        throw new NotYetImplementedException("method not implemented");
    }
}

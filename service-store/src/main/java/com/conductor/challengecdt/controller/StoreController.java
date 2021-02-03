package com.conductor.challengecdt.controller;

import com.conductor.challengecdt.controller.dto.AddressDto;
import com.conductor.challengecdt.controller.dto.StoreDto;
import com.conductor.challengecdt.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "v1/stores", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StoreController {

    private final StoreService storeService;

    @PostMapping()
    public ResponseEntity<StoreDto> created(@RequestBody StoreDto store) {
        StoreDto storeDto = storeService.save(store);
        return ResponseEntity.ok(storeDto);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StoreDto> getStore(@PathVariable Long id){
        StoreDto storeDto = storeService.findById(id);
        return ResponseEntity.ok(storeDto);
    }

    @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StoreDto> patchStore(@PathVariable Long id, @RequestBody StoreDto store){
        StoreDto storeDto = storeService.update(id, store);
        return ResponseEntity.ok(storeDto);
    }

    @PatchMapping(path = "/{id}/address", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StoreDto> patchAddressStore(@PathVariable Long id, @RequestBody AddressDto addressDto){
        StoreDto storeDto = storeService.updateAddressStore(id, addressDto);
        return ResponseEntity.ok(storeDto);
    }
}

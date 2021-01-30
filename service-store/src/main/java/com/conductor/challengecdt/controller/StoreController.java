package com.conductor.challengecdt.controller;

import com.conductor.challengecdt.controller.dto.StoreDto;
import com.conductor.challengecdt.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("v1/stores")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StoreController {

    private final StoreService storeService;

    @PostMapping()
    public ResponseEntity<StoreDto> created(@RequestBody StoreDto store) {
        StoreDto storeDto = storeService.save(store);
        return ResponseEntity.ok(storeDto);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StoreDto> getStore(@PathVariable("id") Long id){
        StoreDto storeDto = storeService.findById(id);
        return ResponseEntity.ok(storeDto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StoreDto> putStore(@RequestBody StoreDto store){
        StoreDto storeDto = storeService.update(store);
        return ResponseEntity.ok(storeDto);
    }

}

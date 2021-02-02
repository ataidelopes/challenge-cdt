package com.conductor.serviceorder.controller;


import com.conductor.serviceorder.controller.dto.ItemDto;
import com.conductor.serviceorder.controller.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {


    @PostMapping()
    public ResponseEntity<Void> created(@RequestBody OrderDto order) {
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Void> getOrder(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> putOrder(@RequestBody OrderDto store){
        return ResponseEntity.ok().build();
    }

    @PatchMapping(path = "/{id}/add-item")
    public ResponseEntity<Void> addItemInOrder(@PathVariable Long id, @RequestBody ItemDto itemDto){
        return ResponseEntity.ok().build();
    }

    @PatchMapping(path = "/{id}/make-payment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> finallyPayment(@PathVariable Long id){

        return ResponseEntity.ok().build();
    }

    @PatchMapping(path = "/{id}/repay", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> repayOrder(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }
}

package com.conductor.challengecdt.controller;


import com.conductor.challengecdt.controller.dto.ItemDto;
import com.conductor.challengecdt.controller.dto.OrderDto;
import com.conductor.challengecdt.service.OrderService;
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

    private final OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> created(@RequestBody OrderDto order) {
        OrderDto orderDto = orderService.created(order);
        return ResponseEntity.ok(orderDto);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long id){
        OrderDto orderDto = orderService.findById(id);
        return ResponseEntity.ok(orderDto);
    }

    @PatchMapping(path = "/{id}/add-item")
    public ResponseEntity<OrderDto> patchOrder(@PathVariable Long id, @RequestBody OrderDto ordemDto){
        OrderDto orderUpdated = orderService.update(id, ordemDto);
        return ResponseEntity.ok(orderUpdated);
    }

    @PatchMapping(path = "/{id}/make-payment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> finallyPayment(@PathVariable Long id, @RequestBody String numberCard){
        OrderDto orderDto = orderService.makePayment(id, numberCard);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(path = "/{id}/repay", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> repayOrder(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }
}

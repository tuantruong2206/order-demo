package com.example.order1demo.controller.rest;

import com.example.order1demo.domain.model.Order;
import com.example.order1demo.service.OrderService;
import com.example.order1demo.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    private final Logger log = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    private final static String ENTITY_NAME = "order";

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Get order by Id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Order> getBasketById(@PathVariable Long id) throws Exception {
//        log.info("REST request to get order: {}", id);
        return new ResponseEntity<>(this.orderService.getOrderById(id), HttpStatus.OK);
    }

    /**
     * Get order by orderDTO
     * @param orderDTO
     * @return
     */
    @PostMapping()
    public ResponseEntity<Order> getBasketById(@RequestBody Order orderDTO) throws Exception {
        //TODO need order Validator here
        log.info("REST request to create order: {}", orderDTO);
        Order result = this.orderService.createOrder(orderDTO);
        return ResponseEntity.created(new URI("/order/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
                .body(result);
    }
}

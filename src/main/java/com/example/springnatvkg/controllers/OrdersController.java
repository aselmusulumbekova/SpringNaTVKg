package com.example.springnatvkg.controllers;

import com.example.springnatvkg.configs.Swagger2;
import com.example.springnatvkg.models.request.RequestChannelsText;
import com.example.springnatvkg.models.request.OrdersRequest;
import com.example.springnatvkg.models.response.PriceResponse;
import com.example.springnatvkg.service.OrderDetailService;
import com.example.springnatvkg.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@Api(tags = Swagger2.Orders)
public class OrdersController {
    private final OrderDetailService orderDetailService;

    private final OrdersService service;

    public OrdersController(OrdersService service, OrderDetailService orderDetailService) {
        this.service = service;
        this.orderDetailService = orderDetailService;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    public ResponseEntity<?> save(@RequestBody OrdersRequest ordersRequest){
        orderDetailService.save(ordersRequest);
            return ResponseEntity.ok("Successful");

    }

    @PostMapping("/orders")
    @ApiOperation("")
    public ResponseEntity<PriceResponse> get(@RequestBody RequestChannelsText request) {
        return ResponseEntity.ok(orderDetailService.getTotalPriceAll(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete() {
        try {
            return ResponseEntity.ok("ok");
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

}

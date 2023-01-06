package com.example.springnatvkg.controllers;

import com.example.springnatvkg.configs.Swagger2;
import com.example.springnatvkg.models.dto.OrderDetailsDTO;
import com.example.springnatvkg.models.request.OrdersRequest;
import com.example.springnatvkg.service.OrderDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order/details")
@Api(tags = Swagger2.OrderDetails)
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    public ResponseEntity<?> save(@RequestBody OrdersRequest ordersRequest){
        try {
            System.out.println("test");
            return ResponseEntity.ok(orderDetailService.save(ordersRequest));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}

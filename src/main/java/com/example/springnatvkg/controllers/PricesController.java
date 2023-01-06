package com.example.springnatvkg.controllers;

import com.example.springnatvkg.configs.Swagger2;
import com.example.springnatvkg.models.dto.PricesDTO;
import com.example.springnatvkg.models.request.PriceRequest;
import com.example.springnatvkg.service.PricesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prices")
@Api(tags = Swagger2.Prices)
public class PricesController {
    private final PricesService service;

    public PricesController(PricesService service) {
        this.service = service;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    public ResponseEntity<?> save(@RequestBody PriceRequest request){
        try {
            System.out.println("test");
            return ResponseEntity.ok(service.save(request));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
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

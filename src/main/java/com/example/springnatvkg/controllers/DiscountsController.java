package com.example.springnatvkg.controllers;

import com.example.springnatvkg.configs.Swagger2;
import com.example.springnatvkg.models.dto.DiscountsDTO;
import com.example.springnatvkg.service.DiscountsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/discounts")
@Api(tags = Swagger2.Discounts)
public class DiscountsController {
    private final DiscountsService service;

    public DiscountsController(DiscountsService service) {
        this.service = service;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    public ResponseEntity<?> save(@RequestBody DiscountsDTO discountsDTO){
        try {
            System.out.println("test");
            return ResponseEntity.ok(service.save(discountsDTO));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

}

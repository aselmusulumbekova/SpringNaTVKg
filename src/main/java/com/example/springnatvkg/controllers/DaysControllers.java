package com.example.springnatvkg.controllers;

import com.example.springnatvkg.configs.Swagger2;
import com.example.springnatvkg.models.dto.DaysDTO;
import com.example.springnatvkg.service.DaysService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/days")
@Api(tags = Swagger2.Days)
public class DaysControllers {
    private final DaysService daysService;

    public DaysControllers(DaysService daysService) {
        this.daysService = daysService;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    public ResponseEntity<?> save(@RequestBody DaysDTO daysDTO){
            System.out.println("test");
            return ResponseEntity.ok(daysService.save(daysDTO));
    }

}

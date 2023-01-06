package com.example.springnatvkg.controllers;
import com.example.springnatvkg.configs.Swagger2;
import com.example.springnatvkg.models.dto.ChannelsDTO;
import com.example.springnatvkg.models.response.ChannelsResponse;
import com.example.springnatvkg.service.ChannelsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/api/v1/channels")
@Api(tags = Swagger2.Channels)
public class ChannelsControllers {
    private final ChannelsService service;

    public ChannelsControllers(ChannelsService service) {
        this.service = service;
    }

    @ApiOperation("Сохранение")
    @PostMapping("/save")
    public ChannelsDTO save(@RequestParam String name, @RequestParam int orderNum, @RequestParam MultipartFile photo,int languageId) {

        return service.save(name,orderNum,photo);
    }
    @GetMapping("/find/select")
    @ApiOperation("Найти всех Response")
    public List<ChannelsResponse> getAll(){
        return service.channelsResponse11();
    }
    @GetMapping("/findById")
    @ApiOperation("Найди по ID")
    public ChannelsDTO findById(@RequestParam Long id) {
        return service.findById(id);
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


package com.example.springnatvkg.microservices;

import com.example.springnatvkg.models.response.FileResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;




@FeignClient(name = "${micro.fileService.name}", url = "${micro.fileService.url}")
public interface FileServiceFeign {

//    @PostMapping("/api/v1/file/upload")
//    FileResponse fileUpload(@RequestParam MultipartFile photo);

    @PostMapping(value = "/api/v1/file/upload", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    FileResponse fileUpload(@RequestPart("file") MultipartFile photo);


}

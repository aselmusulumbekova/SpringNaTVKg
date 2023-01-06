package com.example.springnatvkg.models.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileResponse {
     String fileName;
     String downloadUri;
     String fileType;
     long size;

}

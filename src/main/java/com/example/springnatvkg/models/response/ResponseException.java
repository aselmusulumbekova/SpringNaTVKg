package com.example.springnatvkg.models.response;
import com.example.springnatvkg.utols.ResourceBundle;
import com.example.springnatvkg.utols.models.Language;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ResponseException {
    private String message;
    private Object data;


    public static ResponseException getResponse(String message, Language language) {

        return ResponseException.builder()
                .message(message==null ? ResourceBundle.periodMessages(language,"success") :message)
                .build();
    }

    public static ResponseException getErrorResponse(String message) {
        return ResponseException.builder()
                .message(message==null?"Произошла неизвестная ошибка":message)
                .build();
    }

    public static ResponseException getResponseWithBody(String message, Object data) {
        return ResponseException.builder()
                .message(message)
                .data(data)
                .build();
    }

}
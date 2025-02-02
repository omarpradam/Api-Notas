package com.notas.notas.dto;

import org.springframework.stereotype.Component;

@Component
public class RespuestaDto {

    private String message;
    private String code;
    private Object respon;

    public RespuestaDto() {
    }

    public RespuestaDto(String message, String code, Object respon) {
        this.message = message;
        this.code = code;
        this.respon = respon;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getRespon() {
        return respon;
    }

    public void setRespon(Object respon) {
        this.respon = respon;
    }

    @Override
    public String toString() {
        return "ResponsDto [message=" + message + ", code=" + code + ", respon=" + respon + "]";
    }

}

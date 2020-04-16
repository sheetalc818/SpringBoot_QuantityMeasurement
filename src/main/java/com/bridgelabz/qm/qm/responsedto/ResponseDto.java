package com.bridgelabz.qm.qm.responsedto;

public class ResponseDto {
    public int statusCode;
    public String message;
    public Object data;

    public ResponseDto(int statusCode, String message, Object data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
}

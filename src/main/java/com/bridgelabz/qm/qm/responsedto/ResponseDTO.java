package com.bridgelabz.qm.qm.responsedto;

public class ResponseDTO {
    public int statusCode;
    public String message;
    public Object data;

    public ResponseDTO(int statusCode, String message, Object data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
}

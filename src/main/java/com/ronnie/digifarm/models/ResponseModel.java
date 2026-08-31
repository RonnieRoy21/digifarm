package com.ronnie.digifarm.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import java.util.List;



@Getter
@Setter
public class ResponseModel {
    String status;

    Object single;
    List <?> body;

    String error;
    public ResponseModel(String status,Object single,List<?> body,String error){
        this.setStatus(status);
        this.setError(error);
        this.setBody(body);
        this.setSingle(single);
    }
}

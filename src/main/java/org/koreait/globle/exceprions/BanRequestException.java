package org.koreait.globle.exceprions;

import org.springframework.http.HttpStatus;

public class BanRequestException extends CommonException{

    private HttpStatus status;


    public BanRequestException(String message ){
        super(message, HttpStatus.BAD_REQUEST );
    }







}

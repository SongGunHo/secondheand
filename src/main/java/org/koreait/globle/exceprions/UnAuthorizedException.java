package org.koreait.globle.exceprions;

import org.springframework.http.HttpStatus;

public class UnAuthorizedException extends CommonException{


    public UnAuthorizedException(String message){
        super(message, HttpStatus.UNAUTHORIZED);
    }









}

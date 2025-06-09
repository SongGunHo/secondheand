package org.koreait.admin.product.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFondException extends org.koreait.global.exceptions.script.AlertBackException {

    public ProductNotFondException(){
        super("NotFoud.product", HttpStatus.NOT_FOUND);
        setErrorCode(true);
    }



}

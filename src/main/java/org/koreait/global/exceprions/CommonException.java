package org.koreait.global.exceprions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter @Setter
public class CommonException extends RuntimeException {


    private HttpStatus status;
    private  boolean errorCode;




    public  CommonException (String message , HttpStatus status){
            super(message);
            this.status = status;

    }





}

package com.school42.malaga.avaj.exceptions;

public class ParserException extends RuntimeException {
    public ParserException(){
        super();
    }

    public ParserException(String message){
        super(message);
    }
}

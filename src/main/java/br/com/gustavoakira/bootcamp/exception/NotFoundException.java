package br.com.gustavoakira.bootcamp.exception;

import br.com.gustavoakira.bootcamp.util.MessageUtils;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super(MessageUtils.NO_RECORD_FOUND);
    }
}

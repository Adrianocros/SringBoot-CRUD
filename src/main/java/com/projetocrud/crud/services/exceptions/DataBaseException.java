package com.projetocrud.crud.services.exceptions;

import org.hibernate.dialect.lock.PessimisticReadUpdateLockingStrategy;

public class DataBaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public  DataBaseException(String msg){
        super(msg);
    }
}

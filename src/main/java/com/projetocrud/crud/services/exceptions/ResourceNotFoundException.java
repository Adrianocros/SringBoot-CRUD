package com.projetocrud.crud.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    //Retonar a mensagem quando não localiza o ID
    public ResourceNotFoundException(Object id){
       super("Recurso não encontrado ID: " + id);
    }
}

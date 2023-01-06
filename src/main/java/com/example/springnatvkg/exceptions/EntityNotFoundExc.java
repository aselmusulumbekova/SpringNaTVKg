package com.example.springnatvkg.exceptions;

public class EntityNotFoundExc extends RuntimeException{
    public EntityNotFoundExc(String message) {
        super(message);
    }
}

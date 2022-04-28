package com.example.demo17.Exeption;

public class EntityNotFoundExeption extends RuntimeException{
    public EntityNotFoundExeption(){

    }

    public EntityNotFoundExeption(String message){
        super(message);
    }
}

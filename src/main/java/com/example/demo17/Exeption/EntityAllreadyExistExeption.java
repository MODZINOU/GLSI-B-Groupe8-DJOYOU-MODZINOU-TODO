package com.example.demo17.Exeption;

public class EntityAllreadyExistExeption extends RuntimeException{

    public EntityAllreadyExistExeption(){

    }
    public EntityAllreadyExistExeption(String message){
        super(message);
    }
}

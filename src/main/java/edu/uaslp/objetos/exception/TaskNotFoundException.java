package edu.uaslp.objetos.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String Titulo){
        super(Titulo);
    }
}

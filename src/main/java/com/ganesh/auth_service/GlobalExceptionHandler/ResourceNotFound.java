package com.ganesh.auth_service.GlobalExceptionHandler;

public class ResourceNotFound extends RuntimeException {
ResourceNotFound(){
super("Resource not found");
}
public ResourceNotFound(String msg,Long id){
    super(msg+" "+id);

}

}

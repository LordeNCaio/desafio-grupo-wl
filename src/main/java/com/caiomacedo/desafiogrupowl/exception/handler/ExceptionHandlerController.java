package com.caiomacedo.desafiogrupowl.exception.handler;

import com.caiomacedo.desafiogrupowl.exception.collaborator.CollaboratorAlreadyExistsException;
import com.caiomacedo.desafiogrupowl.exception.collaborator.CollaboratorNotFoundException;
import com.caiomacedo.desafiogrupowl.exception.item.ItemAlreadyExistsException;
import com.caiomacedo.desafiogrupowl.exception.item.ItemAlreadyInUseException;
import com.caiomacedo.desafiogrupowl.exception.item.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = CollaboratorAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HandleMessage collaboratorAlreadyExistsException(){
        return new HandleMessage(
                "The given collaborator already exists"
        );
    }

    @ExceptionHandler(value = CollaboratorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HandleMessage collaboratorNotFoundException(){
        return new HandleMessage(
                "The given collaborator was not founded"
        );
    }

    @ExceptionHandler(value = ItemAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HandleMessage itemAlreadyExistsException(){
        return new HandleMessage(
                "The given item already exists"
        );
    }

    @ExceptionHandler(value = ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HandleMessage itemNotFoundException(){
        return new HandleMessage(
                "The given item was not founded"
        );
    }

    @ExceptionHandler(value = ItemAlreadyInUseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HandleMessage itemAlreadyInUseException(){
        return new HandleMessage(
                "The given item already in use by a collaborator"
        );
    }

}

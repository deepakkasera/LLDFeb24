package org.example.exceptions;

public class WrongInputPassedException extends Exception { //Checked Exception
    WrongInputPassedException(String message) {
        super(message);
    }
}

/*
If we extend RunTimeException, that becomes Un Checked Exception.
 */

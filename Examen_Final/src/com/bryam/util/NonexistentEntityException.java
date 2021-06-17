package com.bryam.util;

/**
 * Implementation NonexistentEntityException.
 * 
 * @author DeveUp.
 * @phone 3118938189.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 */
@SuppressWarnings("serial")
public class NonexistentEntityException extends Exception {
	
	///////////////////////////////////////////////////////
	// Builder
	///////////////////////////////////////////////////////
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public NonexistentEntityException(String message) {
        super(message);
    }
}

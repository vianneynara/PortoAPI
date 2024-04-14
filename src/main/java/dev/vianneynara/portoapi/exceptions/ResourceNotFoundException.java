package dev.vianneynara.portoapi.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException() {
		super("Resource could not be found!");
	}
	public ResourceNotFoundException(String message) {
		super(message);
	}
}

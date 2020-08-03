package sda.springbootsecurity.commons;

public class ResourcesNotFound extends RuntimeException {
    public ResourcesNotFound() {
    }

    public ResourcesNotFound(String message) {
        super(message);
    }
}

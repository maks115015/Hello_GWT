package server.exceptions;

/**
 * Created by maks(avto12@i.ua) on 10.02.2016.
 */
public class ClientSideBadCredentialsException extends RuntimeException {
    public ClientSideBadCredentialsException(String message) {
        super(message);}
}

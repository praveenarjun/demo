package dev.praveen.demo.run;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class RunNotFoundException  extends RuntimeException{
    public RunNotFoundException() {
        super("Run Not found");
    }
}

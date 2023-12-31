package aprendendo.api.crudbooks.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException{
    
    public BookNotFoundException() {
        super("Book not found",null,false,false);
    }
}

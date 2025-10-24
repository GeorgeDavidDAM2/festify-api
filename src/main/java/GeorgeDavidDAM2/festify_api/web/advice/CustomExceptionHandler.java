package GeorgeDavidDAM2.festify_api.web.advice;

import GeorgeDavidDAM2.festify_api.utils.exceptions.InvalidFormatIdException;
import GeorgeDavidDAM2.festify_api.utils.exceptions.InvalidIdException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(InvalidIdException.class)
    ProblemDetail handleInvalidIdException(InvalidIdException ex, HttpServletRequest request) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, // codigo de error 404
                ex.getMessage()// recoge el mensaje de la excepcion
        );
        pd.setTitle("El id no es válido");
        pd.setProperty("path", request.getRequestURI());
        return pd;
    }

    @ExceptionHandler(InvalidFormatIdException.class)
    ProblemDetail handleInvalidFormatIdException(InvalidFormatIdException ex, HttpServletRequest request) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST, // codigo de error 400
                ex.getMessage()// recoge el mensaje de la excepcion
        );
        pd.setTitle("El formato del id no es válido");
        pd.setProperty("path", request.getRequestURI());
        return pd;
    }

}
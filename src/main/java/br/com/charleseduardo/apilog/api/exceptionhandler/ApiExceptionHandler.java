package br.com.charleseduardo.apilog.api.exceptionhandler;

import br.com.charleseduardo.apilog.domain.exception.DomainException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var problem = new Problem();
        List<Problem.Fields> fields = new ArrayList<>();

        for (ObjectError error: ex.getBindingResult().getAllErrors()){

            String name = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            fields.add(new Problem.Fields(name, message));

        }
        problem.setStatus(status.value());
        problem.setTitle("One or more fields are invalid. Fill in correctly and try again.");
        problem.setDateHour(LocalDateTime.now());
        problem.setFields(fields);


        return  handleExceptionInternal(ex,problem,headers,status, request);
    }
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Object> domainHandle(DomainException ex, WebRequest request){
        var problem = new Problem();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        problem.setTitle(ex.getMessage());
        problem.setDateHour(LocalDateTime.now());

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }
}

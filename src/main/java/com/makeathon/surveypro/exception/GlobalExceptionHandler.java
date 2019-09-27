package com.makeathon.surveypro.exception;


import com.makeathon.surveypro.model.response.APIResponse;
import com.makeathon.surveypro.util.ExceptionErrorCodes;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({UserAlreadyExistException.class})
    public ResponseEntity<?> userAlreadyExists(UserAlreadyExistException ex, WebRequest request) {
        APIResponse apiResponse = new APIResponse(true, ex.getMessage(), request.getDescription(false), ex.getErrorCode());
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> dataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        APIResponse apiResponse = new APIResponse(true, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<?> parentException(NoHandlerFoundException ex, WebRequest request) {
        APIResponse apiResponse = new APIResponse(true, "Internal server error :" + ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({BadCredentialsException.class, DisabledException.class})
    public ResponseEntity<?> authenticationException(Exception ex, WebRequest request) {
        APIResponse apiResponse = new APIResponse(true, ex.getMessage(), request.getDescription(false),
                ExceptionErrorCodes.BAD_CREDENTAIL.getErrorCode());
        return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({RoleNotFoundException.class})
    public ResponseEntity<?> SignUpSignInException(Exception ex, WebRequest request) {
        APIResponse apiResponse = new APIResponse(true, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

   /* @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //APIResponse apiResponse = new APIResponse(true, ex.getBindingResult().getFieldError().getDefaultMessage(), request.getDescription(false));
        List<APIResponse> fieldError = ex.getBindingResult().getAllErrors().
                stream().
                map(x -> new APIResponse(true, ValidationError.getMessage(x.getDefaultMessage()), Integer.parseInt(x.getDefaultMessage()))).
                collect(Collectors.toList());
        return new ResponseEntity<>(fieldError, HttpStatus.BAD_REQUEST);
    }*/

}

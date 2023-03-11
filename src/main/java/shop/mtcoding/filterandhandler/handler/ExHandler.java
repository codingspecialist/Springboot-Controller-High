package shop.mtcoding.filterandhandler.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shop.mtcoding.filterandhandler.dto.ResponseDto;
import shop.mtcoding.filterandhandler.handler.ex.RestControllerException;
import shop.mtcoding.filterandhandler.handler.ex.ControllerException;
import shop.mtcoding.filterandhandler.util.Script;

@RestControllerAdvice
public class ExHandler {

    @ExceptionHandler(ControllerException.class)
    public String controllerException(ControllerException e){
        return Script.back(e.getMessage());
    }

    @ExceptionHandler(RestControllerException.class)
    public ResponseEntity<?> restControllerException(RestControllerException e){
        ResponseDto<?> responseDto = new ResponseDto<>(e.getMessage());
        return new ResponseEntity<>(responseDto, e.getHttpStatus());
    }
}

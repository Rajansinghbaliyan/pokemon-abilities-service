package io.cherrytechnologies.abilitiesservice.controller;

import io.cherrytechnologies.abilitiesservice.dto.ResponseDto;
import io.cherrytechnologies.abilitiesservice.exceptions.AbilityNotAbailable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExpectionHandling {

    @ExceptionHandler(AbilityNotAbailable.class)
    public ResponseEntity<ResponseDto<String>> handleAbilityNotAvailable(AbilityNotAbailable exception){
        return ResponseEntity
                .badRequest()
                .body(new ResponseDto<>(exception.getMessage()));
    }
}

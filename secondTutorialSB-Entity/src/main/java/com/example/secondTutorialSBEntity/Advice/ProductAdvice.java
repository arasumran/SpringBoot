package com.example.secondTutorialSBEntity.Advice;

import com.example.secondTutorialSBEntity.Utils.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ProductAdvice {

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDTO proccesNullPointerException(NullPointerException ex)
    {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setMessage("Something Goes Wrong, please check your request");
        messageDTO.setType("ERROR");

        return messageDTO;

    }


}

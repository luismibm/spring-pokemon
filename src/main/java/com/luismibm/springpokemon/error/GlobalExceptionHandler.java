package com.luismibm.springpokemon.error;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handle(Exception ex, Model model) {
        model.addAttribute("errorTitle1", "Ups! Algo ha salido mal");
        model.addAttribute("errorTitle2", "🍁 Aprende a programar hippie 🍁");
        model.addAttribute("errorBody", "Esto no pasaría si pasaras menos tiempo en el parque y más programando!");
        return "errorPage";
    }

}
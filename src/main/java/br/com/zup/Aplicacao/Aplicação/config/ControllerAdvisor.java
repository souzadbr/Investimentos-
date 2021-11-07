package br.com.zup.Aplicacao.Aplicação.config;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemError> manipulacaoValidacoes(MethodArgumentNotValidException exception){
        List<MensagemError>mensagens = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()) {
            MensagemError mensagemError = new MensagemError(fieldError.getField(), fieldError.getDefaultMessage());
            mensagens.add(mensagemError);

        }
        return mensagens;
    }

}

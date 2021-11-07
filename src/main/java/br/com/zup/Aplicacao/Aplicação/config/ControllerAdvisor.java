package br.com.zup.Aplicacao.Aplicação.config;

import br.com.zup.Aplicacao.Aplicação.MensagemDeErroRisco;
import br.com.zup.Aplicacao.Aplicação.ValorBaixoParaRiscoALtoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    //retorna erros das validações feitas com anotações
    public List<MensagemError> manipulacaoValidacoes(MethodArgumentNotValidException exception){
        List<MensagemError>mensagens = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()) {
            MensagemError mensagemError = new MensagemError(fieldError.getField(), fieldError.getDefaultMessage());
            mensagens.add(mensagemError);

        }
        return mensagens;
    }

    @ExceptionHandler(ValorBaixoParaRiscoALtoException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErroRisco manipularExcecaoDeRiscoAltoeValorBaixo (ValorBaixoParaRiscoALtoException exception){
        return new MensagemDeErroRisco(exception.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErroRisco manipularexcecaoDeEnumInvalido(HttpMessageNotReadableException exception){
        return new MensagemDeErroRisco("Risco não encontrado");
    }


}

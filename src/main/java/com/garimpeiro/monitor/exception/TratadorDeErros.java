package com.garimpeiro.monitor.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Avisa o Spring: "Fique de olho em todos os Controllers!"
public class TratadorDeErros {

    // Diz ao Spring para capturar apenas os erros de Validação (os nossos @NotBlank, etc)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Mantém o status 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> lidarComErrosDeValidacao(MethodArgumentNotValidException ex) {
        
        // Cria um dicionário vazio para guardar os erros (ex: "precoAtual" -> "não pode ser negativo")
        Map<String, String> erros = new HashMap<>();
        
        // Pega aquela lista gigante de erros do Java e varre um por um
        ex.getBindingResult().getAllErrors().forEach((erro) -> {
            // Descobre qual variável deu erro (ex: titulo)
            String nomeDoCampo = ((FieldError) erro).getField();
            // Pega aquela mensagem amigável que escrevemos na classe Item
            String mensagemDeErro = erro.getDefaultMessage();
            
            // Coloca no dicionário
            erros.put(nomeDoCampo, mensagemDeErro);
        });
        
        // Devolve o dicionário limpinho para quem fez a requisição
        return erros;
    }
}

package com.grupoacert.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

     public static final String MENSAGEM_GLOBAL_400 = "Requisição inválida.";

     public static final String MENSAGEM_GLOBAL_404 = "Recurso não encontrado.";

     public static final String MENSAGEM_GLOBAL_500 = "Erro interno do sistema.";

     public static final String MENSAGEM_GLOBAL_204 = "Nenhum conteúdo.";

     public static final String MENSAGEM_GLOBAL_201 = "Objeto criado.";
     
     public static final String MENSAGEM_GLOBAL_200 = "Sucesso na requisição.";
   
}
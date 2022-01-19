package com.grupoacert.controller;

import static com.grupoacert.exception.GlobalExceptionHandler.MENSAGEM_GLOBAL_400;
import static com.grupoacert.exception.GlobalExceptionHandler.MENSAGEM_GLOBAL_404;
import static com.grupoacert.exception.GlobalExceptionHandler.MENSAGEM_GLOBAL_500;

import java.util.Collection;

import org.springframework.http.ResponseEntity;

import com.grupoacert.exception.ErroInfo;
import com.grupoacert.model.Historico;
import com.grupoacert.model.request.HistoricoRequest;
import com.grupoacert.model.response.HistoricoResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "/historico", produces = "application/json", tags = { "Histórico" }, description = "Operações para calcular temperatura")
public interface HistoricoDefinition {

	@ApiOperation(value = "listarHistorico", notes = "Realiza a consulta do documento", code = 200 ,response = Historico.class)
    @ApiResponses({
            @ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
            @ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
            @ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class)
    })
	ResponseEntity<Collection<Historico>> listarHistorico();
	
	@ApiOperation(value = "cadastraHistorico", notes = "Realiza o cálculo de conversão da temperatura e o cadastro do histórico", code = 201 ,response = HistoricoResponse.class)
    @ApiResponses({
            @ApiResponse(code = 400, message = MENSAGEM_GLOBAL_400, response = ErroInfo.class),
            @ApiResponse(code = 404, message = MENSAGEM_GLOBAL_404, response = ErroInfo.class),
            @ApiResponse(code = 500, message = MENSAGEM_GLOBAL_500, response = ErroInfo.class)
    })
	ResponseEntity<HistoricoResponse> cadastraHistorico(HistoricoRequest request);
}

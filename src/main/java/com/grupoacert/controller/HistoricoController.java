package com.grupoacert.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grupoacert.model.Historico;
import com.grupoacert.model.request.HistoricoRequest;
import com.grupoacert.model.response.HistoricoResponse;
import com.grupoacert.service.HistoricoService;

@RestController
@RequestMapping("/historico")
public class HistoricoController implements HistoricoDefinition {

	@Autowired
	private HistoricoService service;
	
	@GetMapping
	@ResponseStatus(HttpStatus.CREATED) 
	public @ResponseBody ResponseEntity<Collection<Historico>> listarHistorico(){
		return ok(service.findAll());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED) 
	public ResponseEntity<HistoricoResponse> cadastraHistorico(@RequestBody @Valid HistoricoRequest request) {
		return ok(service.create(request));
	}
	
}

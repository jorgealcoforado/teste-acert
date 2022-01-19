package com.grupoacert.service;

import java.util.List;

import com.grupoacert.model.Historico;
import com.grupoacert.model.request.HistoricoRequest;
import com.grupoacert.model.response.HistoricoResponse;

public interface HistoricoService {

	List<Historico> findAll();
	
	HistoricoResponse create(HistoricoRequest historico);
	
}

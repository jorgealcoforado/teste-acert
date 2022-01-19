package com.grupoacert.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoacert.model.Historico;
import com.grupoacert.model.request.HistoricoRequest;
import com.grupoacert.model.response.HistoricoResponse;
import com.grupoacert.repository.HistoricoRepository;

@Service
public class HistoricoServiceImpl implements HistoricoService {

	@Autowired
	private HistoricoRepository repository;
	
	@Override
	public List<Historico> listarHistorico() {
		return repository.findAll();
	}

	@Override
	public HistoricoResponse cadastraHistorico(HistoricoRequest request) {
		
		HistoricoResponse response;
		
		if(StringUtils.equalsIgnoreCase(request.getEscala(), "C")) {
			Historico historico = Historico.builder()
						.celsius(request.getTemperatura())
						.fahrenheit(celsiusParaFahrenheit(request.getTemperatura()))
						.dataCadastro(new Date())
						.build();
			repository.save(historico);
			
			response = HistoricoResponse.builder()
											.retorno(historico.getCelsius() + " graus Celsius equivale a " + historico.getFahrenheit() + " Fahrenheit")
											.build();
		} else if(StringUtils.equalsIgnoreCase(request.getEscala(), "F")) {
			Historico historico = Historico.builder()
						.celsius(fahrenheitParaCelsius(request.getTemperatura()))
						.fahrenheit(request.getTemperatura())
						.dataCadastro(new Date())
						.build();
			repository.save(historico);
			
			response = HistoricoResponse.builder()
					.retorno(historico.getFahrenheit() + " graus Celsius equivale a " + historico.getCelsius() + " Fahrenheit")
					.build();
		}else {
			response = HistoricoResponse.builder()
					.retorno("Sem processamento")
					.build();
		}
		
		return response;
	}
	
	private float celsiusParaFahrenheit(float celsius) {
		return (1.8f * celsius) + 32;
	}
	
	private float fahrenheitParaCelsius(float fahrenheit) {
		return (fahrenheit - 32)/1.8f;
	}
	
}

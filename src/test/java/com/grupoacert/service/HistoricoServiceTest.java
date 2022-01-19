package com.grupoacert.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupoacert.model.request.HistoricoRequest;
import com.grupoacert.model.response.HistoricoResponse;

@SpringBootTest
public class HistoricoServiceTest {

	@Mock
	private HistoricoService serviceMock;
	
	@Autowired
	private HistoricoService service;
		
	@Test
	public void cadastraHistorico() throws JsonMappingException, JsonProcessingException {
		
		HistoricoRequest request = new ObjectMapper().readValue(buildRequest(), HistoricoRequest.class);

        when(serviceMock.cadastraHistorico(request)).thenReturn(buildResponse());

        final HistoricoResponse responseMock = serviceMock.cadastraHistorico(request);
        
        final HistoricoResponse response = service.cadastraHistorico(request);

        assertNotNull(responseMock);
        assertNotNull(response);
        
        assertEquals(responseMock.getRetorno(), response.getRetorno());
	}
	
	private String buildRequest(){
        String request = "{\r\n"
        		+ "  \"escala\": \"C\",\r\n"
        		+ "  \"temperatura\": 33.5\r\n"
        		+ "}";
        return request;
	}
	
	private HistoricoResponse buildResponse(){
		HistoricoResponse response = HistoricoResponse.builder().retorno("33.5 graus Celsius equivale a 92.3 Fahrenheit").build();
        return response;
   }
	
}

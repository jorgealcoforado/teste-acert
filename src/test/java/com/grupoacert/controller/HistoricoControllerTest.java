package com.grupoacert.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.grupoacert.model.request.HistoricoRequest;
import com.grupoacert.model.response.HistoricoResponse;
import com.grupoacert.service.HistoricoService;

@SpringBootTest
@AutoConfigureMockMvc
public class HistoricoControllerTest {

	@Mock
    private HistoricoService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void cadastraHistoricoSucesso()throws Exception{
        when(service.cadastraHistorico(any(HistoricoRequest.class))).thenReturn(buildResponse());

        mockMvc.perform(post("/historico")
                        .content(buildRequest())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.retorno", equalTo("33.5 graus Celsius equivale a 92.3 Fahrenheit")))
                .andExpect(status().isOk());
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

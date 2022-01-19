package com.grupoacert.model.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class HistoricoRequest implements Serializable {

	@NotNull(message = "Campo nao pode ser vazio ou nulo")
    @ApiModelProperty(value = "Tipo de escala do valor da temperatura: C(CELSIUS) ou F(FAHRENHEIT)", example = "C", position = 1)
	private String escala;
	
	@NotNull(message = "Campo nao pode ser vazio ou nulo")
    @ApiModelProperty(value = "Valor da temperatura a ser convertida", example = "33.5", position = 2)
	private float temperatura;
	
}
